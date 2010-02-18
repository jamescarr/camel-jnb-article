package com.ociweb.example;
import com.ociweb.example.domain.*;
import org.apache.cxf.frontend.ServerFactoryBean;


public class Publisher{
	public static void main(String... args){
		System.out.println("Starting Server");
		ServerFactoryBean svrFactory = new ServerFactoryBean();
		svrFactory.setAddress("http://localhost:9000/warehouse");
		svrFactory.setServiceBean(new SprocketWarehouse());
		svrFactory.setDataBinding(new org.apache.cxf.aegis.databinding.AegisDatabinding());
		svrFactory.create().start();
		while(true);
	}
}
