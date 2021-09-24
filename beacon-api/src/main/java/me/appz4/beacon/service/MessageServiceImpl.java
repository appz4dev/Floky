package me.appz4.beacon.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import me.appz4.beacon.dao.MessageDao;
import me.appz4.beacon.dao.MessageThreadDao;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.model.Message;
import me.appz4.beacon.model.model.MessageThread;
import me.appz4.beacon.model.model.Message.MessageStatuses;
import me.appz4.beacon.service.base.AbstractServiceImpl;

public class MessageServiceImpl extends AbstractServiceImpl<MessageThread> implements MessageService {

	@Autowired
	private MessageThreadDao messageThreadDao;
	
	@Autowired
	private MessageDao messageDao;

	@Override
	@Transactional("services")
	public List<MessageThread> getThreads(Long userId, Integer skip, Integer limit) throws Exception {
		return messageThreadDao.findAll(
			Arrays.asList(new Criterion[] {
					Restrictions.or(Restrictions.eq(MessageThread.USERID, userId), Restrictions.eq(MessageThread.RECEPIENTID, userId))
			}), 
			Arrays.asList(new Order[]{
				Order.desc(MessageThread.MODIFIED)
			}), 
			skip, 
			limit
		);
	}
	
	@Override
	@Transactional("services")
	public MessageThread getThreadBy(Long threadId) throws Exception {
		MessageThread thread = messageThreadDao.find(
			Restrictions.eq(MessageThread.ID, threadId)
		);
		if(thread == null) throw new ServiceException(Errors.ERROR_GENERAL);
		thread.setMessages(getThreadMessages(thread.getId(), new Criterion[]{}));
		return thread;
	}
	
	@Override
	@Transactional("services")
	public MessageThread createThread(Long fromUserId, Long toUserId, Long beaconId, Message message) throws Exception {
		Date now = Calendar.getInstance().getTime();
		MessageThread thread = new MessageThread();
		thread.setUserId(fromUserId);
		thread.setRecepientId(toUserId);
		thread.setBeaconId(beaconId);
		thread.setMessage(0);
		thread.setUnread(0);
		thread.setUnreadRecipient(0);
		thread.setStatus(1);
		thread.setCreated(now);
		thread.setModified(now);
		Long id = messageThreadDao.create(thread);
		thread.setId(id);
		if(message != null) {
			thread = addToThread(id, fromUserId, message);
		}
		return thread;
	}

	@Override
	@Transactional("services")
	public synchronized MessageThread addToThread(Long threadId, Long fromUserId, Message message) throws Exception {
		MessageThread thread = getThreadBy(threadId);
		message.setCreated(getNow());
		message.setModified(getNow());
		message.setThreadId(threadId);
		message.setUserId(fromUserId);
		if(thread.getUserId().equals(fromUserId)) {
			message.setRecipientId(thread.getRecepientId());
		}
		else {
			message.setRecipientId(thread.getUserId());
		}
		message.setStatus(MessageStatuses.READ);
		message.setStatusRecipient(MessageStatuses.UNREAD);
		messageDao.create(message);
		thread.setMessage(thread.getMessage()+1);
		thread.setUnread(thread.getUnread()+1);
		thread.setModified(getNow());
		messageThreadDao.update(thread);
		return thread;
	}
	
	@Override
	@Transactional("services")
	public long countAllMessagesBy(Long userId, MessageStatuses status) throws Exception {
		List<MessageThread> threads = messageThreadDao.findAll(
			Restrictions.eq(MessageThread.USERID, userId)
		);
		Long total = 0L;
		for(MessageThread i : threads) {
			Long count = messageDao.count(Arrays.asList(new Criterion[] {
				Restrictions.eq(Message.THREADID, i.getId()),
				Restrictions.eq(Message.STATUS, status)
			}));
			total += count;
		}
		return total;
	}

	@Override
	@Transactional("services")
	public void readMessages(MessageThread thread) throws Exception {
		List<Message> messages = getThreadMessages(thread.getId(), Restrictions.eq(Message.STATUS, MessageStatuses.UNREAD));
		for(Message i : messages) {
			i.setModified(getNow());
			i.setStatus(MessageStatuses.READ);
			messageDao.update(i);
		}
		thread.setUnread(0);
		messageThreadDao.update(thread);
		thread.setMessages(getThreadMessages(thread.getId(), new Criterion[]{}));
	}
	
	@Transactional("services")
	private List<Message> getThreadMessages(Long threadId, Criterion... criterias) throws Exception {
		List<Criterion> crits = new ArrayList<Criterion>();
		crits.add(Restrictions.eq(Message.THREADID, threadId));
		if(criterias != null) {
			crits.addAll(Arrays.asList(criterias));
		}
		return messageDao.findAll(
			crits,
			Arrays.asList(new Order[]{
				Order.desc(Message.CREATED)
			}),
			null,
			null
		);
	}

	@Override
	@Transactional("services")
	public void deleteThread(Long userId, Long threadId) throws Exception {
		MessageThread thread = getThreadBy(threadId);
		if(thread == null) throw new ServiceException(Errors.ERROR_THREAD_NOT_FOUND, Long.toString(threadId));
		List<Message> messages = getThreadMessages(thread.getId(), new Criterion[] {});
		for(Message i : messages) {
			messageDao.delete(i);
		}
		messageThreadDao.delete(thread);
	}
	
	@Override
	@Transactional("services")
	public MessageThread getOrCreateThreadFor(Long beaconId, Long userId, Long recipientId) throws Exception {
		MessageThread thread = messageThreadDao.find(
			Restrictions.eq(MessageThread.BEACONID, beaconId),
			Restrictions.eq(MessageThread.USERID, userId),
			Restrictions.eq(MessageThread.RECEPIENTID, recipientId)				
		);
		if(thread == null) {
			thread = createThread(userId, recipientId, beaconId, null);
		}
		return thread;
	}
	
	@Override
	@Transactional("services")
	public MessageThread getThreadFor(Long beaconId, Long userId, Long recipientId) throws Exception {
		MessageThread thread = messageThreadDao.find(
			Restrictions.eq(MessageThread.BEACONID, beaconId),
			Restrictions.eq(MessageThread.USERID, userId),
			Restrictions.eq(MessageThread.RECEPIENTID, recipientId)				
		);
		return thread;
	}

}
