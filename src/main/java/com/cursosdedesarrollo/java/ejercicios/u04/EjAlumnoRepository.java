package com.cursosdedesarrollo.java.ejercicios.u04;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * EJERCICIO — Unidad 04 — JDBC con MySQL
 * ========================================
 * Implementa un repositorio JDBC para la tabla `alumnos` usando los mismos
 * patrones vistos en PedidoRepository:
 *   - DataSource inyectado por constructor
 *   - PreparedStatement para evitar SQL injection
 *   - try-with-resources para cerrar recursos
 *   - Row mapper para convertir ResultSet → objeto de dominio
 *
 * La tabla alumnos tiene: id, nombre, apellidos, email, curso
 * (ver docker/init.sql para el DDL completo)
 */
public class EjAlumnoRepository {

    private final DataSource ds;

    public EjAlumnoRepository(DataSource ds) {
        this.ds = ds;
    }

    // INSERT — devuelve la PK autogenerada
    public long save(EjAlumno a) throws SQLException {
        String sql = "INSERT INTO alumnos (nombre, apellidos, email, curso) VALUES (?, ?, ?, ?)";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getCurso());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (!keys.next()) throw new SQLException("INSERT no generó clave");
                return keys.getLong(1);
            }
        }
    }

    // SELECT por PK
    public Optional<EjAlumno> findById(long id) throws SQLException {
        String sql = "SELECT id, nombre, apellidos, email, curso FROM alumnos WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        }
    }

    // SELECT todos
    public List<EjAlumno> findAll() throws SQLException {
        List<EjAlumno> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidos, email, curso FROM alumnos";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapRow(rs));
        }
        return lista;
    }

    // SELECT filtrado por curso
    public List<EjAlumno> findByCurso(String curso) throws SQLException {
        List<EjAlumno> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidos, email, curso FROM alumnos WHERE curso = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, curso);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) lista.add(mapRow(rs));
            }
        }
        return lista;
    }

    // UPDATE — cambia el curso del alumno
    public void updateCurso(long id, String nuevoCurso) throws SQLException {
        String sql = "UPDATE alumnos SET curso = ? WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoCurso);
            ps.setLong  (2, id);
            ps.executeUpdate();
        }
    }

    // DELETE por PK
    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    // Row mapper: construir EjAlumno desde ResultSet
    private EjAlumno mapRow(ResultSet rs) throws SQLException {
        return new EjAlumno(
            rs.getLong  ("id"),
            rs.getString("nombre"),
            rs.getString("apellidos"),
            rs.getString("email"),
            rs.getString("curso")
        );
    }
}
