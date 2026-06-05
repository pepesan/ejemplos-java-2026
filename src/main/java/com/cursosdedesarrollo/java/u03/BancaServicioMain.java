package com.cursosdedesarrollo.java.u03;

import java.util.Arrays;

public class BancaServicioMain {
    public static void main(String[] args) {
        BancaServicio bancaServicio = new BancaServicio(100);

        System.out.println("Intento de sacar más dinero del que hay");
        try {
            bancaServicio.retirar(110);
        }
        catch (IllegalArgumentException e){
            System.out.println("Importe debe ser positivo");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        catch (IllegalStateException e){
            System.out.println("Error al retirar");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        finally {
            System.out.println("Salto Controlado");
        }

        System.out.println("Intento de sacar un dinero negativo");
        try {
            bancaServicio.retirar(-10);
        }
        catch (IllegalArgumentException e){
            System.out.println("Importe debe ser positivo");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        catch (IllegalStateException e){
            System.out.println("Error al retirar");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        finally {
            System.out.println("Salto Controlado");
        }

        System.out.println("Intento de pedido con id Pedido null");
        try {
            bancaServicio.procesarPedido(null, 10);
        }
        catch (PedidoInvalidoException e){
            System.out.println("El pedido es ínválido");
            System.out.println(e.getPedidoId());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            System.out.println("Salto Controlado");
        }

        System.out.println("Intento de sacar dinero que hay suficiente");
        try {
            double dineroASacar = 10;
            bancaServicio.retirar(dineroASacar);
            System.out.println("Dinero sacado: "+ dineroASacar);
        }
        catch (IllegalArgumentException e){
            System.out.println("Importe debe ser positivo");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        catch (IllegalStateException e){
            System.out.println("Error al retirar");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        finally {
            System.out.println("Salto Controlado");
        }

        System.out.println("Saldo actual: " + bancaServicio.getSaldo());
        System.out.println("Terminación Controlada");
    }
}
