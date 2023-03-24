package dragonOfLoowater;

import java.util.Scanner;

public class DragonOfLoowater {
    static int dragon;
    static int knight;
    public static boolean scanf(){
        Scanner scan = new Scanner(System.in);
        dragon = scan.nextInt();
        knight = scan.nextInt();
        if (dragon != 0 & knight != 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        while(scanf()){
            System.out.println("hello world");
        }
    }
}
