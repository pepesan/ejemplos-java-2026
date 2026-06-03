package com.cursosdedesarrollo.java.ejercicios.u05;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

public class EjBuscadorUsuarioTest {

    private List<EjBuscadorUsuario.Usuario> usuarios;

    @Before
    public void setUp() {
        usuarios = Arrays.asList(
            new EjBuscadorUsuario.Usuario("Ana",   "ana@test.com",   25),
            new EjBuscadorUsuario.Usuario("Bob",   "bob@test.com",   16),
            new EjBuscadorUsuario.Usuario("Carlos","carlos@test.com", 30)
        );
    }

    @Test
    public void buscarPorNombreExistenteDevuelvePresente() {
        Optional<EjBuscadorUsuario.Usuario> u = EjBuscadorUsuario.buscarPorNombre(usuarios, "Ana");
        assertTrue(u.isPresent());
        assertEquals("ana@test.com", u.get().getEmail());
    }

    @Test
    public void buscarPorNombreInexistenteDevuelveVacio() {
        assertFalse(EjBuscadorUsuario.buscarPorNombre(usuarios, "Nadie").isPresent());
    }

    @Test
    public void buscarEsInsensibleAMayusculas() {
        assertTrue(EjBuscadorUsuario.buscarPorNombre(usuarios, "BOB").isPresent());
    }

    @Test
    public void emailSiMayorDeEdad_conEdadSuficiente() {
        Optional<EjBuscadorUsuario.Usuario> ana = EjBuscadorUsuario.buscarPorNombre(usuarios, "Ana");
        assertEquals("ana@test.com", EjBuscadorUsuario.emailSiMayorDeEdad(ana, 18));
    }

    @Test
    public void emailSiMayorDeEdad_menorDeEdadDevuelveDefault() {
        Optional<EjBuscadorUsuario.Usuario> bob = EjBuscadorUsuario.buscarPorNombre(usuarios, "Bob");
        assertEquals("acceso-denegado@ejemplo.com", EjBuscadorUsuario.emailSiMayorDeEdad(bob, 18));
    }

    @Test(expected = IllegalArgumentException.class)
    public void obtenerOFallarLanzaExcepcionSiNoExiste() {
        EjBuscadorUsuario.obtenerOFallar(usuarios, "Fantasma");
    }
}
