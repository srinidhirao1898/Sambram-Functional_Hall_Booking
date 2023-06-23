package com.webapp.sambram.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "HallPrice")
@IdClass(HallPrice.class)
public class HallPrice {
	@Id
	private int HallId;
	@Id
	private String AcNonac;
	private float PricePerDay;
	public int getHallid() {
		return HallId;
	}
	public void setHallid(int hallid) {
		HallId = hallid;
	}
	public String getAcNonac() {
		return AcNonac;
	}
	public void setAcNonac(String acNonac) {
		AcNonac = acNonac;
	}
	public float getPricePerDay() {
		return PricePerDay;
	}
	public void setPricePerDay(float pricePerDay) {
		PricePerDay = pricePerDay;
	}

}
