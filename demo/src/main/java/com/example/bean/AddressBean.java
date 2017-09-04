package com.example.bean;

public class AddressBean {
	
	private String address;
	private String city;
	private String state;
	private int zip;
	private double latitude;
	private double longitude;

	public AddressBean(String street, String city, String state, int zip, double latitude, double longitude) {
		this.address = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

}
