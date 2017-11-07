package com.vehicle.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity
@Table(name="access",uniqueConstraints = { @UniqueConstraint(columnNames = "username")})
public class Access implements java.io.Serializable {
	
	@Id
	@Column(name="username", unique = true)
	private String 	name;
	
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
	@JoinColumn(name = "username")
	private Login login;
	
	
	public  Access() {
		
	}
	
	public Access(String name,Boolean view,Boolean edit,Boolean delete,Boolean create) {
		this.name=name;
		this.view=view;
		this.edit=edit;
		this.delete=delete;
		this.create=create;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	

	

}
