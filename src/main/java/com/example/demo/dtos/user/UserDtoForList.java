package com.example.demo.dtos.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.dtos.DTO;

public class UserDtoForList implements DTO {
	@NotNull
	private Long id;
	@NotEmpty
	private String name;
	@NotNull
	private Integer numberOfOrder;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfOrder() {
		return numberOfOrder;
	}
	public void setNumberOfOrder(Integer numberOfOrder) {
		this.numberOfOrder = numberOfOrder;
	}
	
	
}
