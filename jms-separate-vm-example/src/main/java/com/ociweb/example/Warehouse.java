package com.ociweb.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Warehouse{
        public static void main(String... args) throws Exception{
            // creating a new spring context will bootstrap the camel context
            new ClassPathXmlApplicationContext("classpath:com/ociweb/example/warehouse-context.xml");
            System.out.println("Warehouse listener started... press enter to exit");
            System.in.read();
        }
}

