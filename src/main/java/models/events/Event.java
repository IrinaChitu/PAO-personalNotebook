package models.events;

//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Objects.requireNonNull;

public abstract class Event {
//    public static int id_DB = 0;
    private Date date;
    private String description;

    public Event() {}
    public Event(Date date) {
        this.date = requireNonNull(date);
    }
    public Event(Date date, String description) {
        this.description = description;
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(Date date) {
        this.date = requireNonNull(date);
    }
    public String getDescription() { return description; }
    public Date getDate() {
        return date;
    }

    public void printEvent() {  // throws ParseException {
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date formattedDate = formatter.parse(formatter.format(date));
        System.out.println("Date: " + date);
        if(description != null) {
            System.out.println("Description: " + description);
        }
    }




}
