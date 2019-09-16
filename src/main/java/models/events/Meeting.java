package models.events;


// import java.time.Duration; -> https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html
//import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static java.util.Objects.requireNonNull;

public class Meeting extends Event {
    private static int id_DB=0;
    private  int id;
    private String purpose; // job, company, friend -> poate enum
    private String place;
    //private Duration duration; // Duration.ofHours(int);
    private Calendar startTime;
    private Calendar endTime;

    public Meeting(Date date, String description, String purpose, String place, Calendar startTime, Calendar endTime) {
        super(date, description);
        this.purpose = requireNonNull(purpose);
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurpose(String purpose) {
        this.purpose = requireNonNull(purpose);
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
    public String getPurpose() {
        return purpose;
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

    public static int getId_DB() {
        return ++Meeting.id_DB;
    }

    @Override
    public void printEvent() {  //throws ParseException {
        super.printEvent();
        System.out.println("Purpose: " + purpose);
        if(place != null) {
            System.out.println("Place: " + place);
        }
        if(startTime != null) {
            System.out.println("Start Time: " + startTime.get(Calendar.HOUR_OF_DAY) +":"+ startTime.get(Calendar.MINUTE));
        }
        if(endTime != null) {
            System.out.println("End Time: " + endTime.get(Calendar.HOUR_OF_DAY) +":"+ endTime.get(Calendar.MINUTE));
        }

    }

    @Override
    public String toString() {
        return "id=" + id +
                ", purpose=" + purpose +
                ", place=" + place +
                ", startTime=" + startTime +
                ", endTime=" + endTime;
    }
}



//    Calendar cal = Calendar.getInstance();
//    cal.set(Calendar.HOUR_OF_DAY,17);
//    cal.set(Calendar.MINUTE,30);
//    cal.set(Calendar.SECOND,0);
//    cal.set(Calendar.MILLISECOND,0);
//
//    Date d = cal.getTime();