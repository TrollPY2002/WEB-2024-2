-- database/init-db.sql
CREATE DATABASE IF NOT EXISTS web_2024_2;

CREATE TABLE IF NOT EXISTS department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    chief_id BIGINT
);
CREATE TABLE IF NOT EXISTS Employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) UNIQUE NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birthdate DATE,
    dep_id BIGINT,
    pos_id BIGINT,
    entry_date DATE,
    CONSTRAINT fk_department FOREIGN KEY (dep_id) REFERENCES Department(id),
    CONSTRAINT fk_position FOREIGN KEY (pos_id) REFERENCES Position(id)
);
CREATE TABLE IF NOT EXISTS Position (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    salary BIGINT
);
CREATE TABLE IF NOT EXISTS Project (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    start_date DATE,
    end_date DATE
);
CREATE TABLE IF NOT EXISTS ProjectAssignment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    UNIQUE (project_id, employee_id),  -- Restricción única para evitar duplicados en asignaciones
    CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES Project(id),
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES Employee(id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES Role(id)
);
CREATE TABLE IF NOT EXISTS Role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);
CREATE TABLE IF NOT EXISTS Visit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    UNIQUE (department_id, employee_id),  -- Restricción única para evitar duplicados en visitas
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES Department(id),
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

;