package com.example.University.Model;

import javax.persistence.*;

@Entity
@Table(name = "manger")
public class Manger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manger_id")
	private Integer id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	
	public Manger() {
		super();
	}
	public Manger(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
}
