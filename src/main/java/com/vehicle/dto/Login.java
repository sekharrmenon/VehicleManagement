package com.vehicle.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="login",uniqueConstraints = { @UniqueConstraint(columnNames = "username")})
public class Login implements java.io.Serializable {
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@OneToOne
	private AccessModelDTO access;
	
	public Login() {
	}

	public Login(String username,String password,String email) {
		this.username=username;
		this.password=password;
		this.email=email;
	}
	public Login(String username,String password,String email,AccessModelDTO access) {
		this.username=username;
		this.password=password;
		this.email=email;
		this.access=access;
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public AccessModelDTO getAccess() {
		return access;
	}

	public void setAccess(AccessModelDTO access) {
		this.access = access;
	}
	
	
	
	

}
