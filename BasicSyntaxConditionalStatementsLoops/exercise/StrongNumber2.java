package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class StrongNumber2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        //Взимаме последната цифра -> % 10
        //Махаме я от числото -> / 10
        //стоп: number == 0

        int sumFact = 0;
        int startNumber = number;
        while (number != 0) {
            int lastDigit = number % 10;
            //Намираме Факториела
            int fact = 1;
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            sumFact += fact;
            number /= 10;
        }
        if (startNumber == sumFact) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
