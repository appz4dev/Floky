package me.appz4.beacon.service;

import me.appz4.beacon.dao.BeaconDao;
import me.appz4.beacon.dao.BeaconLocationDao;
import me.appz4.beacon.dao.BeaconManufacturerDao;
import me.appz4.beacon.dao.ImageDao;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.model.*;
import me.appz4.beacon.service.base.AbstractServiceImpl;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BeaconServiceImpl extends AbstractServiceImpl<Beacon> implements BeaconService {

    @Autowired
    private BeaconDao beaconDao;

    @Autowired
    private BeaconLocationDao beaconLocationDao;

    @Autowired
    private BeaconManufacturerDao beaconManufacturerDao;

    @Autowired
    private ImageDao imageDao;

    @Override
    @Transactional("services")
    public List<Beacon> findAll(SimpleExpression eq) throws Exception {
        return beaconDao.findAll(eq);
    }

    @Override
    @Transactional("services")
    public List<Beacon> findAll(SimpleExpression... eq) throws Exception {
        return beaconDao.findAll(eq);
    }

    @Override
    @Transactional("services")
    public Beacon findByFactoryId(String factoryId) throws Exception {
        Beacon beacon = beaconDao.find(Restrictions.eq(Beacon.FACTORYID, factoryId));
        if (beacon == null) throw new ServiceException(Errors.ERROR_BEACON_NOT_FOUND, factoryId);
        return beacon;
    }

    @Override
    @Transactional("services")
    public BeaconLocation createLocation(Long beaconId, Position pos, Long userId) throws Exception {
		/*BeaconLocation loc = getLocationBy(beaconId, pos, userId);
		if(loc != null) return loc;*/
        BeaconLocation location = new BeaconLocation();
        location.setBeaconId(beaconId);
        location.setLatitude(pos.getLatitude());
        location.setLongitude(pos.getLongitude());
        location.setUserId(userId);
        location.setCreated(new Timestamp(System.currentTimeMillis()));
        Long id = beaconLocationDao.create(location);
        return beaconLocationDao.find(id);
    }

    private BeaconLocation getLocationBy(Long beaconId, Position pos, Long userId) throws Exception {
        //TODO
        return null;
    }

    @Override
    @Transactional("services")
    public Beacon createBeacon(Long userId, String factoryId, String name, String desc, Position pos, String type, String phone, String iconType, Long manufacturerId) throws Exception {
        Beacon existingBeacon = beaconDao.find(Restrictions.eq(Beacon.FACTORYID, factoryId));
        if (existingBeacon != null) throw new ServiceException(Errors.ERROR_BEACON_ALREADY_EXISTS, factoryId);
        Beacon sameBeaconName = beaconDao.find(Restrictions.eq(Beacon.USERID, userId), Restrictions.eq(Beacon.NAME, name));
        if (sameBeaconName != null) throw new ServiceException(Errors.ERROR_BEACON_NAME_ALREADY_EXISTS, name);
        Beacon b = new Beacon();
        b.setUserId(userId);
        b.setFactoryId(factoryId);
        b.setName(name);
        b.setDescription(desc);
        b.setType(type);
        b.setPhone(phone);
        b.setIconType(iconType);
        b.setManufacturerId(manufacturerId);
        Date now = Calendar.getInstance().getTime();
        b.setCreated(now);
        b.setModified(now);
        b.setStatusModified(now);
        b.setStatus(BeaconStatus.OK);
        Long beaconId = beaconDao.create(b);
        createLocation(beaconId, pos, userId);
        return beaconDao.find(beaconId);
    }

    @Override
    @Transactional("services")
    public Beacon editBeacon(Long beaconId, Long userId, String name, String desc, String type, String phone, String iconType) throws Exception {
        Beacon sameBeaconName = beaconDao.find(Restrictions.eq(Beacon.USERID, userId), Restrictions.eq(Beacon.NAME, name), Restrictions.ne(Beacon.ID, beaconId));
        if (sameBeaconName != null) throw new ServiceException(Errors.ERROR_BEACON_NAME_ALREADY_EXISTS, name);
        Beacon beacon = getBeaconBy(userId, beaconId);
        beacon.setName(name);
        beacon.setDescription(desc);
        beacon.setType(type);
        beacon.setPhone(phone);
        beacon.setModified(new Date());
        if (iconType != null) {
            beacon.setIconType(iconType);
        }
        beaconDao.update(beacon);
        return beacon;
    }

    @Override
    @Transactional("services")
    public Beacon getBeaconBy(Long userId, Long beaconId) throws Exception {
        Beacon beacon = beaconDao.find(
                Restrictions.eq(Beacon.USERID, userId),
                Restrictions.eq(Beacon.ID, beaconId)
        );
        if (beacon == null) throw new ServiceException(Errors.ERROR_GENERAL);
        return beacon;
    }

    @Override
    @Transactional("services")
    public Beacon getBeaconBy(Long beaconId) throws Exception {
        Beacon beacon = beaconDao.find(Restrictions.eq(Beacon.ID, beaconId));
        if (beacon == null) throw new ServiceException(Errors.ERROR_GENERAL);
        return beacon;
    }

    @Override
    @Transactional("services")
    public List<BeaconLocation> getBeaconLocations(Long beaconId) throws Exception {
        return beaconLocationDao.findAll(
                Arrays.asList(new Criterion[]{
                        Restrictions.eq(BeaconLocation.Companion.getBEACONID(), beaconId)
                }),
                Arrays.asList(new Order[]{
                        Order.desc(BeaconLocation.Companion.getCREATED())
                }),
                null,
                null
        );
    }

    @Override
    @Transactional("services")
    public BeaconLocation getLastLocation(Long beaconId) throws Exception {
        List<BeaconLocation> locations = getBeaconLocations(beaconId);
        if (locations.isEmpty()) {
            return null;
        }
        return locations.get(0);
    }

    @Override
    @Transactional("services")
    public void changeBeaconStatus(Long userId, Long beaconId, BeaconStatus status) throws Exception {
        Beacon beacon = getBeaconBy(userId, beaconId);
        beacon.setModified(getNow());
        beacon.setStatus(status);
        beaconDao.update(beacon);
    }

    @Override
    @Transactional("services")
    public void deleteBeacon(Long userId, Long beaconId) throws Exception {
        Beacon beacon = getBeaconBy(userId, beaconId);
        //Delete locations
        List<BeaconLocation> locations = beaconLocationDao.findAll(Restrictions.eq(BeaconLocation.Companion.getBEACONID(), beacon.getId()));
        for (BeaconLocation i : locations) {
            beaconLocationDao.delete(i);
        }
        beaconDao.delete(beacon);
    }

    @Override
    @Transactional("services")
    public List<BeaconManufacturer> getManufacturers() throws Exception {
        return beaconManufacturerDao.findAll(Restrictions.eq(BeaconManufacturer.STATUS, BeaconManufacturer.StatusTypes.ACTIVE));
    }

    @Override
    @Transactional("services")
    public BeaconManufacturer getManufacturer(Long id) throws Exception {
        return beaconManufacturerDao.find(id);
    }

    @Override
    @Transactional("services")
    public Image getBeaconImage(Long beaconId, ImageType type) throws Exception {
        return imageDao.find(
                Restrictions.eq(Image.TYPE, type),
                Restrictions.eq(Image.CONNECTIONTYPE, ImageConnectionType.BEACON),
                Restrictions.eq(Image.CONNECTIONID, beaconId)
        );
    }

    @Override
    @Transactional("services")
    public List<BeaconLocation> getNearBeaconLocationsForBeaconIds(Position ne, Position sw, List<Long> beaconIds) throws Exception {
        Position nw = new Position();
        nw.setLongitude(ne.getLatitude());
        nw.setLatitude(sw.getLongitude());
        Position se = new Position();
        se.setLongitude(sw.getLatitude());
        se.setLatitude(ne.getLongitude());
        return beaconLocationDao.findAllMostRecent(ne, sw, nw, beaconIds);
    }

    @Override
    @Transactional("services")
    public Beacon getLostBeaconByLocationForUserId(BeaconLocation loc, long ownerBeaconId) throws Exception {
        return beaconDao.find(
                Restrictions.eq(Beacon.ID, loc.getBeaconId()),
                Restrictions.eq(Beacon.STATUS, BeaconStatus.LOST),
                Restrictions.eq(Beacon.USERID, ownerBeaconId)
        );
    }

}
