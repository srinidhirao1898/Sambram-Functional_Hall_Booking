package com.webapp.sambram;

import java.sql.Date;

public class HallAvailable {
	private int hall_id;
	private String hall_name,address,city,phone1,phone2,ac_nonac;
	private float price_per_day;
	private Date fromDate, toDate;
	public HallAvailable(int hall_id, String hall_name, String address, String city, String phone1, String phone2,
			String ac_nonac, float price_per_day, Date fromDate, Date toDate) {
		super();
		this.hall_id = hall_id;
		this.hall_name = hall_name;
		this.address = address;
		this.city = city;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.ac_nonac = ac_nonac;
		this.price_per_day = price_per_day;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getHall_id() {
		return hall_id;
	}
	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}
	public String getHall_name() {
		return hall_name;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getAc_nonac() {
		return ac_nonac;
	}
	public void setAc_nonac(String ac_nonac) {
		this.ac_nonac = ac_nonac;
	}
	public float getPrice_per_day() {
		return price_per_day;
	}
	public void setPrice_per_day(float price_per_day) {
		this.price_per_day = price_per_day;
	}
}
