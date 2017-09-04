package com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.example.constant.Constant;
import com.example.dao.ContactDAO;
import com.example.entity.Contact;

public class ContactDAOImpl implements ContactDAO {

	private SessionFactory sessionFactory = createSessionFactory();

	/**
	 * initialize the session factory to allow the dao to save and update database objects
	 * @return
	 */
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure(Constant.HIBERNATE_FILE_NAME);
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    return configuration.buildSessionFactory(serviceRegistry);
	}
	

	@Override
	public void create(Contact contact) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(contact);
		tx.commit();
		session.flush();
	}

	@Override
	public Contact retrieve(int contactId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.eq("id", contactId));
		List<Contact> contacts = criteria.list();
		session.getTransaction().commit();
		session.close();
		
		Contact contact = null;
		if (contacts != null && !contacts.isEmpty()) {
			contact = contacts.get(0);
		}
		
		return contact;
	}

	@Override
	public List<Contact> retrieve(String contactName) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Contact.class);
		String[] splited = contactName.split(" ");
		String firstName = splited[0];
		String lastName = splited[1];
		criteria.add(Restrictions.eq("first_name", firstName));
		criteria.add(Restrictions.eq("last_name", lastName));

		List<Contact> contacts = criteria.list();
		session.getTransaction().commit();
		session.close();
	
		return contacts;
	}

	@Override
	public void update(Contact contact) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(contact);
		tx.commit();
		session.flush();
	}

	@Override
	public void delete(int contactId) {
		Session session = sessionFactory.openSession();
		Contact contact = retrieve(contactId);
		contact.setActive(false);
		Transaction tx = session.beginTransaction();
		update(contact);
		tx.commit();
		session.flush();		
	}

}
