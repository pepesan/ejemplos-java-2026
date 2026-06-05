package com.cursosdedesarrollo.java.u04;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/*
 * Tests de integración contra MySQL real.
 * Requisito: contenedor levantado con  docker/01-up.sh
 * Para ejecutar este test en concreto:
 *   mvn test -Dtest=PedidoRepositoryMysqlTest -Dmysql.skip=false
 */
@Ignore("Requiere contenedor MySQL — ejecutar docker/01-up.sh antes de activar")
public class PedidoRepositoryMysqlTest {

    private static final String URL      = "jdbc:mysql://localhost:3306/cursodb"
                                         + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER     = "root";
    private static final String PASSWORD = "root";

    private PedidoRepository repo;

    @Before
    public void setUp() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(URL);
        ds.setUser(USER);
        ds.setPassword(PASSWORD);
        repo = new PedidoRepository(ds);

        // Limpia los pedidos de test anteriores para que los tests sean repetibles
        try (var conn = ds.getConnection();
             var st = conn.createStatement()) {
            st.execute("DELETE FROM pedidos WHERE referencia LIKE 'TEST-%'");
        }
    }

    @Test
    public void saveDevuelveIdPositivo() throws SQLException {
        long id = repo.save(new Pedido("TEST-001", "Pedido de prueba", 99.99));
        assertTrue("El id generado debe ser positivo", id > 0);
    }

    @Test
    public void findByIdDevuelvePedidoGuardado() throws SQLException {
        long id = repo.save(new Pedido("TEST-002", "Material de prueba", 250.00));
        Optional<Pedido> found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals("TEST-002",          found.get().getReferencia());
        assertEquals("Material de prueba",found.get().getDescripcion());
        assertEquals(250.00, found.get().getTotal(), 0.001);
        assertEquals(Pedido.Estado.PENDIENTE, found.get().getEstado());
    }

    @Test
    public void findByIdInexistenteDevuelveEmpty() throws SQLException {
        assertFalse(repo.findById(Long.MAX_VALUE).isPresent());
    }

    @Test
    public void findAllDevuelveAlMenosLosPedidosInsertados() throws SQLException {
        repo.save(new Pedido("TEST-003", "Pedido A", 10.0));
        repo.save(new Pedido("TEST-004", "Pedido B", 20.0));
        List<Pedido> lista = repo.findAll();
        assertTrue("Debe haber al menos 2 pedidos", lista.size() >= 2);
    }

    @Test
    public void findByEstadoFiltraCorrectamente() throws SQLException {
        repo.save(new Pedido("TEST-005", "Pedido pendiente", 50.0));
        List<Pedido> pendientes = repo.findByEstado(Pedido.Estado.PENDIENTE);
        assertTrue(pendientes.stream().allMatch(p -> p.getEstado() == Pedido.Estado.PENDIENTE));
    }

    @Test
    public void updateEstadoCambiaElValor() throws SQLException {
        long id = repo.save(new Pedido("TEST-006", "Pedido a procesar", 75.0));
        repo.updateEstado(id, Pedido.Estado.PROCESADO);
        assertEquals(Pedido.Estado.PROCESADO, repo.findById(id).get().getEstado());
    }

    @Test
    public void deleteByIdEliminaElPedido() throws SQLException {
        long id = repo.save(new Pedido("TEST-007", "Pedido a borrar", 30.0));
        repo.deleteById(id);
        assertFalse(repo.findById(id).isPresent());
    }
}
