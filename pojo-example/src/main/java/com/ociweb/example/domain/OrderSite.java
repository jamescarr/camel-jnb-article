package com.ociweb.example.domain;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;

public class OrderSite {
	private Warehouse warehouse;

	public void process(Order order) {
		ShippingOrder shippingOrder = new ShippingOrder().forPurchase(order);

		shippingOrder.shipsOn(calculateShippingDate(shippingOrder));

		warehouse.shipProduct(shippingOrder);
	}

	private DateMidnight calculateShippingDate(ShippingOrder shippingOrder) {
		return shippingOrder.getQuantity() < 10 ? oneDayFromNow()
				: threeDaysFromNow();
	}

	private DateMidnight oneDayFromNow() {
		return new DateTime().plusDays(1).toDateMidnight();
	}

	private DateMidnight threeDaysFromNow() {
		return new DateTime().plusDays(3).toDateMidnight();
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;

	}

}
