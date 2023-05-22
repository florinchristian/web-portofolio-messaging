package dev.florinchristian.webportofoliomessaging.controller;

import dev.florinchristian.webportofoliomessaging.model.api.Subscriber;
import dev.florinchristian.webportofoliomessaging.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subscriber")
@CrossOrigin("*")
public class SubscriberController {
  @Autowired
  private SubscriberRepository subscriberRepository;

  @PostMapping
  public Subscriber saveToken(@RequestBody Subscriber subscriber) {
    return subscriberRepository.save(subscriber);
  }
}
