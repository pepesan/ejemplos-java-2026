package com.cursosdedesarrollo.java.ejercicios.u05;

import java.util.List;
import java.util.Optional;

// Ejercicio u05-2: Optional — eliminar null explícito al buscar en una colección.
// Demuestra: empty, ofNullable, filter, map, orElse, orElseThrow, ifPresent.
public class EjBuscadorUsuario {

    public static class Usuario {
        private final String nombre;
        private final String email;
        private final int    edad;

        public Usuario(String nombre, String email, int edad) {
            this.nombre = nombre;
            this.email  = email;
            this.edad   = edad;
        }

        public String getNombre() { return nombre; }
        public String getEmail()  { return email; }
        public int    getEdad()   { return edad; }
    }

    // Devuelve Optional vacío si no existe — nunca null
    public static Optional<Usuario> buscarPorNombre(List<Usuario> usuarios, String nombre) {
        return usuarios.stream()
            .filter(u -> u.getNombre().equalsIgnoreCase(nombre))
            .findFirst();
    }

    // Encadena filter + map + orElse sin ningún if (x != null)
    public static String emailSiMayorDeEdad(Optional<Usuario> usuario, int edadMinima) {
        return usuario
            .filter(u -> u.getEdad() >= edadMinima)
            .map(Usuario::getEmail)
            .orElse("acceso-denegado@ejemplo.com");
    }

    // orElseThrow: cuando la ausencia es un error que no se puede recuperar
    public static Usuario obtenerOFallar(List<Usuario> usuarios, String nombre) {
        return buscarPorNombre(usuarios, nombre)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + nombre));
    }
}
