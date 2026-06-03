package com.cursosdedesarrollo.java.ejercicios.u03;

// Ejercicio u03-2: throw + throws — CajaFuerte con excepciones checked y unchecked.
// - throw IllegalArgumentException (unchecked): para precondiciones de argumento.
// - throws EjSaldoInsuficienteException (checked): el llamador debe decidir qué hacer.
// - Cuenta intentos fallidos y bloquea tras MAX_INTENTOS.
public class EjCajaFuerte {

    private static final int MAX_INTENTOS = 3;

    private double saldo;
    private int    intentosFallidos = 0;

    public EjCajaFuerte(double saldoInicial) {
        if (saldoInicial < 0)
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        this.saldo = saldoInicial;
    }

    public double getSaldo()        { return saldo; }
    public boolean estaBloqueada()  { return intentosFallidos >= MAX_INTENTOS; }

    public void retirar(double importe) throws EjSaldoInsuficienteException {
        if (estaBloqueada())
            throw new IllegalStateException("La caja está bloqueada por demasiados intentos fallidos");
        if (importe <= 0)
            throw new IllegalArgumentException("El importe debe ser positivo");

        if (importe > saldo) {
            intentosFallidos++;
            throw new EjSaldoInsuficienteException(saldo, importe);
        }

        saldo -= importe;
        intentosFallidos = 0; // éxito reinicia el contador
    }

    public void desbloquear() { intentosFallidos = 0; }
}
