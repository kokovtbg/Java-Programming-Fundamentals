package ObjectAndClasses.exercise;

import java.util.Scanner;

public class MainArticle2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String articleData = scan.nextLine();
        String[] splitData = articleData.split(", ");
        String title = splitData[0];
        String content = splitData[1];
        String author = splitData[2];

        Article2 article = new Article2(title, content, author);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();
            String commandName = command.split(": ")[0];
            String commandParameter = command.split(": ")[1];

            switch (commandName) {
                case "Edit":
                    article.edit(commandParameter);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(commandParameter);
                    break;
                case "Rename":
                    article.rename(commandParameter);
                    break;
            }
        }
        System.out.println(article);
    }
}
