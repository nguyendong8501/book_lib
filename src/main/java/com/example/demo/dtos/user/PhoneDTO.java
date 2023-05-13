package com.example.demo.dtos.user;

import com.example.demo.dtos.DTO;

public class PhoneDTO implements DTO {
	private Long phoneId;
	private String number;
	public Long getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
