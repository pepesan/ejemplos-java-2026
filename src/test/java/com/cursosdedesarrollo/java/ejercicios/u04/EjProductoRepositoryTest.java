package com.cursosdedesarrollo.java.ejercicios.u04;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

public class EjProductoRepositoryTest {

    private EjProductoRepository repo;

    @Before
    public void setUp() throws SQLException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:productosdb;DB_CLOSE_DELAY=-1");

        try (Connection conn = ds.getConnection(); Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS productos");
            st.execute("CREATE TABLE productos (" +
                       "id     BIGINT AUTO_INCREMENT PRIMARY KEY," +
                       "nombre VARCHAR(255)," +
                       "precio DOUBLE," +
                       "stock  INT)");
        }
        repo = new EjProductoRepository(ds);
    }

    @Test
    public void saveDevuelveIdPositivo() throws SQLException {
        long id = repo.save(new EjProducto("Teclado", 49.99, 10));
        assertTrue(id > 0);
    }

    @Test
    public void findByIdDevuelveProductoGuardado() throws SQLException {
        long id = repo.save(new EjProducto("Ratón", 29.99, 5));
        Optional<EjProducto> found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals("Ratón", found.get().getNombre());
        assertEquals(29.99, found.get().getPrecio(), 0.001);
        assertEquals(5, found.get().getStock());
    }

    @Test
    public void findByIdInexistenteDevuelveEmpty() throws SQLException {
        assertFalse(repo.findById(999L).isPresent());
    }

    @Test
    public void findAllDevuelveTodosLosProductos() throws SQLException {
        repo.save(new EjProducto("A", 1.0, 1));
        repo.save(new EjProducto("B", 2.0, 2));
        List<EjProducto> lista = repo.findAll();
        assertEquals(2, lista.size());
    }

    @Test
    public void updatePrecioActualizaElValor() throws SQLException {
        long id = repo.save(new EjProducto("Monitor", 299.0, 3));
        repo.updatePrecio(id, 259.0);
        assertEquals(259.0, repo.findById(id).get().getPrecio(), 0.001);
    }

    @Test
    public void deleteByIdEliminaElProducto() throws SQLException {
        long id = repo.save(new EjProducto("Cable", 5.0, 20));
        repo.deleteById(id);
        assertFalse(repo.findById(id).isPresent());
    }
}
