package com.cursosdedesarrollo.java.u04;

import java.io.Serializable;

// Unidad 04 — Modelo de dominio para ejemplos JDBC
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private long   id;
    private String nombre;
    private String email;

    public Cliente() {}

    public Cliente(long id, String nombre, String email) {
        this.id     = id;
        this.nombre = nombre;
        this.email  = email;
    }

    public Cliente(String nombre, String email) {
        this(0, nombre, email);
    }

    public long   getId()     { return id; }
    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }

    public void setId(long id)        { this.id     = id; }
    public void setNombre(String n)   { this.nombre = n; }
    public void setEmail(String e)    { this.email  = e; }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
    }
}
