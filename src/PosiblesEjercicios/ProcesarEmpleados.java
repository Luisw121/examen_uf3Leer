package PosiblesEjercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcesarEmpleados {
    public static void main(String[] args) {
        Map<String, List<String>> departamentos = new HashMap<>();
        Map<String, Integer> totalSalarios = new HashMap<>();
        List<String> altosSalarios = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("empleados22.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("informe_empleado.txt"));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                String departamento = partes[1];
                int salario = Integer.parseInt(partes[2]);

                //agregar empleado al departamento correspondiente
                if (!departamentos.containsKey(departamento)) {
                    departamentos.put(departamento, new ArrayList<>());
                    totalSalarios.put(departamento, 0);
                }
                departamentos.get(departamento).add(nombre + "," + salario);
                totalSalarios.put(departamento, totalSalarios.get(departamento) + salario);

                if (salario > 3000) {
                    altosSalarios.add(nombre + "," + salario);
                }
            }
            bw.write("Departamentos:\n");
            for (String depto : departamentos.keySet()) {
                bw.write(depto + ":\n");
                for (String empleado : departamentos.get(depto)) {
                    bw.write(empleado + "\n");
                }
                bw.write("Total Salario: " + totalSalarios.get(depto) + "\n\n");
            }

            //escribir los empleados con salario mayor a 3000
            bw.write("Empleados con salario mayor a 3000:\n");
            for (String empleado : altosSalarios) {
                bw.write(empleado + "\n");
            }
            br.close();
            bw.close();
            System.out.println("Archivo 'inromes_empleados.txt' generado correctamente");
        }catch (FileNotFoundException e) {
            System.out.println("Error : El archivo 'empleados.txt' no exsiste");
        }catch (IOException e) {
            System.out.println("Error al leer/escribir en el archivo: " + e.getMessage());
        }
    }
}
