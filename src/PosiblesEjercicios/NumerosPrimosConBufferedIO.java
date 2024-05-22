package PosiblesEjercicios;

import java.io.*;

public class NumerosPrimosConBufferedIO {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ingrese un número entero positivo:");
            int numero = Integer.parseInt(br.readLine());

            boolean esPrimo = true;

            if (numero <= 1) {
                esPrimo = false;
            } else {
                for (int i = 2; i <= Math.sqrt(numero); i++) {
                    if (numero % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("numero_primo.txt"));
            if (esPrimo) {
                bw.write(numero + " es un número primo.");
            } else {
                bw.write(numero + " no es un número primo.");
            }
            bw.close();

            System.out.println("El resultado ha sido guardado en el archivo 'numero_primo.txt'.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
