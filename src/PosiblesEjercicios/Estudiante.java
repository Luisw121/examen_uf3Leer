package PosiblesEjercicios;

public class Estudiante {
    public String nombre;
    public int edad;
    public int nota;

    // Constructor
    public Estudiante(String nombre, int edad, int nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    // toString para imprimir los datos del estudiante
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Nota: " + nota;
    }

}
