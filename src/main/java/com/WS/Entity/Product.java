package com.WS.Entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    private String id;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false)
    private double price;
    
    @Column(nullable = false, length = 50)
    private String image;
    
    @ManyToOne
    @JoinColumn(name = "categoryid", nullable = false)
    private Category category;
    
    @Column(nullable = false, length = 255)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "supplierid", nullable = false)
    private Supplier supplier;
    
    @Column(nullable = false)
    private boolean activated = true;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	
    
    // Getter and setters
    
    
    
    
}
