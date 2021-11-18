package ObjectAndClasses.exercise;

public class Article2 {
    //Полета
    private String title;
    private String content;
    private String author;
    //Методи - функционалности

    //Конструктор
    public Article2(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //сменя content
    public void edit(String newContent) {
        this.content = newContent;
    }

    //сменя автора
    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    //сменя заглавието
    public void rename(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }
}
