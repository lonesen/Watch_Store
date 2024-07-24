package com.WS.Entity;



import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "Order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "orderid", nullable = false)
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "productid", nullable = false)
    private Product product;
    
    @Column(nullable = false)
    private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    // Getter and setters
}


