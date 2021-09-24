package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.MessageThread;

public class MessageThreadDaoImpl extends BaseDaoImpl<MessageThread> implements MessageThreadDao {

	public MessageThreadDaoImpl() {
		super(MessageThread.class);
	}

}
