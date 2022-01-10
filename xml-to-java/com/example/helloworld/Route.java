package com.example.helloworld;

import java.lang.Override;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import package.to.services.AService;

public class Route extends RouteBuilder {
  @Autowired
  private AService name;

  @Override
  public static void configure() {
    // TODO : To be added
    // @formatter:off
    from("cxfrs//bean//input")
        .log(${body};
    // @formatter:on
  }
}
