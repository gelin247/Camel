package error;

import org.apache.camel.builder.RouteBuilder;

public class MinhaRota extends RouteBuilder {

	public void configure() throws Exception {
		from("direct:start").process(exchange -> {
			// Condição de falha simulada
			if (exchange.getIn().getBody(String.class).contains("Test Message 50")) {
				throw new RuntimeException("Erro ao processar a mensagem: Test Message 50");
			}
		}).to("file:data/saida");
	}

}
