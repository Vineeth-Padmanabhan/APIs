package com.camel.xmltojava;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.camel.xmltojava.CamelRouteBuilder;

@SpringBootApplication
public class XmlToJavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(XmlToJavaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		CamelRouteBuilder builder = new CamelRouteBuilder();
		builder.buildRoute();
		XmlParser parser = new XmlParser();
		parser.parseXml();
		
	}

}
