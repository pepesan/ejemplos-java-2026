package com.cursosdedesarrollo.java.ejercicios.u01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EjBibliotecaTest {

    private EjBiblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = new EjBiblioteca("Central");
        biblioteca.agregar(new EjBiblioteca.Libro("Don Quijote", "Cervantes", 1605));
        biblioteca.agregar(new EjBiblioteca.Libro("1984", "Orwell", 1949));
    }

    @Test
    public void agregarAumentaElTotal() {
        assertEquals(2, biblioteca.totalLibros());
        biblioteca.agregar(new EjBiblioteca.Libro("Dune", "Herbert", 1965));
        assertEquals(3, biblioteca.totalLibros());
    }

    @Test
    public void agregarNullNoAumentaElTotal() {
        biblioteca.agregar(null);
        assertEquals(2, biblioteca.totalLibros());
    }

    @Test
    public void eliminarPorTituloReduceElTotal() {
        assertTrue(biblioteca.eliminar("1984"));
        assertEquals(1, biblioteca.totalLibros());
    }

    @Test
    public void eliminarTituloInexistenteDevuelveFalse() {
        assertFalse(biblioteca.eliminar("Libro Inexistente"));
        assertEquals(2, biblioteca.totalLibros());
    }

    @Test
    public void buscarPorTituloDevuelveElLibro() {
        EjBiblioteca.Libro libro = biblioteca.buscarPorTitulo("1984");
        assertNotNull(libro);
        assertEquals("Orwell", libro.getAutor());
    }

    @Test
    public void buscarPorTituloInexistenteDevuelveNull() {
        assertNull(biblioteca.buscarPorTitulo("Invisible"));
    }

    @Test
    public void getLibrosDevuelveCopiaIndependiente() {
        // Modificar la copia no afecta a la biblioteca original
        biblioteca.getLibros().add(new EjBiblioteca.Libro("X", "Y", 2000));
        assertEquals(2, biblioteca.totalLibros());
    }
}
