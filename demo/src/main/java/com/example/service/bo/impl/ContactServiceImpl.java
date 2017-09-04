package com.example.service.bo.impl;

import java.util.List;

import com.example.bean.ContactBean;
import com.example.dao.ContactDAO;
import com.example.dao.impl.ContactDAOImpl;
import com.example.service.bo.ContactService;
import com.example.util.ContactUtil;

public class ContactServiceImpl implements ContactService {
	
	private static ContactBean contractBean;

	private ContactDAO contactDAO = new ContactDAOImpl();

	@Override
	public void add(ContactBean contactBean) {
		contactDAO.create(ContactUtil.buildContact(contactBean));
	}

	@Override
	public ContactBean get(int contactId) {
		return ContactUtil.buildContactBean(contactDAO.retrieve(contactId));
	}

	@Override
	public List<ContactBean> get(String contactName) {
		return ContactUtil.buildContactBean(contactDAO.retrieve(contactName));
	}

	@Override
	public void delete(int contactId) {
		contactDAO.delete(contactId);
	}

	@Override
	public void update(ContactBean contactBean) {
		contactDAO.update(ContactUtil.buildContact(contactBean));		
	}
		
}
