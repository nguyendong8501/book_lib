package com.example.demo.dtos.user;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.example.demo.dtos.DTO;

public class UserDTO implements DTO {
	private Long userId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;

	private String email;
	private List<PhoneDTO> phoneNumberlist;
	private List<AddressDTO> addressList;

	
	
	public UserDTO() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PhoneDTO> getPhoneNumberlist() {
		return phoneNumberlist;
	}

	public void setPhoneNumberlist(List<PhoneDTO> phoneNumberlist) {
		this.phoneNumberlist = phoneNumberlist;
	}

	public List<AddressDTO> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressDTO> addressList) {
		this.addressList = addressList;
	}

}
