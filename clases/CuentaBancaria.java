package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private Double saldo;
    private Persona titular;
    private int numeroCuenta;
    public static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    // Constructor
    public CuentaBancaria(Double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;
        this.numeroCuenta = this.nuevoNumeroCuenta();
        listaDeCuentasBancarias.add(this);
    }

    //Crear numero de cuenta único
   private int nuevoNumeroCuenta() {
    Random rand = new Random();
    int numeroRandom;
    boolean existe;
    do {
        numeroRandom = rand.nextInt(900000) + 100000; // número aleatorio de 6 dígitos
        existe = false;
        //Evitando que se repita el numero con uno existente
        for (CuentaBancaria cuenta : listaDeCuentasBancarias) {
            if (cuenta.getNumeroCuenta() == numeroRandom) {
                existe = true;
                break;
            }
        }
    } while (existe); 
    return numeroRandom;
}

    //Getters 
    public double getSaldo() {
        return saldo;
    }
    public Persona getTitular() {
        return titular;
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    //Setters
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    // Métodos funcionales
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Monto depositado: $" + monto + " en la cuenta: " + numeroCuenta);
        } else {
            System.out.println("Depósito inválido.");
        }
    }
     public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Monto retirado: $" + monto + " en la cuenta " + numeroCuenta);
        } else {
            System.out.println("Retiro inválido.");
        }
    }

    public void despliegaInformacion() {
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
        System.out.print("Titular: ");
        titular.despliegaInformacion();
    }

    public static void imprimeInformacionDeTodasLasCuentas() {
        System.out.println("\n--------- Lista de todas las cuentas ----------");
        for (CuentaBancaria cuenta : listaDeCuentasBancarias) {
            cuenta.despliegaInformacion();
            System.out.println("-------------------------------------------");
        }
    }
}

