package com.example.service.bo;

import java.util.List;

import com.example.bean.ContactBean;

/**
 * This interface is the layer between the DAO, which intefaces directly with the database, and the endpoint, which exposes the web service functions to the client. 
 * @author lbo
 *
 */
public interface ContactService {

	void add(ContactBean contactBean);
	
	ContactBean get(int contactId);

	List<ContactBean> get(String contactName);

	void delete(int contactId);

	void update(ContactBean contactBean);
	

}
