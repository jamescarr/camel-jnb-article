package com.ociweb.example.domain;

import org.joda.time.DateMidnight;

import java.io.Serializable;

public class ShippingOrder implements Serializable{
	private int quantity;
	private String product;
	private DateMidnight date;

	public Integer getQuantity() {
		return quantity;
	}

	public String getProduct() {
		return product;
	}

	public ShippingOrder forPurchase(Order order) {
		this.quantity= order.getQuantity();
		this.product = order.getProductName();
		return this;
	}

	public DateMidnight getExpectedShipDate() {
		return date;
	}

	public void shipsOn(DateMidnight date) {
		this.date = date;		
	}

}
