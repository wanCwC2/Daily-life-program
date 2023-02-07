package guessNumber;

public class Check {
    public static boolean correct(int number, int prize){
        if (number > prize) {
            System.out.println("Too big!");
            return false;
        }
        else if (number < prize){
            System.out.println("Too small!");
            return false;
        }
        else{
            System.out.println("Perfect!");
            return true;
        }
    }
}
