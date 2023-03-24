package dragonOfLoowater;

import java.util.Scanner;

public class DragonOfLoowater {
    static int numDragon;
    static int numKnight;
    static Scanner scan = new Scanner(System.in);
    public static boolean scanf(){
        numDragon = scan.nextInt();
        numKnight = scan.nextInt();
        if (numDragon != 0 & numKnight != 0 & numDragon < 20000 & numKnight <20000){
            return true;
        }
        return false;
    }
    public static void sort(int[] array){
        boolean change = true;
        int start = 0;
        int end = array.length;
        while(change){
            change = false;
            for (int i = start; i < array.length-1; i++) {
                if (array[i] > array[i+1]){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    change = true;
                }
            }
            end--;
            if (!change) break;
            change = false;
            for (int i = end - 1; i > 0; i--) {
                if (array[i+1] > array[i]){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    change = true;
                }
            }
            start++;
        }
    }
    public static void main(String[] args) {
        int mission = 0;
        while(scanf()){
            int[] dragon = new int[numDragon];
            int[] knight = new int[numKnight];
            int cost = 0;
            int cutOffNum = 0;
            for (int i = 0; i < numDragon; i++) dragon[i] = scan.nextInt();
            for (int i = 0; i < numKnight; i++) knight[i] = scan.nextInt();
            sort(dragon);
            sort(knight);
            for (int i = 0; i < numKnight; i++) {
                if(knight[i] >= dragon[cutOffNum]){
                    cost += knight[i];
                    cutOffNum++;
                    if (cutOffNum == numDragon) break;
                }
            }
            if (cutOffNum < numDragon) System.out.println("Mission" + mission + ": Loowater is doomed.");
            else System.out.println("Mission" + mission + ": " + cost);
        }
    }
}
