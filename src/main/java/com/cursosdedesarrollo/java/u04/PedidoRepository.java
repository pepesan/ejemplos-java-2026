package com.cursosdedesarrollo.java.u04;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Unidad 04 — CRUD completo con JDBC conectado a MySQL
public class PedidoRepository {

    private final DataSource ds;

    public PedidoRepository(DataSource ds) {
        this.ds = ds;
    }

    // INSERT — devuelve la PK autogenerada
    public long save(Pedido p) throws SQLException {
        String sql = "INSERT INTO pedidos (referencia, descripcion, total, estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getReferencia());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getTotal());
            ps.setString(4, p.getEstado().name());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (!keys.next()) throw new SQLException("INSERT no generó clave");
                return keys.getLong(1);
            }
        }
    }

    // SELECT por PK
    public Optional<Pedido> findById(long id) throws SQLException {
        String sql = "SELECT id, referencia, descripcion, total, estado FROM pedidos WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        }
    }

    // SELECT todos
    public List<Pedido> findAll() throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT id, referencia, descripcion, total, estado FROM pedidos";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapRow(rs));
        }
        return lista;
    }

    // SELECT filtrado por estado — demuestra parámetros en WHERE
    public List<Pedido> findByEstado(Pedido.Estado estado) throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT id, referencia, descripcion, total, estado FROM pedidos WHERE estado = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, estado.name());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) lista.add(mapRow(rs));
            }
        }
        return lista;
    }

    // UPDATE — cambia el estado del pedido
    public void updateEstado(long id, Pedido.Estado nuevoEstado) throws SQLException {
        String sql = "UPDATE pedidos SET estado = ? WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado.name());
            ps.setLong  (2, id);
            ps.executeUpdate();
        }
    }

    // DELETE por PK
    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    // Row mapper: construir Pedido desde ResultSet
    private Pedido mapRow(ResultSet rs) throws SQLException {
        return new Pedido(
            rs.getLong  ("id"),
            rs.getString("referencia"),
            rs.getString("descripcion"),
            rs.getDouble("total"),
            Pedido.Estado.valueOf(rs.getString("estado"))
        );
    }
}
