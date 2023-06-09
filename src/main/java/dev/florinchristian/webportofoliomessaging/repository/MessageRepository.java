package dev.florinchristian.webportofoliomessaging.repository;

import dev.florinchristian.webportofoliomessaging.model.api.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<UserMessage, Long> {
}
