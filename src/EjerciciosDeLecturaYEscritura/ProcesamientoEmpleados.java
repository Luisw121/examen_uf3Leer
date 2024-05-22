package EjerciciosDeLecturaYEscritura;

import java.io.*;

public class ProcesamientoEmpleados {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("empleados.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("salarios_anuales.txt"));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                double salarioMensual = Double.parseDouble(partes[1]);
                double salarioAnual = salarioMensual * 12;
                bw.write(nombre + "," + salarioAnual + "\n");
            }
            br.close();
            bw.close();
            System.out.println("Datos de salarios anuales guardados correctamente en el archivo 'salarios_anuales.txt'.");
        }catch (FileNotFoundException e) {
            System.out.println("Error: El archivo 'empleados.txt' no exsiste.");
        }catch (IOException e) {
            System.out.println("Error al leer/escribir en el archivo: " + e.getMessage());
        }
    }
}
