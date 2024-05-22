package PosiblesEjercicios;

import java.io.*;

public class AreaRectanguloConBufferedIO {
    public static void main(String[]args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ingrese la base del rectángulo:");
            double base = Double.parseDouble(br.readLine());

            System.out.println("Ingrese la altura del rectángulo:");
            double altura = Double.parseDouble(br.readLine());

            double area = base * altura;

            BufferedWriter bw = new BufferedWriter(new FileWriter("area_rectangulo.txt"));
            bw.write("El área del resctangulo es: " + area);
            bw.close();

            System.out.println("El área del rectángulo ha sido guardada en el archivo 'area_rectangulo.txt'.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
