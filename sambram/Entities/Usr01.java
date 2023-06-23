package com.webapp.sambram.Entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Usr01 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "email")
	private String email;
	@Column(name = "Password")
	private String Password;
	@Column(name = "FirstName")
	private String FirstName;
	@Column(name = "MiddleName")
	private String MiddleName;
	@Column(name = "LastName")
	private String LastName;
	@Column(name = "Phone1")
	private String Phone1;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "useer_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
	,
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	    private Set<Role> roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String userMail) {
		email = userMail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhone1() {
		return Phone1;
	}
	public void setPhone1(String phone1) {
		Phone1 = phone1;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
