package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.Notification;

public class NotificationDaoImpl extends BaseDaoImpl<Notification> implements NotificationDao {

	public NotificationDaoImpl() {
		super(Notification.class);
	}

}
