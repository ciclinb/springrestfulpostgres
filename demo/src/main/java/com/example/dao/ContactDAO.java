package com.example.dao;

import java.util.List;

import com.example.entity.Contact;

/**
 * The DAO interface is the layer between the business layer and the database layer. It accepts and returns entities. 
 * The DAO will 1) Create a contact record 2) Retrieve a contact record 3) Update a contact record and 4) Delete a contact record
 * Assumption: contact name is not a unique identifier for contact record. However, contact id is an unique identifier. 
 * @author lbo
 *
 */
public interface ContactDAO {
	
	void create(Contact contact);
	
	Contact retrieve(int contactId);

	List<Contact> retrieve(String contactName);
	
	void update(Contact contact);
	
	void delete(int contactId);

}
