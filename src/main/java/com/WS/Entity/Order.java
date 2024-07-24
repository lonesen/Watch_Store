package com.WS.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;
    
    
    @Column(columnDefinition = "DATETIME DEFAULT GETDATE()")
    private Date createdate;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = true)
    private String address;

    @Column(columnDefinition = "VARCHAR(200) DEFAULT 'Waiting'")
    private String orderstatus;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

	public Order(int id, User user, Date createdate, float amount, String address, String orderstatus,
			List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.user = user;
		this.createdate = createdate;
		this.amount = amount;
		this.address = address;
		this.orderstatus = orderstatus;
		this.orderDetails = orderDetails;
	}
	public Order() {

	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Date getCreatedate() {
		return createdate;
	}
	
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getOrderstatus() {
		return orderstatus;
	}
	
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
    
    
}



