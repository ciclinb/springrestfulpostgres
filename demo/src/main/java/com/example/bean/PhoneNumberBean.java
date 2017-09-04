package com.example.bean;

import com.example.constant.PhoneNumberType;

public class PhoneNumberBean {
	
	private String number;
	private PhoneNumberType type;
	
	public PhoneNumberBean(String number, PhoneNumberType type) {
		this.number = number;
		this.type = type;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PhoneNumberType getType() {
		return type;
	}
	public void setType(PhoneNumberType phoneNumberType) {
		this.type = phoneNumberType;
	}

}
