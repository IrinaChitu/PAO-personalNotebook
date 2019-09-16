package models.events;

// import java.time.Duration;
import java.util.Date;

public class Academical extends Event {
    private String type;
    private String field;
    private String place;
    // private Duration duration; // Duration.ofHours(int);
    private int startTime;
    private int endTime;

    public Academical() {
        super();
    }

    public Academical(Date date, String description, String type, String field, String place) {
        super(date, description);
        this.type = type;
        this.field = field;
        this.place = place;
        this.startTime = 0;
        this.endTime = 0;
    }

    public Academical(Date date, String description, String type, String field, String place, int startTime, int endTime) {
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

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Integer endTime) {
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

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
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
        if(startTime != 0) {
            System.out.println("Start Time: " + startTime);
        }
        if(endTime != 0) {
            System.out.println("End Time: " + endTime);
        }
    }
}
