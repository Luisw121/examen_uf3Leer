package PosiblesEjercicios;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class GenerarCalificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("calificaciones.txt"));

            System.out.println("Ingrese el número de estudiantes:");
            int numeroEstudiantes = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            for (int i = 0; i < numeroEstudiantes; i++) {
                System.out.println("Ingrese el nombre del estudiante " + (i + 1) + ":");
                String nombre = scanner.nextLine();
                int calificacion = random.nextInt(101); // Genera una calificación aleatoria entre 0 y 100
                bw.write(nombre + "," + calificacion + "\n");
            }

            bw.close();
            System.out.println("Archivo 'calificaciones.txt' generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

