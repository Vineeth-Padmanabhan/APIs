package com.camel.xmltojava;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.springframework.beans.factory.annotation.Autowired;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class CamelRouteBuilder {
	
	public void buildRoute() throws IOException {
		
		
		
		//Get List of Routes
		List<List<String>> routes = new ArrayList<>();
		
		List<String> routeLines = new ArrayList<String>();
		routeLines.add("from(\"cxfrs//bean//input\")");
		routeLines.add(".log($${body}");
		
		//Add Autowires for bean references
		//TODO : Should we consider Constructor Autowiring
		Map<String,String> classesToAutowire = new HashMap<>();
		
		String createdRouteString = String.join("\n",routeLines);
		CodeBlock createdRoute = CodeBlock.builder().add(createdRouteString).build();
	    ClassName clazz = ClassName.get("package.to.services", "AService");


		MethodSpec abc = MethodSpec.methodBuilder("configure")
				.addAnnotation(Override.class)
			    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
			    .addComment("TODO : To be added")
			    .addComment("@formatter:off")
			    .addStatement(createdRoute)
			    .addComment("@formatter:on")
			    .build();

			TypeSpec helloWorld = TypeSpec.classBuilder("Route")
			    .addModifiers(Modifier.PUBLIC)
			    .superclass(org.apache.camel.builder.RouteBuilder.class)
			    .addField(FieldSpec.builder(clazz, "name", Modifier.PRIVATE).addAnnotation(Autowired.class).build())
			    .addMethod(abc)
			    .build();

			JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
			    .build();

			try {
			//Path currentDir = Paths.get("C:\\Vineeth\\Git\\api\\xml-to-java");
			Path currentDir = Paths.get(".");
			javaFile.writeTo(currentDir);
			}catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

	}

}
