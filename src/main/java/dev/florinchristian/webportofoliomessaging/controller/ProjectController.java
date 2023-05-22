package dev.florinchristian.webportofoliomessaging.controller;

import dev.florinchristian.webportofoliomessaging.model.api.Project;
import dev.florinchristian.webportofoliomessaging.services.ProjectService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
  @Autowired
  private ProjectService projectService;

  @PostMapping
  private Project saveProject(@RequestBody @NonNull Project project) {
    return projectService.saveProject(project);
  }

  @GetMapping
  public List<Project> getAllProjects() {
    return projectService.getAllProjects();
  }
}
