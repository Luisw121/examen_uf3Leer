import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ventas {

    public static void main(String[] args) {
        String archivoEntrada = "ventas.txt";
        String archivoSalida = "total_ventas.txt";

        // Utilizamos LinkedHashMap para mantener el orden de inserción
        Map<String, Double> totalVentas = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Ignorar encabezados y líneas no deseadas
                if (!linea.contains(":") || !linea.contains("-")) {
                    System.err.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }

                // Dividir la línea por ":"
                String[] partes = linea.split(":");
                if (partes.length != 2) {
                    System.err.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }

                String producto = partes[0];

                // Dividir la segunda parte por "-"
                String[] cantidadPrecio = partes[1].split("-");
                if (cantidadPrecio.length != 2) {
                    System.err.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }

                try {
                    int cantidad = Integer.parseInt(cantidadPrecio[0]);
                    double precioUnitario = Double.parseDouble(cantidadPrecio[1]);

                    // Calcular el total de ventas para esta línea
                    double total = cantidad * precioUnitario;

                    // Actualizar el total de ventas para el producto
                    totalVentas.put(producto, totalVentas.getOrDefault(producto, 0.0) + total);
                } catch (NumberFormatException e) {
                    System.err.println("Número incorrecto en la línea: " + linea);
                }
            }

            System.out.println("Datos leídos correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            bw.write("Producto,Total_Ventas\n");

            for (Map.Entry<String, Double> entry : totalVentas.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            System.out.println("Datos guardados correctamente en el archivo " + archivoSalida);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}




/*
public static void main(String[] args) {
        // Ruta de los archivos de entrada y salida
        String archivoEntrada = "ventas.txt";
        String archivoSalida = "total_ventas.txt";

        try {
            // Lectura del archivo de entrada
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));

            // Mapa para almacenar el total de ventas por producto
            Map<String, Double> totalVentas = new HashMap<>();

            // Procesamiento de los registros
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(":");
                String producto = datos[0];

                // Verificar que hay dos partes en la división (producto y resto)
                if (datos.length == 2) {
                    String[] info = datos[1].split("-");
                    if (info.length == 2) {
                        int cantidad = Integer.parseInt(info[0]);
                        double precioUnitario = Double.parseDouble(info[1]);

                        // Calculamos el total de ventas por producto
                        double total = cantidad * precioUnitario;

                        // Agregamos el total de ventas al mapa
                        totalVentas.put(producto, total);
                    }
                }
            }
            br.close();

            // Escritura del archivo de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));
            bw.write("Producto,Total_Ventas\n");

            // Escribimos los datos en el archivo de salida
            for (Map.Entry<String, Double> entry : totalVentas.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            // Cierre del flujo de salida
            bw.close();
            System.out.println("Datos guardados correctamente en el archivo \"" + archivoSalida + "\".");
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo \"" + archivoEntrada + "\" no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer/escribir en el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: formato de número inválido en el archivo.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: formato de línea incorrecto en el archivo.");
        }
    }
 */