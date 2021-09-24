package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.UserLocation;

public class UserLocationDaoImpl extends BaseDaoImpl<UserLocation> implements UserLocationDao {

	public UserLocationDaoImpl() {
		super(UserLocation.class);
	}

}