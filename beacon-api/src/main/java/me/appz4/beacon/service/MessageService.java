package me.appz4.beacon.service;

import java.util.List;

import me.appz4.beacon.model.model.Message;
import me.appz4.beacon.model.model.MessageThread;
import me.appz4.beacon.model.model.Message.MessageStatuses;
import me.appz4.beacon.service.base.AbstractService;

public interface MessageService extends AbstractService<MessageThread> {
	
	List<MessageThread> getThreads(Long userId, Integer skip, Integer limit) throws Exception;

	MessageThread getThreadBy(Long threadId) throws Exception;
	
	MessageThread createThread(Long fromUserId, Long toUserId, Long beaconId, Message firstMessage) throws Exception;
	
	MessageThread addToThread(Long threadId, Long fromUserId, Message message) throws Exception;

	long countAllMessagesBy(Long userId, MessageStatuses status) throws Exception;
	
	void readMessages(MessageThread thread) throws Exception;
	
	void deleteThread(Long userId, Long threadId) throws Exception;

	MessageThread getOrCreateThreadFor(Long beaconId, Long userId, Long recipientId) throws Exception;

	MessageThread getThreadFor(Long beaconId, Long userId, Long recipientId) throws Exception;
	
}
