package PosiblesEjercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcesarVentas {
    public static void main(String[] args) {
        Map<String, List<String>> ventasPorVendedor = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("ventas1.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("intome_ventas1.txt"));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String vendedor = partes[0];
                String producto = partes[1];
                double ventas = Double.parseDouble(partes[2]);

                //agregar venta al vendedor correspondiente
                if (!ventasPorVendedor.containsKey(vendedor)) {
                    ventasPorVendedor.put(vendedor, new ArrayList<>());
                }
                ventasPorVendedor.get(vendedor).add(producto + "," + ventas);
            }
            //escribir los vendedores y sus productos en el archivo
            for (String vendedor : ventasPorVendedor.keySet()) {
                bw.write(vendedor + ":\n");
                for (String productoVenta : ventasPorVendedor.get(vendedor)) {
                    bw.write(productoVenta + "\n");
                }
                bw.write("\n");
            }
            br.close();
            bw.close();
            System.out.println("Archivo 'informe_ventas1.txt' generado correctamente");
        }catch (FileNotFoundException e) {
            System.out.println("Error: El archivo 'ventas1.txt' no exsiste.");
        }catch (IOException e) {
            System.out.println("Error al leer/escribir en el archivo: " + e.getMessage());
        }
    }
}
