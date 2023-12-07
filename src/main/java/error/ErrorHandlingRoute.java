package error;

import org.apache.camel.builder.RouteBuilder;

public class ErrorHandlingRoute extends RouteBuilder {

	@Override
	public void configure() {
		errorHandler(deadLetterChannel("mock:error")); // Configura um endpoint de "dead-letter"

		from("file:data/inbox?noop=true").process(exchange -> {
			// Simula um erro durante o processamento da mensagem
			throw new RuntimeException("Erro simulado durante o processamento da mensagem");
		}).to("file:data/outbox");
	}
}
