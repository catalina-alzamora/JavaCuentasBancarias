package clases;

public class Persona {
    private String nombre;
    private int edad;

    // constructores
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // getters
    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método para mostrar información
    public void despliegaInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + " años");
    }
}
