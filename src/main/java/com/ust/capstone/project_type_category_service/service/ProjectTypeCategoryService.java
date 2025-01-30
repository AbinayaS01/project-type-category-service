package com.ust.capstone.project_type_category_service.service;

import com.ust.capstone.project_type_category_service.Repositeriy.ProjectTypeCategoryRepository;
import com.ust.capstone.project_type_category_service.entity.ProjectTypeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeCategoryService {

    private final ProjectTypeCategoryRepository projectTypeCategoryRepository;

    @Autowired
    public ProjectTypeCategoryService(ProjectTypeCategoryRepository projectTypeCategoryRepository) {
        this.projectTypeCategoryRepository = projectTypeCategoryRepository;
    }

    // Get all project type categories
    public List<ProjectTypeCategory> getAllProjectTypeCategories() {
        return projectTypeCategoryRepository.findAll();
    }

    // Get a specific project type category by ID
    public Optional<ProjectTypeCategory> getProjectTypeCategoryById(Long id) {
        return projectTypeCategoryRepository.findById(id);
    }

    // Create a new project type category
    public ProjectTypeCategory createProjectTypeCategory(ProjectTypeCategory projectTypeCategory) {
        return projectTypeCategoryRepository.saveAndFlush(projectTypeCategory);
    }

    // Update a project type category
    public ProjectTypeCategory updateProjectTypeCategory(Long id, ProjectTypeCategory projectTypeCategory) {
        if (projectTypeCategoryRepository.existsById(id)) {
            projectTypeCategory.setProjectTypeCategoryId(id);
            return projectTypeCategoryRepository.save(projectTypeCategory);
        }
        return null;
    }

    // Delete a project type category by ID
    public boolean deleteProjectTypeCategory(Long id) {
        if (projectTypeCategoryRepository.existsById(id)) {
            projectTypeCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
