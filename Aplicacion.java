import clases.Persona;
import clases.CuentaBancaria;

public class Aplicacion {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Pedro Pascal", 50);
        Persona persona2 = new Persona("Ana Tijoux", 48);
        Persona persona3 = new Persona("Rosalia Vila", 32);

        CuentaBancaria c1 = new CuentaBancaria(1500.0, persona1);
        CuentaBancaria c2 = new CuentaBancaria(3000.0, persona2);
        CuentaBancaria c3 = new CuentaBancaria(500.0, persona3);

        // Operaciones
        System.out.println("\nMovimientos:");
        c1.depositar(500);
        c1.retirar(200);

        c2.depositar(1000);
        c2.retirar(3500); // retiro mayor que el saldo -> mensaje de error

        c3.depositar(250);
        c3.retirar(100);

        // Mostrar saldo actual de cada cuenta
        System.out.println("\nSaldos actuales:");
        System.out.println("Cuenta " + c1.getNumeroCuenta() + ": $" + c1.getSaldo());
        System.out.println("Cuenta " + c2.getNumeroCuenta() + ": $" + c2.getSaldo());
        System.out.println("Cuenta " + c3.getNumeroCuenta() + ": $" + c3.getSaldo());

        // Imprimir información de todas las cuentas
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}
