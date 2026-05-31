package com.cursosdedesarrollo.java.u04;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

public class ClienteRepositoryTest {

    private ClienteRepository repo;

    @Before
    public void setUp() throws SQLException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");

        try (Connection conn = ds.getConnection();
             Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS clientes");
            st.execute("CREATE TABLE clientes (" +
                       "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                       "nombre VARCHAR(255)," +
                       "email  VARCHAR(255))");
        }
        repo = new ClienteRepository(ds);
    }

    @Test
    public void saveDevuelveIdGenerado() throws SQLException {
        long id = repo.save(new Cliente("Ana", "ana@test.com"));
        assertTrue(id > 0);
    }

    @Test
    public void findByIdDevuelveClienteGuardado() throws SQLException {
        long id = repo.save(new Cliente("Bob", "bob@test.com"));
        Optional<Cliente> found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals("Bob", found.get().getNombre());
        assertEquals("bob@test.com", found.get().getEmail());
    }

    @Test
    public void findByIdDevuelveEmptyParaIdInexistente() throws SQLException {
        assertFalse(repo.findById(999L).isPresent());
    }

    @Test
    public void findAllDevuelveTodosLosClientes() throws SQLException {
        repo.save(new Cliente("Ana", "ana@test.com"));
        repo.save(new Cliente("Bob", "bob@test.com"));
        List<Cliente> lista = repo.findAll();
        assertEquals(2, lista.size());
    }

    @Test
    public void deleteByIdElimina() throws SQLException {
        long id = repo.save(new Cliente("Eva", "eva@test.com"));
        repo.deleteById(id);
        assertFalse(repo.findById(id).isPresent());
    }
}
