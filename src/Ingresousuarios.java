import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ingresousuarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("persona.txt")));
            boolean agregarPersona = true;
            while (agregarPersona) {
                System.out.print("Ingresa el nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingresa la edad: ");
                int edad;
                while (true) {
                    try {
                        edad = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: La edad debe ser un número entero.");
                        System.out.print("Ingresa la edad: ");
                    }
                }
                System.out.print("Ingresa la ciudad: ");
                String ciudad = scanner.nextLine();

                bw.write(nombre + "," + edad + "," + ciudad);
                bw.newLine();

                System.out.print("¿Deseas agregar otra persona? (s/n): ");
                String respuesta = scanner.nextLine();
                agregarPersona = respuesta.equalsIgnoreCase("s");
            }

            bw.close();
        }catch (IOException e) {
            System.out.println(e + "error");
        }

    }
}
