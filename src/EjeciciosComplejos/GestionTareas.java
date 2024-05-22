package EjeciciosComplejos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tareas = new ArrayList<>();

        while (true) {
            System.out.println("Seleccione una opción");
            System.out.println("1. Agregar una nueva tarea");
            System.out.println("2. Ver todas las tareas");
            System.out.println("3. Salir y guardar las tareas");
            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                System.out.println("Ingrese el nombre de la tarea:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la despcripción de la tarea:");
                String descripcion = scanner.nextLine();
                tareas.add("Tarea: " + nombre + ", Descripción: " + descripcion);
            } else if (opcion == 2) {
                System.out.println("Lista de tareas:");
                for (String tarea : tareas) {
                    System.out.println(tarea);
                }
            } else if (opcion == 3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("tareasNuevas.txt"));
                    for (String tarea : tareas) {
                        bw.write(tarea);
                        bw.newLine();
                    }
                    bw.close();
                    System.out.println("Tareas guardadas correctamente en el archivo 'tareasNuevas.txt'.");
                }catch (IOException e) {
                    System.out.println("Error al escribir en el archivo: " + e.getMessage());
                }
                break;
            }else {
                System.out.println("Opción no válida. Por favor, itente de nuevo.");
            }
        }
    }
}
