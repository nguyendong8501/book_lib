package com.example.demo.models.order;

import com.example.demo.models.EntityWithIntegerId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Status implements EntityWithIntegerId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusId;
	@Column
	private String status;

	public Status(Long statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Long getId() {
		return statusId;
	}

	@Override
	public void setId(Long statusId) {
		this.statusId = statusId;
	}

}
