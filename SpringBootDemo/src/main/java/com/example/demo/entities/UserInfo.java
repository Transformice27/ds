package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserInfo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "username", nullable = false, length = 20)
	private String username;
	
	@Column(name = "password", nullable = false, length = 12)
	private String password;
	
	@Column(name = "email", nullable = false, length = 28)
	private String email;
	
	@Column(name = "phone", nullable = false, length = 21)
	private int phone;
}