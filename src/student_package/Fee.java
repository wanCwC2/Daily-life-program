package student_package;

import java.util.Arrays;

public class Fee {
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
}
