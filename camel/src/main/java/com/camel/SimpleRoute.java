package com.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("activemq:queue:test.queue")
        .to("stream:out");
		
		from("timer://myTimer?period=10")
		.setBody()
		.simple("Hello World Camel fired at ${header.firedTime}")
		.to("stream:out");
		
	}

}
