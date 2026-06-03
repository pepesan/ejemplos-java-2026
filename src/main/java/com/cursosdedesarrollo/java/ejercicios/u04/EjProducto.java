package com.cursosdedesarrollo.java.ejercicios.u04;

// Ejercicio u04 — modelo de dominio Producto para ejercicios JDBC.
public class EjProducto {

    private long   id;
    private String nombre;
    private double precio;
    private int    stock;

    public EjProducto() {}

    public EjProducto(String nombre, double precio, int stock) {
        this(0, nombre, precio, stock);
    }

    public EjProducto(long id, String nombre, double precio, int stock) {
        this.id     = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock  = stock;
    }

    public long   getId()     { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int    getStock()  { return stock; }

    public void setId(long id)      { this.id     = id; }
    public void setNombre(String n) { this.nombre = n; }
    public void setPrecio(double p) { this.precio = p; }
    public void setStock(int s)     { this.stock  = s; }

    @Override
    public String toString() {
        return "EjProducto{id=" + id + ", nombre='" + nombre
             + "', precio=" + precio + ", stock=" + stock + "}";
    }
}
