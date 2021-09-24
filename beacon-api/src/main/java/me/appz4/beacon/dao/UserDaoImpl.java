package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

}
