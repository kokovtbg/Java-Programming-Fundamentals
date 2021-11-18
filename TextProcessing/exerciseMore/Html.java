package TextProcessing.exerciseMore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Html {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tittle = scan.nextLine();
        String content = scan.nextLine();
        String comment = scan.nextLine();
        List<String> comments = new ArrayList<>();
        while (!comment.equals("end of comments")) {
            comments.add(comment);

            comment = scan.nextLine();
        }
        System.out.printf("<h1>%n\t%s%n</h1>%n", tittle);
        System.out.printf("<article>%n\t%s%n</article>%n", content);
        for (int i = 0; i < comments.size(); i++) {
            System.out.printf("<div>%n\t%s%n</div>%n", comments.get(i));
        }
    }
}
