package com.nagarro.training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	int user_id;
	String username;
	String pass;
	public User() {
		super();
	}
	public User( String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	

}
