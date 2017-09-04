package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents a contract. Assumption: the contact person has a set number of phone numbers and addresses.
 * @author lbo
 *
 */
@Entity
@Table(name="contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="company")
	private String company;

	@Column(name="favorite")
	private boolean favorite;

	@Column(name="smallImageURL")
	private String smallImageURL;

	@Column(name="largeImageURL")
	private String largeImageURL;

	@Column(name="email")
	private String email;

	@Column(name="website")
	private String website;

	@Column(name="birthdate")
	private String birthdate;

	@Column(name="work")
	private String work;

	@Column(name="home")
	private String home;

	@Column(name="mobile")
	private String mobile;

	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;

	@Column(name="zip")
	private int zip;

	@Column(name="latitude")
	private double latitude;

	@Column(name="longitude")
	private double longitude;

	@Column(name="active")
	private boolean active;
	
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

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
