package com.cursosdedesarrollo.java.u04;

// Unidad 04 — Modelo de dominio para el ejemplo JDBC con MySQL
public class Pedido {

    public enum Estado { PENDIENTE, PROCESADO, CANCELADO }

    private long   id;
    private String referencia;
    private String descripcion;
    private double total;
    private Estado estado;

    public Pedido() {}

    public Pedido(String referencia, String descripcion, double total) {
        this(0, referencia, descripcion, total, Estado.PENDIENTE);
    }

    public Pedido(long id, String referencia, String descripcion, double total, Estado estado) {
        this.id          = id;
        this.referencia  = referencia;
        this.descripcion = descripcion;
        this.total       = total;
        this.estado      = estado;
    }

    public long   getId()          { return id; }
    public String getReferencia()  { return referencia; }
    public String getDescripcion() { return descripcion; }
    public double getTotal()       { return total; }
    public Estado getEstado()      { return estado; }

    public void setId(long id)               { this.id          = id; }
    public void setReferencia(String r)      { this.referencia  = r; }
    public void setDescripcion(String d)     { this.descripcion = d; }
    public void setTotal(double t)           { this.total       = t; }
    public void setEstado(Estado e)          { this.estado      = e; }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", ref='" + referencia + "', total=" + total
             + ", estado=" + estado + "}";
    }
}
