import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaCsv {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("persona.txt")));
            String line;
            br.readLine();

            while ((line = br.readLine()) !=null) {
                String datos[] = line.split(",");
                // Creamos un objeto Persona con los datos de la línea
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String ciudad = datos[2];

                Persona persona = new Persona(nombre, edad, ciudad);

                personas.add(persona);
            }
            br.close();
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
