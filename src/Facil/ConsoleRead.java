package Facil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ConsoleRead {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("fileConsole.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("fileConsole2.txt"));

            String line;
            while (!(line = br.readLine()).equals("exit")) {
                bw.write(line);
            }
            bw.close();
            br.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
