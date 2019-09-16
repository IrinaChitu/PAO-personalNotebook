package models.events;

//import java.text.ParseException;
import java.util.Date;

import static java.util.Objects.requireNonNull;

public class Other extends Event {
    private String name;
    private String type;

    public Other() {}
    public Other(Date date, String name, String type) {
        super(date);
        this.name = requireNonNull(name);
        this.type = type;
    }
    public Other(Date date, String description, String name, String type) {
        super(date, description);
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public void printEvent() {  //throws ParseException {
        System.out.println("Name: " + name);
        super.printEvent();
        if(type != null) {
            System.out.println("Type: " + type);
        }

    }
}
