package dev.florinchristian.webportofoliomessaging.model.api;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "project_name")
  private String projectName;
  @Column(name = "project_description")
  private String projectDescription;
  @Column(name = "project_repository")
  private String projectRepository;

  @ManyToMany
  @JoinTable(
      name = "projects_and_languages",
      joinColumns = @JoinColumn(name = "project_id"),
      inverseJoinColumns = @JoinColumn(name = "language_id")
  )
  private List<Language> usedLanguages;
}
