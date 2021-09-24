package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.Beacon;

public class BeaconDaoImpl extends BaseDaoImpl<Beacon> implements BeaconDao {

	public BeaconDaoImpl() {
		super(Beacon.class);
	}

}
