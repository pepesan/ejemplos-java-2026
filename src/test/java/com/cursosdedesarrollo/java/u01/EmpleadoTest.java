package com.cursosdedesarrollo.java.u01;

import org.junit.Test;

public class EmpleadoTest {
    @Test
    public void testObjetoDeClase() {
        // No puedo crear un objeto de clase abstracta
        // Empleado e = new Empleado("Adrián", 45000);
        // Pero sí podemos inicializar un objeto de una clase que herede
        // de la clase Abstracta, en este caso Empleado, que implemente
        // los métodos que queden pendiente de implementar en la clase asbtracta
        EmpleadoFijo empleadoFijo = new EmpleadoFijo("Lais", 45000.0);
        empleadoFijo.calcularPago();

    }
}
