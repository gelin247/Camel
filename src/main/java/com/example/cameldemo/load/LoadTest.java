package com.example.cameldemo.load;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class LoadTest {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("direct:start").to("file:data/saida"); // Substitua "mock:result" pelo seu endpoint de destino
			}
		});

		context.start();

		// Enviar um grande número de mensagens
		int numberOfMessages = 100000; // Altere o número de mensagens conforme necessário
		for (int i = 0; i < numberOfMessages; i++) {
			context.createProducerTemplate().sendBody("direct:start", "Test Message " + i);
		}

		Thread.sleep(5000); // Aguarda um tempo para as mensagens serem processadas

		context.stop();
	}
}
