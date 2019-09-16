package services;

import models.notebook.PlanningNotebook;
import models.notes.*;

import java.util.Calendar;
import java.util.List;

public class NoteService {
    private PlanningNotebook planningNotebook = PlanningNotebook.getInstance();

    private static NoteService noteInstance = new NoteService();

    public static NoteService getInstance() {
        return noteInstance;
    }

    private NoteService() {}


    public void addNote(Notes note) {
        planningNotebook.addNote(note);
    }
    public void removeNote(Notes note) {
        planningNotebook.deleteNote(note);
    }

    public void printQuotes() {
        List<Quotes> quotes = planningNotebook.getQuotes();
        for(Quotes q: quotes) {
            q.printNote();
        }
    }
    public void printStories() {
        List<Story> stories = planningNotebook.getStories();
        for(Story s: stories) {
            s.printNote();
        }
    }
    public void printTasks() {
        List<Tasks> tasks = planningNotebook.getTasks();
        for(Tasks t: tasks) {
            t.printNote();
        }
    }
    public void printThoughts() {
        List<Thoughts> thoughts = planningNotebook.getThoughts();
        for(Thoughts t: thoughts) {
            t.printNote();
        }
    }


    public List<Quotes> getQuotes() {
        return planningNotebook.getQuotes();
    }

    public List<Tasks> getTasks() {
        return planningNotebook.getTasks();
    }

    public boolean containsNote(Notes note) {
        List<Notes> notes = planningNotebook.getNotes();
        for(Notes n: notes) {
            if(n == note) {
                return true;
            }
        }
        return false;
    }

    public List<Tasks> findTasksToDo() {
        List<Tasks> toDo = planningNotebook.getTasks();
        for(Tasks t: toDo) {
            if(t.isDone() == true) {
                toDo.remove(t);
            }
        }
        return toDo;
    }

    public static int getId(String eventType) {
        switch (eventType) {
            case "Quotes":
                return Quotes.getId_DB();
            case "Tasks":
                return Tasks.getId_DB();
            default:
                return -1;
        }
    }


    public <T>String objectToString(List<T> objects) {
        String stringOfObjects = null;
        switch( objects.get(0).getClass().getSimpleName() ) {
            case "Quotes":
                for( T object: objects) {
                    Quotes quote = Quotes.class.cast(object);
                    stringOfObjects += quote.toString() +'\n';
                }
                return stringOfObjects;

//            case "Meeting":
//                for( T object: objects) {
//                    Meeting meeting = Meeting.class.cast(object);
//                    stringOfObjects += meeting.toString() +'\n';
//                }
//                return stringOfObjects;
        }
        return stringOfObjects;
    }
}

