package models.events;

// import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Academical extends Event {
    private String type;
    private String field;
    private String place;
    // private Duration duration; // Duration.ofHours(int);
    private Calendar startTime;
    private Calendar endTime;

    public Academical(Date date, String description, String type, String field, String place, Calendar startTime, Calendar endTime) {
        super(date, description);
        this.type = type;
        this.field = field;
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public String getField() {
        return field;
    }

    public String getPlace() {
        return place;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    @Override
    public void printEvent() {
        super.printEvent();
        if(type != null) {
            System.out.println("Type: " + type);
        }
        if(field != null) {
            System.out.println("Field: " + field);
        }
        if(place != null) {
            System.out.println("Place: " + place);
        }
        if(startTime != null) {
            System.out.println("Start Time: " + startTime.get(Calendar.HOUR_OF_DAY));
        }
        if(endTime != null) {
            System.out.println("End Time: " + endTime.get(Calendar.MINUTE));
        }
    }
}
