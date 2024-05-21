package PosiblesEjercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistroVentas {
    public static void main(String[] args) {
        Map<String, Double> ventasTotales = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //pedimos al usuario que ingrese los datos de venta
            System.out.println("Ingrese la venta (Producto:Cantidad-PrecioUnitario) o 'fin' para terminar:");
            System.out.println("Ejemplo: Manzanas:5-2.50");
            String entrada = scanner.nextLine();

            //verificar si el usuario quiere terminar la entrada de datos
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            //procesar la entrada del usuario
            try {
                String[] partes1 = entrada.split(":");
                String producto = partes1[0];
                String[] partes2 = partes1[1].split("-");
                int cantidad = Integer.parseInt(partes2[0]);
                double precioUnitario = Double.parseDouble(partes2[1]);

                double totalVenta = cantidad * precioUnitario;

                ventasTotales.put(producto, ventasTotales.getOrDefault(producto, 0.0) + totalVenta);
            }catch (Exception e) {
                System.out.println("Formato incorrecto. Por vafor, ingrese en el formato Producto:Cantidad-PrecioUnitario");
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("total_de_ventas.txt"));

            //escribir la cabecera
            bw.write("Producto, Total_Ventas\n");

            //escribir los datos de ventas totales
            for (Map.Entry<String, Double> entry : ventasTotales.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            //cerrar el archivo
            bw.close();
            System.out.println("Datos guardados correctamente en el archivo 'total_de_ventas.txt'");
        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        scanner.close();
    }
}
