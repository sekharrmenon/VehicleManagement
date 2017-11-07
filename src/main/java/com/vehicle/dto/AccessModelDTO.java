package com.vehicle.dto;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import com.vehicle.dto.Login;

@Entity
@Table(name="access",uniqueConstraints = { @UniqueConstraint(columnNames = "username")})
public class AccessModelDTO implements java.io.Serializable {
	
	private String 	username;
	
	@Column(name="view",columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean view;
	
	@Column(name="edit",columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean edit;
	
	@Column(name="create",columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean create;
	
	@Column(name="delete",columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean delete;
	
	@OneToOne
	private Login login;
	
	public  AccessModelDTO() {
		
	}
	
	public AccessModelDTO(String username,Boolean view,Boolean edit,Boolean delete,Boolean create) {
		this.username=username;
		this.view=view;
		this.edit=edit;
		this.delete=delete;
		this.create=create;
	}
	
	public AccessModelDTO(Login login,String username,Boolean view,Boolean edit,Boolean delete,Boolean create) {
		this.username=username;
		this.view=view;
		this.edit=edit;
		this.delete=delete;
		this.create=create;
		this.login=login;
	}
	
	

	public boolean isView() {
		return view;
	}
	public void setView(boolean view) {
		this.view = view;
	}
	

	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public boolean isCreate() {
		return create;
	}
	public void setCreate(boolean create) {
		this.create = create;
	}

	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
	@Id
	@Column(name="username", unique = true)
	public String getName() {
		return username;
	}
	public void setName(String username) {
		this.username = username;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

	

}
