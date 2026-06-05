-- Base de datos para los ejemplos del curso Java
CREATE DATABASE IF NOT EXISTS cursodb
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE cursodb;

-- ── Unidad 04 — Ejemplo H2 (se crea en memoria en el test, esta tabla es de referencia) ──

CREATE TABLE IF NOT EXISTS clientes (
    id     BIGINT       AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email  VARCHAR(255) NOT NULL
);

-- ── Unidad 04 — Ejemplo MySQL ──────────────────────────────────────────────────────────

CREATE TABLE IF NOT EXISTS pedidos (
    id          BIGINT         AUTO_INCREMENT PRIMARY KEY,
    referencia  VARCHAR(50)    NOT NULL UNIQUE,
    descripcion VARCHAR(500)   NOT NULL,
    total       DECIMAL(10,2)  NOT NULL,
    estado      ENUM('PENDIENTE','PROCESADO','CANCELADO') NOT NULL DEFAULT 'PENDIENTE'
);

INSERT INTO pedidos (referencia, descripcion, total, estado) VALUES
    ('PED-001', 'Compra inicial de material de oficina', 149.95, 'PROCESADO'),
    ('PED-002', 'Licencias software primer trimestre',   899.00, 'PENDIENTE'),
    ('PED-003', 'Mobiliario sala de reuniones',         1250.00, 'CANCELADO');

-- ── Unidad 04 — Ejercicio MySQL ────────────────────────────────────────────────────────

CREATE TABLE IF NOT EXISTS alumnos (
    id        BIGINT       AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(100) NOT NULL,
    apellidos VARCHAR(200) NOT NULL,
    email     VARCHAR(255) NOT NULL UNIQUE,
    curso     VARCHAR(100) NOT NULL
);

INSERT INTO alumnos (nombre, apellidos, email, curso) VALUES
    ('María',   'García López',    'maria@curso.com',  'Java 2026'),
    ('Carlos',  'Martínez Ruiz',   'carlos@curso.com', 'Java 2026'),
    ('Lucía',   'Fernández Pérez', 'lucia@curso.com',  'Python 2026');

-- ── Unidad 04 — Ejercicio H2 (referencia) ─────────────────────────────────────────────

CREATE TABLE IF NOT EXISTS productos (
    id     BIGINT        AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)  NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock  INT           NOT NULL DEFAULT 0
);
