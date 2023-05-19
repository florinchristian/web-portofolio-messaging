package dev.florinchristian.webportofoliomessaging.repository;

import dev.florinchristian.webportofoliomessaging.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
