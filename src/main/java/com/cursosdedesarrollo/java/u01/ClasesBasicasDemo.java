package com.cursosdedesarrollo.java.u01;

// Unidad 01 — Demo ejecutable: constructores, getters/setters y atributos estáticos
public class ClasesBasicasDemo {

    public static void main(String[] args) {

        // Vehiculo: el constructor de un argumento delega en el de dos con this()
        Vehiculo v1 = new Vehiculo("Toyota", 2020);
        Vehiculo v2 = new Vehiculo("Honda");        // año toma el valor por defecto 2026
        System.out.println(v1);                     // → Vehiculo{marca='Toyota', año=2020}
        System.out.println(v2.getAño());            // → 2026

        // Producto: setter valida — un precio negativo no se aplica
        Producto p = new Producto("Teclado", 49.99);
        p.setPrecio(-10);                           // ignorado, precio sigue siendo 49.99
        System.out.println(p);                      // → Producto{nombre='Teclado', precio=49.99}

        // Persona: atributo estático cuenta instancias; Builder construye el objeto paso a paso
        Persona.resetTotal();
        Persona ana = new Persona.Builder().nombre("Ana").edad(30).build();
        Persona bob = new Persona.Builder().nombre("Bob").edad(25).build();
        System.out.println(Persona.getTotal());     // → 2  (compartido por todas las instancias)
        System.out.println(ana.saludar());          // → Hola, soy Ana
        System.out.println(bob);                    // → Persona{nombre='Bob', edad=25}
    }
}
