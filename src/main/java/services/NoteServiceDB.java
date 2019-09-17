package services;

import models.notes.Quotes;
import models.notes.Tasks;

import java.util.Arrays;
import java.util.List;

public class NoteServiceDB {

    private static NoteServiceDB eventInstance = new NoteServiceDB();

    public static NoteServiceDB getInstance() {
        return eventInstance;
    }

    private NoteServiceDB() {}

    public void addQuote(Quotes quote) {
        quote.setId((int)(Math.random() * ((200 - 1) + 1)) + 1);
        WriteDatabase.DatabaseWriter(Arrays.asList(quote));
    }

    public List<Quotes> readQuote(String author) {
        return ReadDatabase.DatabaseReader("Quote", author);
    }

    public void updateQuote(Quotes quote) {
        UpdateDatabase.DatabaseUpdater(quote);
    }

    public void deleteQuote(int id) {
        DeleteDatabase.DatabaseDeleter("Quote", id);
    }

    public void addTask(Tasks task) {
        task.setId((int)(Math.random() * ((200 - 1) + 1)) + 1);
        WriteDatabase.DatabaseWriter(Arrays.asList(task));
    }

    public List<Tasks> readTasks(int id) {
        return ReadDatabase.DatabaseReader("Tasks", Integer.toString(id));
    }

    public void updateTask(Tasks task) {
        UpdateDatabase.DatabaseUpdater(task);
    }

    public void deleteTask( int id) {
        DeleteDatabase.DatabaseDeleter("Tasks", id);
    }
}
