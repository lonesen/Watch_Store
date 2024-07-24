package com.WS.DTO;

import com.WS.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

	@Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "createdate")
    private Date createdate;

    @Column(name = "amount")
    private float amount;

    @Column(name = "address")
    private String address; // Assuming this is the correct field to map to

    @Column(name = "orderstatus")
    private String orderstatus;

    // Constructors, getters, and setters
    
    
    
    public OrderDTO(int id, String name, String email, Date createdate, float amount, String address,
			String orderstatus) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdate = createdate;
		this.amount = amount;
		this.address = address;
		this.orderstatus = orderstatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
    
    
    
}
