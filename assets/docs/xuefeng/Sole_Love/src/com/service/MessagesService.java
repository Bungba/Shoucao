package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.MessagesDao;
import com.model.Messages;

@Service
public class MessagesService {

	@Resource
	MessagesDao messagesDao;

	public List<Messages> findMsgInfo(int userid) {
		return messagesDao.findMsgInfo(userid);
	}

	public List<Messages> readMesInfo(int userid, int id) {
		return messagesDao.readMesInfo(userid, id);
	}

	public boolean addMsgInfo(Messages messages) {
		return messagesDao.addMsgInfo(messages);
	}

	public List<Messages> delMsgInfo(int[] id, int userid) {
		return messagesDao.delMsgInfo(id, userid);
	}
}
