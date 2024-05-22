package PosiblesEjercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroVentasDiarias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> ventas = new ArrayList<>();
        double ingresoTotal = 0.0;

        System.out.println("Ingrese la fecha (dd/mm/aaaa):");
        String fecha = scanner.nextLine();

        while (true) {
            System.out.println("Ingrese el nombre del producto:");
            String producto = scanner.nextLine();

            System.out.println("Ingrese la cantidad del vendida:");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el precio unitario:");
            double precio = Double.parseDouble(scanner.nextLine());

            double ingreso = cantidad * precio;
            ingresoTotal += ingreso;

            ventas.add("Fecha: " + fecha + "\nProducto: " + producto + "\nCantidad: " + cantidad + "\nPrecio Unitario: " + precio + "\nIngreso: " + ingreso + "\n--");

            System.out.println("¿Desea registrar otra venta? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                break;
            }
        }
        ventas.add("Ingreso Total del Día: " + ingresoTotal + "\n--");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ventas_diarias.txt"));
            for (String venta : ventas) {
                bw.write(venta);
                bw.newLine();
            }
            bw.close();
            System.out.println("Datos de ventas guardados correctamente en el archivo 'ventas_diarias.txt'.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
