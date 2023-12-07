package com.example.cameldemo;

import org.apache.camel.builder.RouteBuilder;

public class FileCopyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:data/inbox?noop=true").log("${body}").to("file:data/outbox");
		
		//imbox indica de onde os arquivos são lidos e filedataoutbox indica a pasta q eles serão colocados
	}
}
