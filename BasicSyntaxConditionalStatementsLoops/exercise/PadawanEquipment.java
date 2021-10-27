package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double sabrePrice = Double.parseDouble(scan.nextLine());
        double robesPrice = Double.parseDouble(scan.nextLine());
        double beltsPrice = Double.parseDouble(scan.nextLine());

        double neededMoney = 0;
        if (students <= 5) {
            neededMoney = sabrePrice * Math.ceil(students * 1.1) + robesPrice * students + beltsPrice * students;
        } else {
            neededMoney = sabrePrice * Math.ceil(students * 1.1) + robesPrice * students + beltsPrice * (students - Math.floor(students / 6.0));
        }
        if (money >= neededMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", neededMoney);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", neededMoney - money);
        }
    }
}
