package models.notes;

import static java.util.Objects.requireNonNull;

public abstract class Notes implements Comparable {
    private String name;
    private String text;

    public Notes() {}
    public Notes(String text) {
        this.text = requireNonNull(text);
    }
    public Notes(String name, String text) {
        this.name = name;
        this.text = requireNonNull(text);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void printNote() {
        if(name != null) {
            System.out.println("Name: " + name);
        }
        System.out.println("Text: " + text);
    }

    @Override
    public int compareTo(Object o) {
        Notes note = (Notes)o;
        return this.getName().compareTo(note.getName());
    }
}
