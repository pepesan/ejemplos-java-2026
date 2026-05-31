package com.cursosdedesarrollo.java.u04;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Unidad 04 — CRUD completo con JDBC y DataSource
public class ClienteRepository {

    private final DataSource ds;

    public ClienteRepository(DataSource ds) {
        this.ds = ds;
    }

    // Insertar y recuperar la clave generada automáticamente
    public long save(Cliente c) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, email) VALUES (?, ?)";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (!keys.next()) throw new SQLException("INSERT no generó clave");
                return keys.getLong(1);
            }
        }
    }

    public Optional<Cliente> findById(long id) throws SQLException {
        String sql = "SELECT id, nombre, email FROM clientes WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(mapRow(rs));
                return Optional.empty();
            }
        }
    }

    public List<Cliente> findAll() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, email FROM clientes";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapRow(rs));
        }
        return lista;
    }

    public void deleteById(long id) throws SQLException {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM clientes WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    // Row mapper: construir objeto de dominio desde ResultSet
    private Cliente mapRow(ResultSet rs) throws SQLException {
        return new Cliente(
            rs.getLong("id"),
            rs.getString("nombre"),
            rs.getString("email")
        );
    }
}
