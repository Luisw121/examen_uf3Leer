import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistrosLIbros {
    public static void main(String[] args) {
        // Ruta del archivo de salida
        String archivoSalida = "libros.txt";

        try {
            // Crear el archivo de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));

            // Crear un Scanner para la entrada de usuario
            Scanner scanner = new Scanner(System.in);

            // Mensaje de bienvenida
            System.out.println("--- Registro de Libros ---");

            // Inicializar la entrada
            String respuesta;

            // Leer datos de libros hasta que el usuario decida no ingresar más
            do {
                // Solicitar los datos del libro al usuario
                System.out.print("Ingrese el título del libro: ");
                String titulo = scanner.nextLine().toUpperCase();

                System.out.print("Ingrese el autor del libro: ");
                String autor = scanner.nextLine().toUpperCase();

                System.out.print("Ingrese el género del libro (Ficción/No Ficción): ");
                String genero = scanner.nextLine();

                System.out.print("Ingrese el precio del libro: ");
                double precio = Double.parseDouble(scanner.nextLine());

                // Crear el objeto Libro con los datos proporcionados
                Libro libro = new Libro(titulo, autor, genero, precio);

                // Aplicar descuento si el precio es mayor o igual a 50
                if (libro.getPrecio() >= 50) {
                    libro = aplicarDescuento(libro);
                }

                // Escribir los datos procesados en el archivo de salida
                bw.write("Título: " + libro.getTitulo() + "\n");
                bw.write("Autor: " + libro.getAutor() + "\n");
                bw.write("Género: " + libro.getGenero() + "\n");
                bw.write("Precio con Descuento: " + libro.getPrecio() + "\n");
                bw.write("--\n");

                // Preguntar al usuario si desea ingresar otro libro
                System.out.print("¿Desea ingresar otro libro? (s/n): ");
                respuesta = scanner.nextLine();
            } while (respuesta.equalsIgnoreCase("s"));

            // Cerrar el flujo de escritura
            bw.close();
            scanner.close();

            // Mostrar mensaje de éxito
            System.out.println("Datos de libros guardados correctamente en el archivo " + archivoSalida + ".");

        } catch (IOException e) {
            // Manejar excepciones de entrada/salida
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Manejar excepciones de formato de número
            System.out.println("Error: El precio debe ser un número válido.");
        }
    }

    // Método para aplicar el descuento del 10%
    public static Libro aplicarDescuento(Libro libro) {
        double precioConDescuento = libro.getPrecio() * 0.9;
        libro = new Libro(libro.getTitulo(), libro.getAutor(), libro.getGenero(), precioConDescuento);
        return libro;
    }
}
