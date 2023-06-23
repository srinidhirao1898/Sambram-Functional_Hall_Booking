package com.webapp.sambram.Entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookingsId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int HallId;
	private String UserMail;
	public int getHallId() {
		return HallId;
	}
	public void setHallId(int hallId) {
		HallId = hallId;
	}
	public String getUserMail() {
		return UserMail;
	}
	public void setUserMail(String userMail) {
		UserMail = userMail;
	}
	
	

}
