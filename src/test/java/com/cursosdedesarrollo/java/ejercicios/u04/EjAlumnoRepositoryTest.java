package com.cursosdedesarrollo.java.ejercicios.u04;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/*
 * EJERCICIO — Unidad 04 — JDBC con MySQL
 * ========================================
 * Tests de integración para EjAlumnoRepository contra la base de datos MySQL.
 *
 * ENUNCIADO DEL EJERCICIO
 * -----------------------
 * 1. Levanta el entorno con  docker/01-up.sh
 * 2. Comprueba que la tabla `alumnos` existe en phpMyAdmin (http://localhost:8080)
 * 3. Implementa EjAlumnoRepository si todavía no lo has hecho (ver el esqueleto ya creado)
 * 4. Quita el @Ignore de esta clase y ejecuta los tests:
 *      mvn test -Dtest=EjAlumnoRepositoryTest
 * 5. Haz que todos los tests pasen en verde
 *
 * PISTAS
 * ------
 * - Sigue el mismo patrón que PedidoRepository (DataSource → PreparedStatement → ResultSet)
 * - La columna email tiene restricción UNIQUE: usa emails distintos en cada test
 * - updateCurso y findByCurso son análogos a updateEstado y findByEstado de PedidoRepository
 *
 * Requisito: contenedor MySQL levantado (docker/01-up.sh)
 */
@Ignore("EJERCICIO — quita este @Ignore cuando hayas implementado EjAlumnoRepository")
public class EjAlumnoRepositoryTest {

    private static final String URL      = "jdbc:mysql://localhost:3306/cursodb"
                                         + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER     = "root";
    private static final String PASSWORD = "root";

    private EjAlumnoRepository repo;

    @Before
    public void setUp() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(URL);
        ds.setUser(USER);
        ds.setPassword(PASSWORD);
        repo = new EjAlumnoRepository(ds);

        // Limpia sólo los alumnos de test para no interferir con los datos de ejemplo
        try (var conn = ds.getConnection();
             var st = conn.createStatement()) {
            st.execute("DELETE FROM alumnos WHERE email LIKE 'test.%'");
        }
    }

    @Test
    public void saveDevuelveIdPositivo() throws SQLException {
        long id = repo.save(new EjAlumno("Ana", "Pérez Gil", "test.ana@test.com", "Java 2026"));
        assertTrue(id > 0);
    }

    @Test
    public void findByIdDevuelveAlumnoGuardado() throws SQLException {
        long id = repo.save(new EjAlumno("Luis", "García", "test.luis@test.com", "Java 2026"));
        Optional<EjAlumno> found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals("Luis",       found.get().getNombre());
        assertEquals("García",     found.get().getApellidos());
        assertEquals("Java 2026",  found.get().getCurso());
    }

    @Test
    public void findByIdInexistenteDevuelveEmpty() throws SQLException {
        assertFalse(repo.findById(Long.MAX_VALUE).isPresent());
    }

    @Test
    public void findAllDevuelveAlMenosLosAlumnosInsertados() throws SQLException {
        repo.save(new EjAlumno("Eva", "Ruiz", "test.eva@test.com",  "Python 2026"));
        repo.save(new EjAlumno("Pep", "Mas",  "test.pep@test.com",  "Python 2026"));
        List<EjAlumno> lista = repo.findAll();
        assertTrue(lista.size() >= 2);
    }

    @Test
    public void findByCursoDevuelveSoloLosDeEseCurso() throws SQLException {
        repo.save(new EjAlumno("Iker", "Alonso", "test.iker@test.com", "Java 2026"));
        List<EjAlumno> resultado = repo.findByCurso("Java 2026");
        assertTrue(resultado.stream().allMatch(a -> "Java 2026".equals(a.getCurso())));
    }

    @Test
    public void updateCursoCambiaElValor() throws SQLException {
        long id = repo.save(new EjAlumno("Noa", "Vidal", "test.noa@test.com", "Java 2026"));
        repo.updateCurso(id, "Python 2026");
        assertEquals("Python 2026", repo.findById(id).get().getCurso());
    }

    @Test
    public void deleteByIdEliminaElAlumno() throws SQLException {
        long id = repo.save(new EjAlumno("Pol", "Roca", "test.pol@test.com", "Java 2026"));
        repo.deleteById(id);
        assertFalse(repo.findById(id).isPresent());
    }
}
