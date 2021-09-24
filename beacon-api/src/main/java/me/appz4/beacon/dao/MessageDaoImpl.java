package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.Message;

public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

	public MessageDaoImpl() {
		super(Message.class);
	}

}
