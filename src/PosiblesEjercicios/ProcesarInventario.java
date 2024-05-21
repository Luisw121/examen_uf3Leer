package PosiblesEjercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcesarInventario {
    public static void main(String[] args) {
        List<String> menorA5 = new ArrayList<>();
        List<String> mayorIgualA5 = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("inventario.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("informe_invetario.txt"));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String producto = partes[0];
                int cantidad = Integer.parseInt(partes[1]);

                if (cantidad < 5) {
                    menorA5.add(producto + "," + cantidad);
                }else {
                    mayorIgualA5.add(producto + "," + cantidad);
                }
            }
            bw.write("Prodctos con cantidad menor a 5:\n");
            for (String item : menorA5) {
                bw.write(item + "\n");
            }

            bw.write("\nProductos con cantidad mayor o igual a 5:\n");
            for (String item : mayorIgualA5) {
                bw.write(item + "\n");
            }
            br.close();
            bw.close();
            System.out.println("Archivo 'informe_inventario.txt' generado correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo 'inventario.txt' no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer/escribir en el archivo: " + e.getMessage());
        }
    }
}
