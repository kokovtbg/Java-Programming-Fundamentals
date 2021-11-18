package ObjectAndClasses.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Article1 {
    private String title;
    private  String content;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Article1(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Article1> titles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(", ");
            String titleName = data[0];
            String content = data[1];
            String author = data[2];

            Article1 title = new Article1(titleName, content, author);
            title.setTitle(titleName);
            title.setContent(content);
            title.setAuthor(author);
            titles.add(title);
        }
        String command = scan.nextLine();
        if (command.equals("title")) {
            titles = titles.stream().sorted(Comparator.comparing(Article1::getTitle)).collect(Collectors.toList());
        }
        if (command.equals("content")) {
            titles = titles.stream().sorted(Comparator.comparing(Article1::getContent)).collect(Collectors.toList());
        }
        if (command.equals("author")) {
            titles = titles.stream().sorted(Comparator.comparing(Article1::getAuthor)).collect(Collectors.toList());
        }
        for (Article1 title : titles) {
            System.out.printf("%s - %s: %s%n", title.getTitle(), title.getContent(), title.getAuthor());
        }
    }
}
