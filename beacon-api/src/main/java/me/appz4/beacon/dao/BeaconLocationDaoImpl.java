package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.Beacon;
import me.appz4.beacon.model.model.BeaconLocation;
import me.appz4.beacon.model.model.Position;
import org.hibernate.Query;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.TimestampType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BeaconLocationDaoImpl extends BaseDaoImpl<BeaconLocation> implements BeaconLocationDao {

    public BeaconLocationDaoImpl() {
        super(BeaconLocation.class);
    }

    @Nullable
    @Override
    @Transactional(value = "services", propagation = Propagation.MANDATORY)
    public List<BeaconLocation> findAllMostRecent(@NotNull Position ne, @NotNull Position sw, @NotNull Position nw, List<Long> beaconIds) {
        if (beaconIds == null || beaconIds.isEmpty()) {
            return null;
        }
        Query q = getCurrentSession().createNativeQuery(sql)
                .addScalar(Beacon.ID, IntegerType.INSTANCE)
                .addScalar(BeaconLocation.Companion.getBEACONID(), IntegerType.INSTANCE)
                .addScalar(BeaconLocation.Companion.getLATITUDE(), DoubleType.INSTANCE)
                .addScalar(BeaconLocation.Companion.getLONGITUDE(), DoubleType.INSTANCE)
                .addScalar(Beacon.USERID, IntegerType.INSTANCE)
                .addScalar(BeaconLocation.Companion.getCREATED(), TimestampType.INSTANCE)
                .setParameter("beaconIds", beaconIds);

        List<Object[]> resultList = q.list();

        if (resultList == null) {
            return null;
        }
        List<BeaconLocation> beaconLocations = new ArrayList<>();
        for (Object[] object : resultList) {
            BeaconLocation bl = new BeaconLocation();
            bl.setId(((Integer) object[0]).longValue());
            bl.setBeaconId(((Integer) object[1]).longValue());
            bl.setLatitude((Double) object[2]);
            bl.setLongitude((Double) object[3]);
            bl.setUserId(((Integer) object[4]).longValue());
            bl.setCreated((Timestamp) object[5]);
            beaconLocations.add(bl);
        }
        return beaconLocations;
    }

    private String sql = "select bl.id, bl.beaconId, bl.latitude, bl.longitude, bl.userId, bl.created\n" +
            "from (select beaconId,\n" +
            "             max(created) as created_at\n" +
            "      from beacon_locations\n" +
            "      group by beaconId) as latest_beacon_locations\n" +
            "         inner join beacon_locations bl\n" +
            "                    on (bl.beaconId = latest_beacon_locations.beaconId AND\n" +
            "                        bl.created = latest_beacon_locations.created_at)\n" +
            "WHERE bl.beaconId in (:beaconIds)\n" +
            "group by bl.beaconId\n" +
            "order by bl.beaconId;";
}
