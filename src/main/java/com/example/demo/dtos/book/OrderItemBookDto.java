package com.example.demo.dtos.book;

public class OrderItemBookDto extends BasicBookDTO {
	private int quantity = 1;
	private Long orderItemId;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
