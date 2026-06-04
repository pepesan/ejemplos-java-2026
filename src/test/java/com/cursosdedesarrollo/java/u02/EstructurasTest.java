package com.cursosdedesarrollo.java.u02;

import org.junit.Test;

public class EstructurasTest {
    @Test
    public void testCondicionales() {
        Integer i = 3;

        if (i > 5){
            System.out.println("Es mayor que 5");
        } else if (i > 2) {
            System.out.println("Es mayor que 2");
        } else {
            System.out.println("Es menor o igual que 2");
        }
    }

    @Test
    public void testCondicionalesMultiples() {
        int i = 3;
        switch (i) {
            case 1:
                System.out.println("Es valor es 1");
                break;
            case 2:
                System.out.println("Es valor es 2");
                break;
            default:
                System.out.println("no es ni 1 ni 2");
        }
    }

    @Test
    public void testBreak() {
        // break interrumpe el bucle en cuanto se cumple la condición.
        for (int i = 0; i < 10; i++) {
            if (i == 5) break;
            System.out.println(i); // imprime 0..4
        }
    }

    @Test
    public void testContinue() {
        // continue salta el resto del cuerpo y pasa a la siguiente iteración.
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            System.out.println(i); // imprime solo los impares: 1 3 5 7 9
        }
    }

    @Test
    public void testBuclesFor() {
        // Bucle for
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void testBuclesWhile() {
        int i = 0;
        while (i<10){
            System.out.println(i);
            i++;
        }
    }

    @Test
    public void testBuclesDoWhile() {
        // do-while garantiza que el cuerpo se ejecuta al menos una vez,
        // aunque la condición sea false desde el principio.
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 10);
    }
}
