package student_package;

import java.io.*;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) throws FileNotFoundException {

        String[][] data = new String[7][9];
        int line_len = 0;

        String line = "";
        final String delimiter = ",";
        try {
            File myFile = new File("data/student_package_data.csv");
            String absolutePath = myFile.getAbsolutePath();
            FileInputStream fis = new FileInputStream(absolutePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
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

        int box_size = 0; //包裹總大小
        int numOfPackage = 0; //上門收件個人包裹數量
        int numOfStudnet = 0;
        String[][] student = new String[4][2];
        Fee fee = new Fee();

        for (int i = 1; i < data.length; i++) {

            if (data[i][0] != null) {

                if (!data[i][0].equals(data[i-1][0])){
                    student[numOfStudnet][0] = data[i][0];
                    student[numOfStudnet][1] = "0";
                    numOfPackage = 1;
                    numOfStudnet += 1;
                }

                if (data[i][4].equals("Y")) {
                    student[numOfStudnet-1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet-1][1]) + 190);
                    if (data[i][3].equals("Y")) {
                        student[numOfStudnet-1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet-1][1]) - 210);
                    }
                } else if (data[i][3].equals("Y")) {
                    if (data[i][1].equals("四號學生專用包裹")) {
                        student[numOfStudnet-1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet-1][1]) + 80);
                    } else if (data[i][1].equals("五號學生專用包裹")) {
                        student[numOfStudnet-1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet-1][1]) + 110);
                    }
                } else {
                    if (data[i][5].equals("上門收件")) {
                        switch (data[i][1]) {
                            case "四號學生專用包裹":
                                box_size = 102;
                                break;
                            case "五號學生專用包裹":
                                box_size = 110;
                                break;
                            case "學生電腦專用包裹": //大小不重要，統一資費
                                box_size = 0;
                                break;
                            default:
                                box_size = 0;
                                String str = new String(data[i][1]);
                                for (String retval : str.split("x")) {
                                    box_size += Integer.parseInt(retval);
                                }
                        }
                        student[numOfStudnet-1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet-1][1]) + fee.useSize(box_size, data[i][6], data[i][7]));

                    } else if (data[i][5].equals("親至郵局窗口")) {
                        student[numOfStudnet-1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet-1][1]) + fee.useWeight(Integer.parseInt(data[i][2]), data[i][6], data[i][7]));
                    }
                }

                if (data[i][5].equals("上門收件")){
                    if (numOfPackage < 2){
                        student[numOfStudnet-1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet-1][1]) + 20);
                        numOfPackage += 1;
                    } else if (numOfPackage == 2) {
                        numOfPackage += 1;
                    } else if (numOfPackage > 2) {
                        student[numOfStudnet - 1][1] = String.valueOf(Integer.parseInt(student[numOfStudnet - 1][1]) + 10);
                        numOfPackage += 1;
                    }
                }
            }
        }

        for (int i = 0; i < student.length; i++) {
            if (student[i][0] != null) {
                System.out.print(student[i][0] + "須支付");
                if (Integer.parseInt(student[i][1]) >= 0) {
                    System.out.print(student[i][1] + "元");
                } else if (Integer.parseInt(student[i][1]) < 0) {
                    System.out.print("0元");
                }
                System.out.println("");
            }
        }
    }
}