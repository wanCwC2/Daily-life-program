package dragonOfLoowater;

import java.util.Scanner;

public class DragonOfLoowater {
    static int numDragon;
    static int numKnight;
    static Scanner scan = new Scanner(System.in);
    public static boolean scanf(){ // 判斷結束旗幟
        numDragon = scan.nextInt();
        numKnight = scan.nextInt();
        if (numDragon == 0 & numKnight == 0){
            return false;
        }
        return true;
    }
    public static void sort(int[] array){
        boolean change = true;
        int start = 0;
        int end = array.length;
        while(change){
            change = false;
            for (int i = start; i < end-1; i++) {
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
            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i+1]){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    change = true;
                }
            }
            start++;
            if(start == end) break;
        }
    }
    public static void main(String[] args) {
        int mission = 1; // 任務數量
        while(scanf()){
            int cost = 0;
            int cutOffNum = 0;
            if((numDragon != 0 & numKnight != 0) & (numDragon <= numKnight)) {
                int[] dragon = new int[numDragon];
                int[] knight = new int[numKnight];
                for (int i = 0; i < numDragon; i++) dragon[i] = scan.nextInt();
                for (int i = 0; i < numKnight; i++) knight[i] = scan.nextInt();
                // 將龍頭大小及騎士能力值，由小到大排列
                sort(dragon);
                sort(knight);
                // 計算花費
                for (int i = 0; i < numKnight; i++) {
                    if (knight[i] >= dragon[cutOffNum]) {
                        cost += knight[i];
                        cutOffNum++;
                        if (cutOffNum == numDragon) break;
                    }
                }
            }
            // 輸出結果
            if (cutOffNum < numDragon) System.out.println("Mission" + mission + ": Loowater is doomed!");
            else if (numDragon == 0) System.out.println("Mission" + mission + ": Peace!");
            else System.out.println("Mission" + mission + ": " + cost);
            mission++;
        }
    }
}
