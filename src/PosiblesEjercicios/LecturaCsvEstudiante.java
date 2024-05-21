package PosiblesEjercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LecturaCsvEstudiante {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

        try {
            // Abrir el archivo CSV para lectura
            BufferedReader br = new BufferedReader(new FileReader("estudiantes.csv"));
            String linea;

            // Leer la primera línea (cabecera) y descartarla
            linea = br.readLine();

            // Leer las siguientes líneas del archivo
            while ((linea = br.readLine()) != null) {
                // Separar la línea en partes utilizando la coma como separador
                String[] partes = linea.split(",");

                // Obtener los valores de nombre, edad y nota
                String nombre = partes[0];
                int edad = Integer.parseInt(partes[1]);
                int nota = Integer.parseInt(partes[2]);

                // Crear un objeto Estudiante y agregarlo a la lista
                Estudiante estudiante = new Estudiante(nombre, edad, nota);
                estudiantes.add(estudiante);
            }

            // Cerrar el archivo
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo 'estudiantes.csv' no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Imprimir los datos de los estudiantes
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
