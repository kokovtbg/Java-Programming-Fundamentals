package Methods.exercise;

import java.util.Scanner;

public class CharactersInRange1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char char1 = scan.nextLine().charAt(0);
        char char2 = scan.nextLine().charAt(0);
        printSequenceBetweenChars(char1, char2);
    }

    private static void printSequenceBetweenChars(char symbol1, char symbol2) {
        //Проверка и да започваме от символа с по-малък ASCII код
        if (symbol1 < symbol2) {
            for (char i = (char) (symbol1 + 1); i < symbol2; i++) {
                System.out.print(i + " ");
            }
        } else { //symbol2 < symbol1
            for (char i = (char) (symbol2 + 1); i < symbol1; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
