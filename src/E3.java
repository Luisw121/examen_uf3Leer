import java.io.*;

public class E3 {
    public static void main(String[] args) {


        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("cactus.data")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("salida.data")));

            String line = "";
            while ((line = br.readLine())!= null) {
                String parts[] = line.split(":");
                if (parts[3].equals("true")){
                    bw.write(line + "\n");
                }
            }
            br.close();
            bw.close();
        }catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
