package Facil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFile {
    public static void main(String[] args) {
        String[] list = {"one", "two", "three", "fo"};
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("filewrite.txt"));

            for (String s : list) {
                bw.write(s + "\n");
            }
            bw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
