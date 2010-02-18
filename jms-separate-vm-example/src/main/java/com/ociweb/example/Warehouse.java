package com.ociweb.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Warehouse{
        public static void main(String... args) throws Exception{
             new ClassPathXmlApplicationContext("classpath:com/ociweb/example/warehouse-context.xml");
            while(true);
        }
}

