package dev.florinchristian.webportofoliomessaging.controller;

import dev.florinchristian.webportofoliomessaging.model.Message;
import dev.florinchristian.webportofoliomessaging.repository.MessageRepository;
import dev.florinchristian.webportofoliomessaging.services.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/message")
@CrossOrigin("*")
public class MessagesController {

  @Autowired
  private MessageRepository messageRepository;

  @PostMapping
  public Message createMessage(@RequestBody Message message) {
    if (message.getNickname().equals("") || message.getEmail().equals("") || message.getMessage().equals("")) {
      return new Message();
    }

    Message result = messageRepository.save(message);
    NotificationManager.SendNotification(result);

    return result;
  }

  @GetMapping
  public List<Message> allMessages() {
    return messageRepository.findAll();
  }
}
