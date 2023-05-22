package dev.florinchristian.webportofoliomessaging.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import dev.florinchristian.webportofoliomessaging.model.api.Subscriber;
import dev.florinchristian.webportofoliomessaging.model.api.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
  public void sendNotification(UserMessage userMessage, List<Subscriber> subscribers) throws FirebaseMessagingException {
    Message.Builder messageBuilder = Message.builder();
    Notification.Builder notificationBuilder = Notification.builder();

    notificationBuilder.setTitle(userMessage.getEmail());
    notificationBuilder.setBody(String.format("New message from %s", userMessage.getNickname()));

    Notification notification = notificationBuilder.build();

    List<Message> messages = new ArrayList<>();

    subscribers.forEach(subscriber -> {
      messageBuilder.setNotification(notification);
      messageBuilder.setToken(subscriber.getDeviceToken());

      messages.add(messageBuilder.build());
    });

    FirebaseMessaging.getInstance().sendAll(messages);
  }
}
