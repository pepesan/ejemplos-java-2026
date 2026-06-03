package com.cursosdedesarrollo.java.ejercicios.u02;

import org.junit.Test;
import static org.junit.Assert.*;

public class EjEstadisticasArrayTest {

    private final int[] datos = {5, 3, 8, 1, 9, 2};

    @Test
    public void maximoDevuelveElMayor()       { assertEquals(9, EjEstadisticasArray.maximo(datos)); }
    @Test
    public void minimoDevuelveElMenor()       { assertEquals(1, EjEstadisticasArray.minimo(datos)); }
    @Test
    public void mediaEsCorrecta()             { assertEquals(4.666, EjEstadisticasArray.media(datos), 0.001); }

    @Test
    public void ordenadoNoModificaOriginal() {
        int[] copia = {3, 1, 2};
        int[] ord   = EjEstadisticasArray.ordenadoAscendente(copia);
        assertArrayEquals(new int[]{1, 2, 3}, ord);
        assertArrayEquals(new int[]{3, 1, 2}, copia); // original intacto
    }

    @Test
    public void arrayDeUnElementoDevuelveEseElemento() {
        int[] uno = {42};
        assertEquals(42, EjEstadisticasArray.maximo(uno));
        assertEquals(42, EjEstadisticasArray.minimo(uno));
        assertEquals(42.0, EjEstadisticasArray.media(uno), 0.001);
    }
}
