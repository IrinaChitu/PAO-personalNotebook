package models.notes;

import java.util.Calendar;

import static java.util.Objects.requireNonNull;

public class Tasks extends Notes {
    public static int id_DB = 0;
    private int id;
    private boolean done = false;
    private Calendar deadline;

    public  Tasks() {}
    public Tasks(String name, String text, Calendar deadline) {
        super(name, text);
        this.deadline = requireNonNull(deadline);
    }

    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }
    public Calendar getDeadline() {
        return deadline;
    }
    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getId_DB() {
        return ++Tasks.id_DB;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", done=" + done +
                ", deadline=" + deadline;
    }

    @Override
    public void printNote() {
        super.printNote();
        System.out.println("Done? " + done);
        System.out.println("Deadline: " + deadline.get(Calendar.DAY_OF_MONTH) + " / " + deadline.get(Calendar.MONTH) + " / " + deadline.get(Calendar.YEAR));
    }
}
