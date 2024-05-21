import java.io.*;

public class E4 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("numero.data")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("listado.data")));

            int cantidadNumero = Integer.parseInt(br.readLine());
            int contador = 0;

            for (int i = 1; i <= cantidadNumero; i++) {
                bw.write(String.valueOf(i)+ " ");
                contador++;

                if (contador == 10) {
                    bw.write("\n");
                    contador = 0;
                }
            }
            br.close();
            bw.close();
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
