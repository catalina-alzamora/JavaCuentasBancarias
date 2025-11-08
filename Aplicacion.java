import clases.Persona;
import clases.CuentaBancaria;

public class Aplicacion {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Pedro Pascal", 50);
        Persona persona2 = new Persona("Ana Tijoux", 48);
        Persona persona3 = new Persona("Rosalia Vila", 32);

        CuentaBancaria cuenta1 = new CuentaBancaria(1500.0, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(3000.0, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(500.0, persona3);

        // Operaciones
        System.out.println("\nMovimientos:");
        cuenta1.depositar(500);
        cuenta1.retirar(200);

        cuenta2.depositar(1000);
        cuenta2.retirar(5500); // retiro mayor que el saldo -> mensaje de error

        cuenta3.depositar(250);
        cuenta3.retirar(100);

        // Mostrar saldo actual de cada cuenta
        System.out.println("\nSaldos actuales:");
        System.out.println("Cuenta " + cuenta1.getNumeroCuenta() + ": $" + cuenta1.getSaldo());
        System.out.println("Cuenta " + cuenta2.getNumeroCuenta() + ": $" + cuenta2.getSaldo());
        System.out.println("Cuenta " + cuenta3.getNumeroCuenta() + ": $" + cuenta3.getSaldo());

        // Imprimir información de todas las cuentas
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}
