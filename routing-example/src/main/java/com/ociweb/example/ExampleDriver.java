package com.ociweb.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ociweb.example.domain.Order;
import com.ociweb.example.domain.OrderSite;

public class ExampleDriver {
	public static void main(String... args)throws Exception{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/ociweb/example/application-context.xml");
		OrderSite site = (OrderSite) ctx.getBean("orderSite");
		
		site.process(new Order(9, "Sprockets"));
		site.process(new Order(300, "Sprockets"));
		site.process(new Order(10, "Sprockets"));
		site.process(new Order(13, "Sprockets"));
		site.process(new Order(225, "Sprockets"));
		System.out.println("Orders sent!");
		Thread.sleep(200);
	}
}
