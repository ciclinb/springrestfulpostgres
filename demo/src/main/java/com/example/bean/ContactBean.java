package com.example.bean;

import java.util.List;

public class ContactBean {
	
	private int id;
	private String firstName;
	private String lastName;
	private AddressBean address;  
	private List<PhoneNumberBean> phoneNumbers;
	private String company;
	private boolean favorite;
	private String smallImageURL;
	private String largeImageURL;
	private String email;
	private String website;
	private String birthdate;
	private boolean isActive;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

}
