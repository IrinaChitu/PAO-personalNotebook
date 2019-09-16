package services;

import models.events.*;
import models.notebook.PlanningNotebook;

//import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventService {
    private PlanningNotebook planningNotebook = PlanningNotebook.getInstance();
    private static EventService eventInstance = new EventService();

    public static EventService getInstance() {
        return eventInstance;
    }

    private EventService() {}

    public void addAcademical(Date date, String description, String type, String field, String place, int startTime, int endTime) {
        Event ev = new Academical(date, description, type, field, place, startTime, endTime);
        planningNotebook.addEvent(ev);
    }
    public void addEvent(Event event) {
        planningNotebook.addEvent(event);
    }
    public void removeEvent(Event event) {
        planningNotebook.deleteEvent(event);
    }

    public void printAcademicalEvents() {
        List<Academical> academicalEvents = planningNotebook.getAcademicalEvents();
        for(Academical a:academicalEvents) {
            a.printEvent();
        }
    }
    public void printAnniversaries() {  //throws ParseException {
        List<Anniversary> anniversaries = planningNotebook.getAnniversaries();
        for(Anniversary a:anniversaries) {
            a.printEvent();
        }
    }

    public List<Anniversary> getAnniversaries() {
        return planningNotebook.getAnniversaries();
    }

    public List<Meeting> getMeetings() {
        return planningNotebook.getMeetings();
    }


    public void printMeetings() {  //throws ParseException {
        List<Meeting> meetings = planningNotebook.getMeetings();
        for(Meeting m:meetings) {
            m.printEvent();
        }
    }
    public void printOthers() {  //throws ParseException {
        List<Other> others = planningNotebook.getOthers();
        for(Other o:others) {
            o.printEvent();
        }
    }

    public boolean containsEvent(Event event) {
        List<Event> events = planningNotebook.getEvents();
        for(Event ev: events) {
            if(ev == event) { //a.eguals(b);
                return true;
            }
        }
        return false;
    }

    public List<Event> findByDate(Date date) {
        List<Event> eventOnDay = new ArrayList<>();
        List<Event> aux = planningNotebook.getEvents();
        for(Event ev: aux) {
            if(ev.getDate() == date) {
                eventOnDay.add(ev);
            }
        }
        return eventOnDay;
    }

    public Date findBirthdayByName(String name) {
        List<Anniversary> birthdays = planningNotebook.getAnniversaries();
        for(Anniversary bd: birthdays) {
            if(bd.getBirthdayPerson().equals(name)) {
                return bd.getDate();
            }
        }
        return null;
    }


    public ArrayList<Anniversary> findBirthdayPersonByName(String name) {
        ArrayList<Anniversary> birthday = new ArrayList<>();
        List<Anniversary> aux = planningNotebook.getAnniversaries();
        for(Anniversary a: aux) {
            if(a.getBirthdayPerson().equals(name)) {
                birthday.add(a);
            }
        }
        return birthday;
    }

    public <T>String objectToString(List<T> objects) {
        String stringOfObjects = null;
        switch( objects.get(0).getClass().getSimpleName() ) {
            case "Anniversary":
                for( T object: objects) {
                    Anniversary anniversary = Anniversary.class.cast(object);
                    stringOfObjects += anniversary.toString() +'\n';
                }
                return stringOfObjects;

            case "Meeting":
                for( T object: objects) {
                    Meeting meeting = Meeting.class.cast(object);
                    stringOfObjects += meeting.toString() +'\n';
                }
                return stringOfObjects;
        }
        return stringOfObjects;
    }

    public static int getId(String eventType) {
        switch (eventType) {
            case "Anniversary":
                return Anniversary.getId_DB();
            case "Meeting":
                return Meeting.getId_DB();
            default:
                return -1;
        }
    }

}
