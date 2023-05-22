package dev.florinchristian.webportofoliomessaging.repository;

import dev.florinchristian.webportofoliomessaging.model.api.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
