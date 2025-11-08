package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private Double saldo;
    private Persona titular;
    private int numeroCuenta;
    public static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>(); //Total de cuentas creadas

    // Constructor
    public CuentaBancaria(Double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;
        this.numeroCuenta = nuevoNumeroCuenta();
        listaDeCuentasBancarias.add(this);
    }

    //Crear número de cuenta único
   private int nuevoNumeroCuenta() {
    Random rand = new Random();
    int numeroRandom;
    boolean existe;
    do {
        numeroRandom = rand.nextInt(900000) + 100000; //número aleatorio de 6 dígitos
        existe = false;
        //Evitando que se repita el número con una cuenta existente
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

    // Métodos
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Registro de movimiento en cuenta: " + numeroCuenta);
            System.out.println("Monto depositado: $" + monto);
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("Depósito inválido.");
        }
    }
     public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Registro de movimiento en cuenta: " + numeroCuenta);
            System.out.println("Monto retirado: $" + monto);
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("Retiro inválido.");
            System.out.println("-------------------------------------------");
        }
    }

    public void despliegaInformacion() {
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
        System.out.print("Titular: ");
        titular.despliegaInformacion();
    }

    public static void imprimeInformacionDeTodasLasCuentas() {
        System.out.println("\nLista de todas las cuentas");
        for (CuentaBancaria cuenta : listaDeCuentasBancarias) {
            cuenta.despliegaInformacion();
            System.out.println("-------------------------------------------");
        }
    }
}

