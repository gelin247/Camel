+mport org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class ErrorHandlingTest extends CamelTestSupport {

	@Test
	public void testRouteHandlesError() throws Exception {
		getMockEndpoint("mock:error").expectedMessageCount(1); // Espera-se que ocorra um erro

		// Inicializa o contexto do Camel e adiciona a rota
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new ErrorHandlingRoute());
		context.start();

		// Simula o envio de uma mensagem para a pasta de entrada
		template.sendBodyAndHeader("file:data/inbox", "Test Message", Exchange.FILE_NAME, "test.txt");

		// Aguarda um tempo para a rota processar a mensagem
		Thread.sleep(2000);

		context.stop();

		assertMockEndpointsSatisfied();
	}
}