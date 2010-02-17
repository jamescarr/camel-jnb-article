package com.ociweb.example.domain;

public class SprocketWarehouse implements Warehouse {
	private static final String MESSAGE = "Recieved Order for %d %s that will ship on %s.%n";
	public void shipProduct(ShippingOrder order) {
		System.out.printf(MESSAGE,order.getQuantity(),order.getProduct(), order.getExpectedShipDate().toString("MM/dd/yyyy"));

		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
	}

}
