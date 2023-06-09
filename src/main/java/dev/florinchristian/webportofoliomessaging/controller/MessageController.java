package dev.florinchristian.webportofoliomessaging.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import dev.florinchristian.webportofoliomessaging.model.api.UserMessage;
import dev.florinchristian.webportofoliomessaging.model.response.ApiResponse;
import dev.florinchristian.webportofoliomessaging.services.MessageService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/message")
@CrossOrigin("*")
public class MessageController {
  @Autowired
  private MessageService messageService;

  @PostMapping
  public UserMessage createMessage(@RequestBody UserMessage userMessage) throws FirebaseMessagingException {
    if (userMessage.getNickname().equals("") || userMessage.getEmail().equals("") || userMessage.getMessage().equals("")) {
      return new UserMessage();
    }

    return messageService.save(userMessage);
  }

  @DeleteMapping
  public ApiResponse deleteMessage(@RequestParam(name = "id") @NonNull Long id) {
    return messageService.delete(id);
  }

  @GetMapping
  public List<UserMessage> allMessages() {
    return messageService.getAllMessages();
  }
}
