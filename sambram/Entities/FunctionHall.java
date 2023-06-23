package com.webapp.sambram.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FunctionHall")
public class FunctionHall {
	@Id
	private int HallId;
	private String HallName, Address1, Address2, Area1, City, Pincode, Phone1, Phone2;
	public String getHallName() {
		return HallName;
	}
	public void setHallName(String hallName) {
		HallName = hallName;
	}
	public int getHallid() {
		return HallId;
	}
	public void setHallid(int hallId) {
		HallId = hallId;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getArea1() {
		return Area1;
	}
	public void setArea1(String area1) {
		Area1 = area1;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getPhone1() {
		return Phone1;
	}
	public void setPhone1(String phone1) {
		Phone1 = phone1;
	}
	public String getPhone2() {
		return Phone2;
	}
	public void setPhone2(String phone2) {
		Phone2 = phone2;
	}
}
