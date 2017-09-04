package com.example.util;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.AddressBean;
import com.example.bean.ContactBean;
import com.example.bean.PhoneNumberBean;
import com.example.constant.Constant;
import com.example.constant.PhoneNumberType;
import com.example.entity.Contact;
import com.example.service.representation.ContactRepresentation;

public class ContactUtil {

	public static ContactBean buildContactBean(ContactRepresentation contactRepresentation) {
		ContactBean contactBean = new ContactBean();

		if (contactRepresentation != null) {
			contactBean.setActive(true);
			contactBean.setAddress(contactRepresentation.getAddress());
			contactBean.setBirthdate(contactRepresentation.getBirthdate());
			contactBean.setCompany(contactRepresentation.getCompany());
			contactBean.setEmail(contactRepresentation.getEmail());
			contactBean.setFavorite(contactRepresentation.isFavorite());
			String[] names = separateName(contactRepresentation.getName());
			contactBean.setFirstName(names[0]);
			contactBean.setPhoneNumbers(contactRepresentation.getPhoneNumbers());
			contactBean.setLargeImageURL(contactRepresentation.getLargeImageURL());
			contactBean.setLastName(names[1]);
			contactBean.setSmallImageURL(contactRepresentation.getSmallImageURL());
			contactBean.setWebsite(contactRepresentation.getWebsite());
		}

		return contactBean;
	}

	/**
	 * 
	 * @param contactBean
	 * @return
	 */
	public static Contact buildContact(ContactBean contactBean) {
		Contact contact = new Contact();

		if (contactBean != null) {
			contact.setActive(true);
			
			AddressBean address = contactBean.getAddress();
			if (address != null) {
				contact.setStreet(address.getAddress());
				contact.setCity(address.getCity());
				contact.setState(address.getState());
				contact.setZip(address.getZip());
			}
			
			contact.setBirthdate(contactBean.getBirthdate());
			contact.setCompany(contactBean.getCompany());
			contact.setEmail(contactBean.getEmail());
			contact.setFavorite(contactBean.isFavorite());
			contact.setFirstName(contactBean.getFirstName());
			contact.setHome(getPhoneNumber(contactBean.getPhoneNumbers(), PhoneNumberType.HOME));
			contact.setLargeImageURL(contactBean.getLargeImageURL());
			contact.setLastName(contactBean.getLastName());
			contact.setMobile(getPhoneNumber(contactBean.getPhoneNumbers(), PhoneNumberType.MOBILE));
			contact.setSmallImageURL(contactBean.getSmallImageURL());
			contact.setWebsite(contactBean.getWebsite());
			contact.setWork(getPhoneNumber(contactBean.getPhoneNumbers(), PhoneNumberType.WORK));
		}

		return contact;

	}

	/**
	 * 
	 * @param contactList
	 * @return
	 */
	public static List<ContactBean> buildContactBean(List<Contact> contactList) {
		List<ContactBean> contactBeanList = new ArrayList<ContactBean>();
		for (Contact contact : contactList) {
			contactBeanList.add(buildContactBean(contact));
		}
		return contactBeanList;
	}

	public static List<ContactRepresentation> buildContactRepresentationList(List<ContactBean> contactBeanList) {
		List<ContactRepresentation> contactRepresentationList = new ArrayList<ContactRepresentation>();
		
		if (!isNullOrEmpty(contactBeanList)) {
			for (ContactBean contactBean : contactBeanList) {
				contactRepresentationList.add(buildContactRepresentation(contactBean));
			}
		}
		
		return contactRepresentationList;
	}

	/**
	 * 
	 * @param contact
	 * @return
	 */
	public static ContactBean buildContactBean(Contact contact) {
		ContactBean contactBean = new ContactBean();

		if (contact != null) {
			contactBean.setActive(true);
			contactBean.setAddress(new AddressBean(contact.getStreet(), contact.getCity(), contact.getState(), contact.getZip(), contact.getLatitude(), contact.getLongitude()));
			contactBean.setBirthdate(contact.getBirthdate());
			contactBean.setCompany(contact.getCompany());
			contactBean.setEmail(contact.getEmail());
			contactBean.setFavorite(contact.isFavorite());
			contactBean.setFirstName(contact.getFirstName());
			
			List<PhoneNumberBean> phoneNumbers = new ArrayList<PhoneNumberBean>();
			phoneNumbers.add(new PhoneNumberBean(contact.getHome(), PhoneNumberType.HOME));
			phoneNumbers.add(new PhoneNumberBean(contact.getMobile(), PhoneNumberType.MOBILE));
			phoneNumbers.add(new PhoneNumberBean(contact.getWork(), PhoneNumberType.WORK));
			contactBean.setPhoneNumbers(phoneNumbers);

			contactBean.setLargeImageURL(contact.getLargeImageURL());
			contactBean.setLastName(contact.getLastName());
			contactBean.setSmallImageURL(contact.getSmallImageURL());
			contactBean.setWebsite(contact.getWebsite());
		}

		return contactBean;
	}

	/**
	 * 
	 * @param contactBean
	 * @return
	 */
	public static ContactRepresentation buildContactRepresentation(ContactBean contactBean) {
		ContactRepresentation contactRepresentation = new ContactRepresentation();

		if (contactBean != null) {
			contactRepresentation.setAddress(contactBean.getAddress());
			contactRepresentation.setBirthdate(contactBean.getBirthdate());
			contactRepresentation.setCompany(contactBean.getCompany());
			contactRepresentation.setEmail(contactBean.getEmail());
			contactRepresentation.setFavorite(contactBean.isFavorite());
			contactRepresentation.setName(contactBean.getFirstName() + Constant.NAME_DELIMITER + contactBean.getLastName());
			contactRepresentation.setPhoneNumbers(contactBean.getPhoneNumbers());
			contactRepresentation.setLargeImageURL(contactBean.getLargeImageURL());
			contactRepresentation.setSmallImageURL(contactBean.getSmallImageURL());
			contactRepresentation.setWebsite(contactBean.getWebsite());
		}

		return contactRepresentation;
	}

	/**
	 * Separates a string into individual values in an array. Uses the space delimiter
	 * @param name
	 * @return
	 */
	private static String[] separateName(String name) {
		if (!isNullOrEmpty(name)) {
			return name.split(Constant.NAME_DELIMITER);
		}
		
		return null;
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	private static boolean isNullOrEmpty(String string) {
		return string == null || string.isEmpty();
	}
	
	/**
	 * Get phone number of a specific type from the list of contact phone numbers
	 * @param phoneNumberBeans
	 * @param type
	 * @return
	 */
	private static String getPhoneNumber(List<PhoneNumberBean> phoneNumberBeans, PhoneNumberType type) {
		String phoneNumber = null;
		if (!isNullOrEmpty(phoneNumberBeans)) {
			for (PhoneNumberBean phoneNumberBean : phoneNumberBeans) {
				if (phoneNumberBean != null && phoneNumberBean.getType() == type) {
	         		phoneNumber = phoneNumberBean.getNumber();
				}
			}
		}

		return phoneNumber;

	}

	/**
	 * Return is a list is null or empty
	 * @param list
	 * @return
	 */
	private static boolean isNullOrEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

}
