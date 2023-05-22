package dev.florinchristian.webportofoliomessaging.services;

import com.google.firebase.messaging.FirebaseMessagingException;
import dev.florinchristian.webportofoliomessaging.model.Subscriber;
import dev.florinchristian.webportofoliomessaging.model.UserMessage;
import dev.florinchristian.webportofoliomessaging.repository.MessageRepository;
import dev.florinchristian.webportofoliomessaging.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private NotificationService notificationService;

    public UserMessage save(UserMessage userMessage) throws FirebaseMessagingException {
        UserMessage savedMessage = messageRepository.save(userMessage);
        List<Subscriber> subscribers = subscriberRepository.findAll();

        notificationService.sendNotification(userMessage, subscribers);

        return savedMessage;
    }

    public List<UserMessage> getAllMessages() {
        return messageRepository.findAll();
    }
}
