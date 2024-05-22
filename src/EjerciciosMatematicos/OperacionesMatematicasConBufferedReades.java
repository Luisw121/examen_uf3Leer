package EjerciciosMatematicos;

import java.io.*;

public class OperacionesMatematicasConBufferedReades {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ingrese el primer número:");
            double num1 = Double.parseDouble(br.readLine());

            System.out.println("Ingrese el segundo número:");
            double num2 = Double.parseDouble(br.readLine());

            double suma = num1 + num2;
            double resta = num1 - num2;
            double multiplicacion = num1 * num2;
            double division = num1 / num2;

            BufferedWriter bw = new BufferedWriter(new FileWriter("resultados.txt"));
            bw.write("Suma: " + suma);
            bw.newLine();
            bw.write("Resta: " + resta);
            bw.newLine();
            bw.write("Multiplicación: " + multiplicacion);
            bw.newLine();
            bw.write("División: " + division);
            bw.close();

            System.out.println("Resultados guardados en el archivo 'resultados.txt'.");
        }catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
