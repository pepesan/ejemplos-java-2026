package com.cursosdedesarrollo.java.u02;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ArraysTest {

    @Test
    public void testArraysAcceso() {
        int[] notas = {7, 8, 6, 9, 5};
        assertEquals(7, notas[0]);
        assertEquals(8, notas[1]);
        assertEquals(5, notas[4]);
        notas[4] = 8;
        assertEquals(8, notas[4]);
    }
    @Test
    public void mediaDeNotasCorrectamente() {
        int[] notas = {7, 8, 6, 9, 5};
        int suma = 0;
        for (int n : notas) suma += n;
        double media = (double) suma / notas.length;
        assertEquals(7.0, media, 0.001);
    }

    @Test
    public void sortOrdenaInPlace() {
        int[] notas = {7, 8, 6, 9, 5};
        Arrays.sort(notas);
        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, notas);
    }

    @Test
    public void copyOfRecortaArray() {
        int[] notas = {5, 6, 7, 8, 9};
        int[] copia = Arrays.copyOf(notas, 3);
        assertArrayEquals(new int[]{5, 6, 7}, copia);
    }

    @Test
    public void fillRellenaConValor() {
        int[] arr = new int[3];
        Arrays.fill(arr, 99);
        assertArrayEquals(new int[]{99, 99, 99}, arr);
    }

    @Test
    public void toStringFormatoLegible() {
        int[] arr = {1, 2, 3};
        assertEquals("[1, 2, 3]", Arrays.toString(arr));
    }
}
