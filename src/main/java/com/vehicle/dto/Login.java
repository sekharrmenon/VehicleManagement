package com.vehicle.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="login",uniqueConstraints = { @UniqueConstraint(columnNames = "username")})
public class Login implements java.io.Serializable {
	
	@Id
	@Column(name="username")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String emailId;
	
	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
	private Access access;
	
	public Login() {
	}

	public Login(String name,String password,String emailId) {
		this.name=name;
		this.password=password;
		this.emailId=emailId;
	}
	public Login(String name,String password,String emailId,Access access) {
		this.name=name;
		this.password=password;
		this.emailId=emailId;
		this.access=access;
	}
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}
	
	
	
	

}
