package com.example.service.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.example.bean.AddressBean;
import com.example.bean.PhoneNumberBean;

@XmlRootElement(name = "Contact")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ContactRepresentation extends AbstractRepresentation {
	
	private String name;
	private AddressBean address;  
	private List<PhoneNumberBean> phoneNumbers;
	private String company;
	private boolean favorite;
	private String smallImageURL;
	private String largeImageURL;
	private String email;
	private String website;
	private String birthdate;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public List<PhoneNumberBean> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumberBean> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public boolean isFavorite() {
		return favorite;
	}
	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	public String getSmallImageURL() {
		return smallImageURL;
	}
	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}
	public String getLargeImageURL() {
		return largeImageURL;
	}
	public void setLargeImageURL(String largeImageURL) {
		this.largeImageURL = largeImageURL;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}
