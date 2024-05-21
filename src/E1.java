import java.io.*;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("COmo te llamas?");
        String nombre = scanner.nextLine();
        System.out.println("Cuantos años tienes?");
        int edad = scanner.nextInt();
        System.out.println("Que temperatura hay?");
        float temp = scanner.nextFloat();
        System.out.println("Hace frio?");
        boolean frio = scanner.nextBoolean();

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("e1.txt")));
            bw.write("Te llamas " + nombre + "y tienes " + edad + " años." + "\n");
            bw.write("Hay " + temp + " grados centigrados, " + (frio ? "si":"no") + " hace frio.");
            bw.close();
        }catch (IOException e) {
            System.out.println(e + "error");
        }

    }
}
