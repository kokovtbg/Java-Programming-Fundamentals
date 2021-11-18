package TextProcessing.lab;

import java.util.Date;

public class Prob {
    public static void main(String[] args) {
        System.out.println(new Date());
        String string = "";
        for (int i = 0; i < 1000000; i++) {
            string += "a";
        }
        System.out.println(new Date());
    }
}
