package com.cursosdedesarrollo.java.ejercicios.u04;

/*
 * EJERCICIO — Unidad 04 — JDBC con MySQL
 * ========================================
 * Entidad de dominio que representa un alumno matriculado en un curso.
 * La tabla correspondiente en MySQL es `alumnos` (ver docker/init.sql).
 */
public class EjAlumno {

    private long   id;
    private String nombre;
    private String apellidos;
    private String email;
    private String curso;

    public EjAlumno() {}

    public EjAlumno(String nombre, String apellidos, String email, String curso) {
        this(0, nombre, apellidos, email, curso);
    }

    public EjAlumno(long id, String nombre, String apellidos, String email, String curso) {
        this.id        = id;
        this.nombre    = nombre;
        this.apellidos = apellidos;
        this.email     = email;
        this.curso     = curso;
    }

    public long   getId()        { return id; }
    public String getNombre()    { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getEmail()     { return email; }
    public String getCurso()     { return curso; }

    public void setId(long id)           { this.id        = id; }
    public void setNombre(String n)      { this.nombre    = n; }
    public void setApellidos(String a)   { this.apellidos = a; }
    public void setEmail(String e)       { this.email     = e; }
    public void setCurso(String c)       { this.curso     = c; }

    @Override
    public String toString() {
        return "EjAlumno{id=" + id + ", nombre='" + nombre + " " + apellidos
             + "', email='" + email + "', curso='" + curso + "'}";
    }
}
