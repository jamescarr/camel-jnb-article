package com.ociweb.example.domain;

import java.util.Date;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ociweb.example.domain.Order;
import com.ociweb.example.domain.OrderSite;
import com.ociweb.example.domain.ShippingOrder;
import com.ociweb.example.domain.SprocketWarehouse;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderSiteExample {
	private OrderSite orderSite;
	@Mock SprocketWarehouse warehouse;
	private ArgumentCaptor<ShippingOrder> arg;
	@Before
	public void beforeEach(){
		orderSite = new OrderSite();
		orderSite.setWarehouse(warehouse);
		arg = ArgumentCaptor.forClass(ShippingOrder.class);
	}
	
	@Test
	public void shouldProcessOrderAndSendItToWarehouse(){
		Order order = new Order(3, "Knives");
		
		orderSite.process(order);
		
		verify(warehouse).shipProduct(any(ShippingOrder.class));
	}
	
	@Test
	public void shouldHaveTheOriginalOrderInformationInShippingOrder(){
		Order order = new Order(3, "Knives");
		
		orderSite.process(order);
		verify(warehouse).shipProduct(arg.capture());
		ShippingOrder shippingOrder = arg.getValue();
		
		assertSame(3, shippingOrder.getQuantity());
		assertSame("Knives", shippingOrder.getProduct());
	}
	
	@Test
	public void shouldSetTheExpectedShipDateToTomorrowIfLessThanTenItems(){
		Order order = new Order(9, "Books");
		
		orderSite.process(order);
		verify(warehouse).shipProduct(arg.capture());
		ShippingOrder shippingOrder = arg.getValue();
		
		assertEquals(tomorrow(), shippingOrder.getExpectedShipDate());
	}

	@Test
	public void shouldSetTheExpectedShipDateToThreeDaysFromNowTenOrMoreItems(){
		Order order = new Order(10, "Books");
		
		orderSite.process(order);
		verify(warehouse).shipProduct(arg.capture());
		ShippingOrder shippingOrder = arg.getValue();
		
		assertEquals(new DateTime().plusDays(3).toDateMidnight(), shippingOrder.getExpectedShipDate());
	}
	
	private DateMidnight tomorrow() {
		return new DateTime().plusDays(1).toDateMidnight();
	}
}
