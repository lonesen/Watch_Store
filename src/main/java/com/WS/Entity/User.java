package com.WS.Entity;



import lombok.Data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 255)
    private String email;
    
    @Column(nullable = false, length = 50)
    private String password;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false)
    private boolean sex;
    
    @Column(length = 15)
    private String phone;
    
    @Column(nullable = false)
    private boolean admin ;
    
    @Column(nullable = false)
    private boolean activated = true;
    
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date createdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
    
    
}
