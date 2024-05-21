import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Conexionservidor {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("registros.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("tiempo_conexion.txt")));
            // Mapa para almacenar el tiempo total de conexión por usuario
            Map<String, Integer> tiempoConexion = new HashMap<>();
            // Procesamiento de los registros
            String linea;
            while ((linea = br.readLine())!=null) {
                String[] datos = linea.split(",");
                String usuario = datos[1];
                int duracion = Integer.parseInt(datos[2]);

                // Si el usuario ya existe en el mapa, sumar la duración de conexión
                tiempoConexion.put(usuario, tiempoConexion.getOrDefault(usuario, 0)+ duracion);
            }
            // Escritura de los datos en el archivo de salida
            bw.write("Usuario,Tiempo_Conexion\n");
            for (Map.Entry<String, Integer> entry : tiempoConexion.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            // Cierre de los flujos
            br.close();
            bw.close();
            System.out.println("Datos guardados correctamente en el archivo \"tiempo_conexion.txt\".");

        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
