package student_package;

import java.io.*;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) throws FileNotFoundException {
        
        String[][] data = new String[5][14];
        int line_len = 0;

        String line = "";
        final String delimiter = ",";
        try {
            File myFile = new File("data/student_package_data.csv");
            String absolutePath = myFile.getAbsolutePath();
            FileInputStream fis = new FileInputStream(absolutePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null)
            {
                String[] token = line.split(delimiter);
                for (int i = 0; i < token.length; i++) {
                    data[line_len][i] = token[i];
                }
                line_len += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " | ");
            }
            System.out.println("");
        }
    }
}

