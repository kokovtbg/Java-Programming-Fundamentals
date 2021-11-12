package Methods.exercise;

        import java.util.Scanner;

public class MiddleCharacters1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        printMiddleCharacter(text);
    }

    private static void printMiddleCharacter(String text) {
        if (text.length() % 2 != 0) {
            int indexMiddleCharacter = text.length() / 2;
            System.out.println(text.charAt(indexMiddleCharacter));
        } else {
            //Първи елемент на позиция = дължината / 2 - 1
            //Втори елемент на позиция = дължината / 2
            int indexFirstMiddleCharacter = text.length() / 2 - 1;
            int indexSecondMiddleCharacter = text.length() / 2;
            System.out.printf("%c%c", text.charAt(indexFirstMiddleCharacter), text.charAt(indexSecondMiddleCharacter));
        }
    }
}
