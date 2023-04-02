package com.gklsan.learninggokul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.List;

@RestController
public class HelloWorldController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/")
  public List<Object> hey() {
    String url = "https://jsonplaceholder.typicode.com/todos";
    String response = restTemplate.getForObject(url, String.class);
    JsonParser springParser = (JsonParser) JsonParserFactory.getJsonParser();
    List <Object> list = springParser.parseList(response);
    System.out.println("Number of items: " + list.size());
    return list;
  }
}