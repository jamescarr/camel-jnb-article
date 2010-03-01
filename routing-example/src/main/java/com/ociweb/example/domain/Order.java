package com.ociweb.example.domain;

public class Order {
	private final int quantity;
	private final String productName;

	public Order(int quantity, String productName) {
		this.quantity = quantity;
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getProductName() {
		return productName;
	}


}
