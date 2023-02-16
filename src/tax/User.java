package tax;
import java.io.*;

public class User {
    public static void main(String[] args) throws FileNotFoundException {

        String line = "";
        final String delimiter = ",";
        try
        {
            String filePath = "D:\\Java\\FJU_TA_1112Programming\\src\\tax\\data.csv";
//            FileReader fileReader = new FileReader(filePath);
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

//            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null)   //loops through every line until null found
            {
                String[] token = line.split(delimiter);    // separate every token by comma
//                System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3]);
//                System.out.println(token);
                for (int i = 0; i < token.length; i++) {
                    System.out.print(token[i]+" | ");
                }
                System.out.println("");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}