package com.gklsan.learninggokul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

@RestController
public class HelloWorldController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/")
//  @Scheduled(cron = "10 0 * * * *")
//  @Scheduled(fixedRate = 5000)
  @Cacheable(value = "todos_response")
  public List<Object> hey() {
    System.out.println("----Task executed at {}" + LocalDateTime.now());
    System.out.println("Scheduled task is starting");
    String url = "https://jsonplaceholder.typicode.com/todos";
    String response = restTemplate.getForObject(url, String.class);
    JsonParser springParser = (JsonParser) JsonParserFactory.getJsonParser();
    List <Object> list = springParser.parseList(response);
    System.out.println("Number of items: " + list.size());
    return list;
  }

  @Scheduled(fixedRate = 10000)
  public void doTask() {
    // Code to execute on a schedule
    System.out.println("Task executed at {}" + LocalDateTime.now());
  }
}