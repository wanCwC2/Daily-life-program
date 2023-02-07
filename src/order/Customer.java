package order;

import java.util.Scanner;
import order.rice.*;

public class Customer {
    public static void main(String[] args) {
        System.out.println("What do you want to eat today?");
        Scanner scan = new Scanner(System.in);
        Rice[] rice = {new Pork(),
                new Beef()};
        System.out.println(rice[1].price);
    }
}
