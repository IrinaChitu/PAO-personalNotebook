package models.notes;

public class Thoughts extends Notes {
    private String type;

    public Thoughts() {}

    public Thoughts(String name, String text, String type) {
        super(name, text);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void printNote() {
        if(super.getName() != null) {
            System.out.println("Name: " + super.getName());
        }
        if(type != null) {
            System.out.println("Type: " + type);
        }
        System.out.println("Text: " + super.getText());
    }
}
