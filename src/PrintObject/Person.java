package PrintObject;

import java.util.Scanner;

public class Person {
    public static void main(String[] args) {
        System.out.println("What is your student ID?");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        Print print = new Print();
        print.print(name);
    }
}