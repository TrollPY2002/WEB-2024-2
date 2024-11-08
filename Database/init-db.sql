-- database/init-db.sql
CREATE DATABASE IF NOT EXISTS web_2024_2;

USE web_2024_2;

-- Tabla de Clientes
CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    celular INT NOT NULL,
    cedula INT UNIQUE NOT NULL,
    correo VARCHAR(100),
    tiene_cita BOOLEAN DEFAULT FALSE,
    fecha_proxima_cita DATE,
    historial_medico LONGBLOB
);