package PosiblesEjercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GestionContactosSinMetodos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> contactos = cargarContactos();

        while (true) {
            System.out.println("\n-- Gestión de Contactos --");
            System.out.println("1. Agregar un nuevo contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Buscar un contacto por nombre");
            System.out.println("4. Eliminar un contacto");
            System.out.println("5. Salir del programa");
            System.out.println("Seleccione una opción:");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del contacto:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el número de teléfono");
                    String telefono = scanner.nextLine();
                    String nuevoContacto = nombre + ": " + telefono;
                    contactos.add(nuevoContacto);
                    System.out.println("Contacto agregado correctamente.");
                    break;
                case 2:
                    if (contactos.isEmpty()) {
                        System.out.println("No hay contactos para mostrar.");
                    }else {
                        System.out.println("--Todos los contacto --");
                        for (String contacto : contactos) {
                            System.out.println(contacto);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del contacto a buscar:");
                    String nombreBuscado = scanner.nextLine();
                    boolean encontrado = false;
                    for (String contacto : contactos) {
                        if (contacto.startsWith(nombreBuscado + ":")) {
                            System.out.println("Contacto encotrado: " + contacto);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún contacto con ese nombre. ");
                    }
                    break;
                case 4:
                    System.out.println("Ingres el nombre del contacto a eliminar:");
                    String nombreEliminar = scanner.nextLine();
                    Iterator<String> iterator = contactos.iterator();
                    while (iterator.hasNext()) {
                        String contacto = iterator.next();
                        if (contacto.startsWith(nombreEliminar + ":")) {
                            iterator.remove();
                            System.out.println("Contacto eliminado correctamente.");
                            break;
                        }
                    }
                    System.out.println("No se encontró ningún contacto con ese nombre.");
                    break;
                case 5:
                    guardarContacto(contactos);
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
    private static List<String> cargarContactos() {
        List<String> contactos = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("NuevosContacto.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                contactos.add(linea);
            }
            br.close();
            System.out.println("Contactos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("No se encontraron contactos exsistentes.");
        }
        return contactos;
    }
    private static void guardarContacto(List<String> contactos) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("NuevosContacto.txt"));
            for (String contacto : contactos) {
                bw.write(contacto);
                bw.newLine();
            }
            bw.close();
            System.out.println("Contactos guarados correctamente.");
        }catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }
}
