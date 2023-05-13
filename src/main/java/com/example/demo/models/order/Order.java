package com.example.demo.models.order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.example.demo.models.EntityWithIntegerId;
import com.example.demo.models.book.Book;
import com.example.demo.models.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Order implements EntityWithIntegerId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private BigDecimal price;

	@Column
	private Timestamp added;
	@Column
	private String address;

	@Column
	private Boolean done = false;// TODO:REDO

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "status_id")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "payment_method_id")
	private PaymentMethod paymentMethod;

	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItems;
	public void unNullOrderItems() {
        if (this.orderItems == null) {
            this.orderItems = new HashSet<>();
        }
    }

    public void addOrderItem(OrderItem orderItem) {
        unNullOrderItems();
        this.orderItems.add(orderItem);
    }
    @Override
	public Long getId() {
		return id;
	}
    @Override
	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean contains(Book book) {
        unNullOrderItems();
        for (OrderItem item : this.orderItems) {
            if (item.getBook() == book) {
                return true;
            }
        }
        return false;
    }
	public Integer getNumberOfItems() {
		unNullOrderItems();
		return this.orderItems.size();
	}

	public void calculateTotalPrice() {
		unNullOrderItems();
		this.price = BigDecimal.valueOf(0);
		for (OrderItem item : this.orderItems) {
			this.price = this.price.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
	}
}
