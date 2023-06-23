package com.webapp.sambram.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usrpass {
	@Id
	private String UserMail;
	private String password;
	public String getUserMail() {
		return UserMail;
	}
	public void setUserMail(String userMail) {
		UserMail = userMail;
	}
	public String getPasswrd() {
		return password;
	}
	public void setPasswrd(String passwrd) {
		this.password = passwrd;
	}
	
}
