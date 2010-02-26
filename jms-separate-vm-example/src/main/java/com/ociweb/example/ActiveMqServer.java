package com.ociweb.example;
import org.apache.activemq.broker.BrokerService;

public class ActiveMqServer{
	public static void main(String... args) throws Exception{
		BrokerService broker = new BrokerService();
        broker.setBrokerName("jms-example-broker");
        broker.setPersistent(false);
        broker.setUseJmx(false);
		broker.addConnector("tcp://localhost:61616");
		broker.start();
        
        System.out.println("ActiveMQ started... press enter to exit");
        System.in.read();
	}
}
