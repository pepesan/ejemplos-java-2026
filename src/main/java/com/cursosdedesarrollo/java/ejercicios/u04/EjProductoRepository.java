package com.cursosdedesarrollo.java.ejercicios.u04;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Ejercicio u04 — CRUD completo de EjProducto con JDBC y DataSource.
// Mismos patrones que ClienteRepository: PreparedStatement, try-with-resources, row mapper.
public class EjProductoRepository {

    private final DataSource ds;

    public EjProductoRepository(DataSource ds) { this.ds = ds; }

    public long save(EjProducto p) throws SQLException {
        String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt   (3, p.getStock());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (!keys.next()) throw new SQLException("INSERT no generó clave");
                return keys.getLong(1);
            }
        }
    }

    public Optional<EjProducto> findById(long id) throws SQLException {
        String sql = "SELECT id, nombre, precio, stock FROM productos WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        }
    }

    public List<EjProducto> findAll() throws SQLException {
        List<EjProducto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, stock FROM productos";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapRow(rs));
        }
        return lista;
    }

    public void updatePrecio(long id, double nuevoPrecio) throws SQLException {
        String sql = "UPDATE productos SET precio = ? WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, nuevoPrecio);
            ps.setLong  (2, id);
            ps.executeUpdate();
        }
    }

    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    private EjProducto mapRow(ResultSet rs) throws SQLException {
        return new EjProducto(
            rs.getLong  ("id"),
            rs.getString("nombre"),
            rs.getDouble("precio"),
            rs.getInt   ("stock")
        );
    }
}
