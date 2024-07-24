package com.WS.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false, length = 255)
    private String address;
    
    @Column(nullable = false)
    private boolean activated = true;
    
    // Getter and setters
    public Supplier(Integer id, String name, String address, boolean activated) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.activated = activated;
    }

    public Supplier() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    
    
}


