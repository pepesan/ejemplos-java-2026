package com.cursosdedesarrollo.java.ejercicios.u01;

// Ejercicio u01-7: atributos y métodos estáticos
public class EjSesion {

    private static int totalSesiones = 0;

    private final int id;
    private String usuario;

    public EjSesion(String usuario) {
        totalSesiones++;
        this.id      = totalSesiones;
        this.usuario = usuario;
    }

    public static int getTotalSesiones() { return totalSesiones; }

    public static void resetear() { totalSesiones = 0; }

    public int    getId()      { return id; }
    public String getUsuario() { return usuario; }
    public void   setUsuario(String usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Sesion{id=" + id + ", usuario='" + usuario + "'}";
    }
}
