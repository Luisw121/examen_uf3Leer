package PosiblesEjercicios;

import java.io.*;

public class ProcesamientoNotas {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("notas.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("promedios.txt"));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                double sumaNotas = 0;
                int numeroNotas = partes.length -1;

                //sumar todas las notas
                for (int i = 1; i <= numeroNotas; i++) {
                    sumaNotas += Double.parseDouble(partes[i]);
                }

                //calcular el promedio
                double promedio = sumaNotas / numeroNotas;

                bw.write(nombre + "," + promedio + "\n");
            }
            br.close();
            bw.close();
            System.out.println("Datos de promedios guardos correctamente en el archivo 'promedios.txt'.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo 'notas.txt' no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer/escribir en el archivo: " + e.getMessage());
        }
    }
}
