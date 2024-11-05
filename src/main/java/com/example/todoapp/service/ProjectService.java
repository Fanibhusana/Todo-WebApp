package com.example.todoapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.model.Project;
import com.example.todoapp.repository.ProjectRepository;


@Service
public class ProjectService {

	@Autowired
    private ProjectRepository projectRepository;

    public Project createProject(String title) {
        Project project = new Project();
        project.setTitle(title);
        project.setCreatedDate(LocalDate.now());
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
