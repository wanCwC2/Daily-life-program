package guessNumber;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int prize = rand.nextInt(10)+1;
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        while(prize != number){
            System.out.println("Not correct!");
            System.out.println("Try again: ");
            number = scan.nextInt();
        }
        System.out.println("Perfect!");
    }
}
