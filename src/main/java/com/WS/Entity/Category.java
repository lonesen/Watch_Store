package com.WS.Entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Sử dụng Integer thay vì int

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private boolean activated = true;

    // Constructors
    public Category(Integer id, String name, boolean activated) {
        this.id = id;
        this.name = name;
        this.activated = activated;
    }

    public Category() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
    
    
    
}
