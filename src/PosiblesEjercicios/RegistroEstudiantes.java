package PosiblesEjercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> estudiantes = new ArrayList<>();

        while (true) {
            System.out.println("Ingrese el nombre del estudiante:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la edad del estudiante:");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese la calificación del estudiante:");
            double calificación = Double.parseDouble(scanner.nextLine());

            estudiantes.add("Nombre: " + nombre + ", Edad: " + edad + ", Calificación: " + calificación);

            System.out.println("¿Desea agregar otro estudiante? (s/n):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                break;
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("estudiantesNuevos.txt"));
            for (String estudiante : estudiantes) {
                bw.write(estudiante);
                bw.newLine();
            }
            bw.close();
            System.out.println("Datos de estudiantes guardados correctamente en el archivo 'estudiantesNuevos.txt'.");
        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
