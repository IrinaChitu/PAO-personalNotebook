package models.notebook;

import models.events.*;
import models.notes.*;
import services.MyLogger;

//import java.text.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class PlanningNotebook{
    //    String ownerType;
//    List<Academical> academicalEvents;
//    List<Anniversary> anniversaries;
//    List<Meeting> meetings;
//    List<Other> others;

//    List<Quotes> quotes;
//    List<Story> stories;
//    List<Tasks> tasks;
//    List<Thoughts> thoughts;

    private List<Event> events;
    private List<Notes> notes;
    private static PlanningNotebook notebook = new PlanningNotebook();

    public static PlanningNotebook getInstance() {
        return notebook;
    }

    private PlanningNotebook() {
        events = new ArrayList<>();
        notes= new ArrayList<>();
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void addEvent(Event ev) {
        events.add(ev);
    }
    public void addNote(Notes n) {
        notes.add(n);
    }

    public void deleteNote(Notes n) {
        notes.remove(n);
    }

    public void deleteEvent(Event ev) {
        events.remove(ev);
    }

    public List<Anniversary> getAnniversaries() {
        List<Anniversary> anniversaries = new ArrayList<>();
        for(Event ev: events) {
            if(ev instanceof Anniversary) {
                anniversaries.add((Anniversary)ev);
            }
        }
        return anniversaries;
    }
    public List<Academical> getAcademicalEvents() {
        List<Academical> academicals = new ArrayList<>();
        for(Event ev: events) {
            if(ev instanceof Academical) {
                academicals.add((Academical)ev);
            }
        }
        return academicals;
    }
    public List<Meeting> getMeetings() {
        List<Meeting> meetings = new ArrayList<>();
        for(Event ev: events) {
            if(ev instanceof Meeting) {
                meetings.add((Meeting)ev);
            }
        }
        return meetings;
    }
    public List<Other> getOthers() {
        List<Other> others = new ArrayList<>();
        for(Event ev: events) {
            if(ev instanceof Other) {
                others.add((Other)ev);
            }
        }
        return others;
    }

    public List<Quotes> getQuotes() {
        List<Quotes> quotes = new ArrayList<>();
        for(Notes n: notes) {
            if(n instanceof Quotes) {
                quotes.add((Quotes)n);
            }
        }
        return quotes;
    }
    public List<Story> getStories() {
        List<Story> stories = new ArrayList<>();
        for(Notes n: notes) {
            if(n instanceof Story) {
                stories.add((Story)n);
            }
        }
        return stories;
    }

    public List<Tasks> getTasks() {
        List<Tasks> tasks = new ArrayList<>();
        for(Notes n: notes) {
            if(n instanceof Tasks) {
                tasks.add((Tasks)n);
            }
        }
        return tasks;
    }


    public List<Thoughts> getThoughts() {
        List<Thoughts> thoughts = new ArrayList<>();
        for(Notes n: notes) {
            if(n instanceof Thoughts) {
                thoughts.add((Thoughts)n);
            }
        }
        return thoughts;
    }

    public void sortNotesByName() {
        Collections.sort(notebook.notes);
    }

    public void printEvents() {  //throws ParseException {
        for(Event ev: events) {
            ev.printEvent();
        }
    }

    public void printNotes() {
        for(Notes n: notes) {
            n.printNote();
        }
    }
}
