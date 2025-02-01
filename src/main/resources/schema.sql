CREATE TABLE project_type_category(
	project_type_category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_type_category_name VARCHAR(255) NOT NULL,
    project_id BIGINT NOT NULL
);