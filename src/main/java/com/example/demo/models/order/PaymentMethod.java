package com.example.demo.models.order;

import com.example.demo.models.EntityWithIntegerId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentMethod implements EntityWithIntegerId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentMethodId;

	@Column
	private String description;

	public PaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Long getId() {
		return paymentMethodId;
	}

	@Override
	public void setId(Long id) {
		this.paymentMethodId = id;
	}
}
