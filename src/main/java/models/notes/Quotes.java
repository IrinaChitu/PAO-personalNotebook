package models.notes;

public class Quotes extends Notes {
    public static int id_DB = 0;
    private int id;
    private String author;

    public Quotes() {}
    public Quotes(String text, String author) {
        super(text);
        this.author = author;
    }
    public Quotes(String name, String text, String author) {
        super(name, text);
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public static int getId_DB() {
        return ++Quotes.id_DB;
    }

    @Override
    public void printNote() {
        if(super.getName() != null) {
            System.out.println("Name: " + super.getName());
        }
        if(author != null) {
            System.out.println("Author: " + author);
        }
        System.out.println("Text: " + super.getText());
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", text=" + getText() +
                ", author=" + author;
    }
}
