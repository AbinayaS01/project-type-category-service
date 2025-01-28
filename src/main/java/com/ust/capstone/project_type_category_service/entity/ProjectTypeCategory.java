package com.ust.capstone.project_type_category_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "project_type_category")  
public class ProjectTypeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_type_category_id")  
    private Long projectTypeCategoryId;

    @Column(name = "project_type_category_name")  
    private String projectTypeCategoryName;

    @Column(name = "project_id")  
    private Long projectId;
}
