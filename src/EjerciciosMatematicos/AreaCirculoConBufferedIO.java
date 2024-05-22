package EjerciciosMatematicos;

import java.io.*;

public class AreaCirculoConBufferedIO {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Ingrese el radio del círculo:");
            double radio = Double.parseDouble(br.readLine());

            double area = Math.PI * radio * radio;

            BufferedWriter bw = new BufferedWriter(new FileWriter("area_circulo.txt"));
            bw.write("El área del círculo es: " + area);
            bw.close();

            System.out.println("El área del círculo ha sido guardada en el archivo 'area_circulo.txt'.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
