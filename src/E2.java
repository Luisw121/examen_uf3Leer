import java.io.*;
import java.util.ArrayList;

public class E2 {
    public static void main(String[] args) {
        ArrayList<Movilidad> movilidades = new ArrayList<Movilidad>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("movilidades.data")));
            String line = "";
            String secondLine = "";
            while ((line = br.readLine()) != null) {

                //primera linea id:nombre
                String[] idNombre = line.split(":");
                secondLine = br.readLine();

                String[] paisDias = secondLine.split(":");

                Movilidad m = new Movilidad(Integer.parseInt(idNombre[0]), idNombre[1],
                        paisDias[0], Integer.parseInt(paisDias[1]));

                movilidades.add(m);
            }

        }catch (IOException e) {
            System.out.println(e + " error");
        }
        for (Movilidad m : movilidades) {
            System.out.println(m);
        }
    }
}
