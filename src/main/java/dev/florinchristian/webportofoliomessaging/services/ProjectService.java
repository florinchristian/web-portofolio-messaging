package dev.florinchristian.webportofoliomessaging.services;

import dev.florinchristian.webportofoliomessaging.model.api.Language;
import dev.florinchristian.webportofoliomessaging.model.api.Project;
import dev.florinchristian.webportofoliomessaging.repository.LanguageRepository;
import dev.florinchristian.webportofoliomessaging.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;
  @Autowired
  private LanguageRepository languageRepository;

  public Project saveProject(Project project) {
    saveMissingLanguages(project.getUsedLanguages());

    return projectRepository.save(project);
  }

  private void saveMissingLanguages(List<Language> languages) {
    languages.forEach(language -> {
      if (languageRepository.existsByLanguageName(language.getLanguageName())) {
        Language aux = languageRepository.findByLanguageName(language.getLanguageName());
        language.setId(aux.getId());
      } else {
        Language newLanguage = languageRepository.save(language);
        language.setId(newLanguage.getId());
      }
    });
  }

  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }
}
