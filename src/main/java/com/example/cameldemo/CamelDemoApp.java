package com.example.cameldemo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelDemoApp {

	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new FileCopyRoute());

		context.start();
		Thread.sleep(80000); // Aguarda um tempo para a rota ser executada

		context.stop();
	}

}
