package guessNumber;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int prize = rand.nextInt(10)+1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Guess number(1-10): ");
        int number = scan.nextInt();
        Check check = new Check();
        while(!Check.correct(number, prize)){
            System.out.println("Try again(1-10): ");
            number = scan.nextInt();
        }
    }
}
