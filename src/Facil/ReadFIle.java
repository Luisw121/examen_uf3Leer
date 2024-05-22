package Facil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFIle {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
