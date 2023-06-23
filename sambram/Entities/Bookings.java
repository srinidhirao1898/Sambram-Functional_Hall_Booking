package com.webapp.sambram.Entities;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Bookings {
	@EmbeddedId
	private BookingsId bookingsId;
	private String AcNonac;
	private Date FromDate, ToDate;
	private Time FromTime, ToTime;
	private float AmountToBePaid, AdvancePaid;
	public BookingsId getBookingsId() {
		return bookingsId;
	}
	public void setBookingsId(BookingsId bookingsId) {
		this.bookingsId = bookingsId;
	}
	public String getAcNonac() {
		return AcNonac;
	}
	public void setAcNonac(String acNonac) {
		AcNonac = acNonac;
	}
	public Date getFromDate() {
		return FromDate;
	}
	public void setFromDate(Date fromDate) {
		FromDate = fromDate;
	}
	public Date getToDate() {
		return ToDate;
	}
	public void setToDate(Date toDate) {
		ToDate = toDate;
	}
	public Time getFromTime() {
		return FromTime;
	}
	public void setFromTime(Time fromTime) {
		FromTime = fromTime;
	}
	public Time getToTime() {
		return ToTime;
	}
	public void setToTime(Time toTime) {
		ToTime = toTime;
	}
	public float getAmountToBePaid() {
		return AmountToBePaid;
	}
	public void setAmountToBePaid(float amountToBePaid) {
		AmountToBePaid = amountToBePaid;
	}
	public float getAdvancePaid() {
		return AdvancePaid;
	}
	public void setAdvancePaid(float advancePaid) {
		AdvancePaid = advancePaid;
	}

}
