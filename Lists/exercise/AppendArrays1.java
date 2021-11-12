package Lists.exercise;

import java.util.List;
import java.util.Scanner;

public class AppendArrays1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] arrays = input.split("\\|");
        for (int i = arrays.length - 1; i >= 0; i--) {
            String elements = arrays[i].trim();//Премахва празно място преди и след редицата
            if (elements.equals(" ") || elements.equals("")) {
                continue;
            }
            String[] numbers = elements.split("\\s+");
            System.out.print(String.join(" ", numbers));
            System.out.print(" ");
        }
    }
}
