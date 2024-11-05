package com.example.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoapp.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
