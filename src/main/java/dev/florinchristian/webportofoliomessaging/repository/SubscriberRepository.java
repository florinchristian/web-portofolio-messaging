package dev.florinchristian.webportofoliomessaging.repository;

import dev.florinchristian.webportofoliomessaging.model.api.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
