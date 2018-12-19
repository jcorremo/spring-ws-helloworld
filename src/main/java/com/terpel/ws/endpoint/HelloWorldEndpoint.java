package com.terpel.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.terpel.types.helloworld.Greeting;
import com.terpel.types.helloworld.ObjectFactory;
import com.terpel.types.helloworld.Person;

@Endpoint
public class HelloWorldEndpoint {

  @PayloadRoot(namespace = "http://backsoap.com/types/helloworld", localPart = "person")
  @ResponsePayload
  public Greeting sayHello(@RequestPayload Person request) {

    String greeting = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";

    ObjectFactory factory = new ObjectFactory();
    Greeting response = factory.createGreeting();
    response.setGreeting(greeting);

    return response;
  }
}
