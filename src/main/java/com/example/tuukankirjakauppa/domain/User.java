package com.example.tuukankirjakauppa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false, updatable = false)
private Long id;

//Create username with unique constraint
@Column(name = "username", nullable = false, unique = true)
private String username;

@Column(name = "password", nullable = false)
private String passwordHash;

@Column(name="role", nullable = false)
private String role;



public User(String username, String passwordHash, String role) {
	super();
	this.username = username;
	this.passwordHash = passwordHash;
	this.role = role;
}



public User() {
	super();
	// TODO Auto-generated constructor stub
}



public Long getId() {
	return id;
}

public String getUsername() {
	return username;
}

public String getPasswordHash() {
	return passwordHash;
}

public String getRole() {
	return role;
}

public void setId(Long id) {
	this.id = id;
}

public void setUsername(String username) {
	this.username = username;
}

public void setPasswordHash(String passwordHash) {
	this.passwordHash = passwordHash;
}

public void setRole(String role) {
	this.role = role;
}



}


