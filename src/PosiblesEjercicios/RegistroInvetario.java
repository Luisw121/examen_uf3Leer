package PosiblesEjercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroInvetario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> productos = new ArrayList<>();

        while (true) {
            System.out.println("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la cantidad del producto:");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el precio del producto:");
            double precio = Double.parseDouble(scanner.nextLine());

            productos.add("Producto: " + nombre + ", " + cantidad + ", " + precio);

            System.out.println("¿Desea agregar otro producto? (s/n):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                break;
            }
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("intentarioNuevo.txt"));
            for (String producto : productos) {
                bw.write(producto);
                bw.newLine();
            }
            bw.close();
            System.out.println("Datos de productos guardados correctamente en el archivo 'inventarioNuevo.txt'.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
