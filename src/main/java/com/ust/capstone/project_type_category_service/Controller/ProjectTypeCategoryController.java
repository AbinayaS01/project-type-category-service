package com.ust.capstone.project_type_category_service.Controller;

import com.ust.capstone.project_type_category_service.entity.ProjectTypeCategory;
import com.ust.capstone.project_type_category_service.service.ProjectTypeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjectTypeCategoryController {

    private final ProjectTypeCategoryService projectTypeCategoryService;

    @Autowired
    public ProjectTypeCategoryController(ProjectTypeCategoryService projectTypeCategoryService) {
        this.projectTypeCategoryService = projectTypeCategoryService;
    }

    // Fetch all project type categories
   
    @GetMapping("/project-type-categories")
    public List<ProjectTypeCategory> getAllProjectTypeCategories() {
        return projectTypeCategoryService.getAllProjectTypeCategories();
    }

    // Fetch a specific project type category by ID
    
    @GetMapping("/project-type-categories/{id}")
    public ResponseEntity<ProjectTypeCategory> getProjectTypeCategoryById(@PathVariable Long id) {
        Optional<ProjectTypeCategory> projectTypeCategory = projectTypeCategoryService.getProjectTypeCategoryById(id);
        return projectTypeCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new project type category
    
    @PostMapping("/project-type-categories")
    public ResponseEntity<ProjectTypeCategory> createProjectTypeCategory(@RequestBody ProjectTypeCategory projectTypeCategory) {
        ProjectTypeCategory createdProjectTypeCategory = projectTypeCategoryService.createProjectTypeCategory(projectTypeCategory);
        return new ResponseEntity<>(createdProjectTypeCategory, HttpStatus.CREATED);
    }

    // Update a project type category
    
    @PutMapping("/project-type-categories/{id}")
    public ResponseEntity<ProjectTypeCategory> updateProjectTypeCategory(@PathVariable Long id, @RequestBody ProjectTypeCategory projectTypeCategory) {
        ProjectTypeCategory updatedProjectTypeCategory = projectTypeCategoryService.updateProjectTypeCategory(id, projectTypeCategory);
        return updatedProjectTypeCategory != null ? ResponseEntity.ok(updatedProjectTypeCategory) : ResponseEntity.notFound().build();
    }

    // Delete a project type category by ID
    
    @DeleteMapping("/project-type-categories/{id}")
    public ResponseEntity<Void> deleteProjectTypeCategory(@PathVariable Long id) {
        boolean isDeleted = projectTypeCategoryService.deleteProjectTypeCategory(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
