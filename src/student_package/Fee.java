package student_package;

import java.util.Arrays;

public class Fee {

    static int[][] cost = {{60, 68, 85}, {77, 85, 106}, {94, 102, 128}, {115, 123, 153}};
    public static int area(String delivery_address, String mailing_address) {

        String[] outer_island = {"澎湖", "金門", "馬祖", "東引", "烏坵", "綠島", "蘭嶼", "琉球"};
        String[] taipei_keelung = {"台北市", "新北市", "基隆市"};

        // 同縣市
        if (delivery_address == mailing_address){
            return 0;
        }

        //北北基地區
        if (Arrays.asList(taipei_keelung).contains(delivery_address)){
            if (Arrays.asList(taipei_keelung).contains(mailing_address)){
                return 0;
            }
        }

        //本或外島寄送
        if (Arrays.asList(outer_island).contains(delivery_address)){
            if (Arrays.asList(outer_island).contains(mailing_address)){
                return 0;
            } else{
                return 2;
            }
        } else {
            if (Arrays.asList(outer_island).contains(mailing_address)){
                return 2;
            } else{
                return 1;
            }
        }
    }

    public static int useSize(int size, String delivery_address, String mailing_address){
        int address = area(delivery_address, mailing_address);;
        if (size <= 60){
            return cost[0][address];
        } else if (size > 60 && size <= 90){
            return cost[1][address];
        } else if (size > 90 && size <= 120){
            return cost[2][address];
        } else {
            return cost[3][address];
        }
    }

    public static int useWeight(int weight, String delivery_address, String mailing_address){
        int address = area(delivery_address, mailing_address);;
        if (weight <= 5){
            return cost[0][address];
        } else if (weight > 5 && weight <= 10){
            return cost[1][address];
        } else if (weight > 10 && weight <= 15){
            return cost[2][address];
        } else {
            return cost[3][address];
        }
    }

}
