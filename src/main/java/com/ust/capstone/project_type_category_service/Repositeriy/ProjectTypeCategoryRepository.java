package com.ust.capstone.project_type_category_service.Repositeriy;

import com.ust.capstone.project_type_category_service.entity.ProjectTypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeCategoryRepository extends JpaRepository<ProjectTypeCategory, Long> {

}
