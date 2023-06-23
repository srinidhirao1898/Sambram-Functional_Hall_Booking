package com.webapp.sambram;

import java.sql.Date;

public class HallIds {
	private int hall_id;
	private String hall_name,AcNonac;
	private Date fromDate;
	private Date toDate;
	public HallIds(int hall_id, String hall_name, String acNonac, Date fromDate, Date toDate) {
		super();
		this.hall_id = hall_id;
		this.hall_name = hall_name;
		this.AcNonac = acNonac;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public String getHall_name() {
		return hall_name;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public int getHall_id() {
		return hall_id;
	}
	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}
	public String getAcNonac() {
		return AcNonac;
	}
	public void setAcNonac(String acNonac) {
		AcNonac = acNonac;
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
}
