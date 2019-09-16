import gui.Interfata_JFrame;
import models.events.Anniversary;
// import notebook.PlanningNotebook;
import models.events.Meeting;
import models.notes.Quotes;
import models.notes.Story;
import models.notes.Tasks;
import services.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class MainClass {

    public static Logger LOGGER = null;

    public static void main(String[] args) throws IOException, ParseException {
        NoteService noteService = NoteService.getInstance();
        EventService eventService = EventService.getInstance();
//            // LOGGER
//        LOGGER = MyLogger.getInstance();
//        LOGGER.info("PROGRAM RUNNING");
//
//            // INCARCA DATELE DIN CSV
//        System.out.println("BIRTHDAY PPL");
//        LOGGER.info("LOADING ANNIVERSARIES FROM anniversary.csv");
//        List<Anniversary> anniversaryList = ReadCSV.CSVReader("Anniversary");
//        for(Anniversary anniversary: anniversaryList) {
//            anniversary.printEvent();
//        }
//        System.out.println("MEETINGS");
//        LOGGER.info("LOADING MEETINGS FROM meeting.csv");
//        List<Meeting> meetingsList = ReadCSV.CSVReader("Meeting");
//        for(Meeting meeting: meetingsList) {
//            meeting.printEvent();
//        }
//        System.out.println("QUOTES");
//        LOGGER.info("LOADING QUOTES FROM quotes.csv");
//        List<Quotes> quotesList = ReadCSV.CSVReader("Quotes");
//        for(Quotes quotee: quotesList) {
//            quotee.printNote();
//        }
//        System.out.println("TASKS");
//        LOGGER.info("LOADING TASKS FROM tasks.csv");
//        List<Tasks> tasksList = ReadCSV.CSVReader("Tasks");
//        for(Tasks taskk: tasksList) {
//            taskk.printNote();
//        }
//
//            // CREATE NOTES
//        Quotes quote = new Quotes("Speranta moare ultima", "Student");
//        LOGGER.info("CREATED QUOTE");
//        Story story = new Story("Capra vecinului", "A fost calcata de un bolovan in cadere libera", "Langa nuc");
//        LOGGER.info("CREATED STORY");
//        Tasks task = new Tasks("PAO", "Proiect - Etapa I", Calendar.getInstance());
//        LOGGER.info("CREATED TASK");
//            // ADD NOTES IN NOTESERVICE
//        noteService.addNote(quote);
//        LOGGER.info("ADDED QUOTE");
//        noteService.addNote(story);
//        LOGGER.info("ADDED STORY");
//        noteService.addNote(task);
//        LOGGER.info("ADDED TASK");
//
//        // CREATE ANNIVERSARIES
//        Calendar date = Calendar.getInstance();
//        date.set(1999, 4, 22);
//        Anniversary firstPrson = new Anniversary(date.getTime(), "Teo");
//        LOGGER.info("CREATED ANNIVERSARY");
//        date.set(1998, 10, 20);
//        Anniversary secondPrson = new Anniversary(date.getTime(), "Sarah");
//        LOGGER.info("CREATED ANNIVERSARY");
//            // CREATE MEETING
//        Calendar start = Calendar.getInstance();
//        start.set(Calendar.HOUR_OF_DAY,17);
//        start.set(Calendar.MINUTE,30);
//        start.set(Calendar.SECOND,0);
//        start.set(Calendar.MILLISECOND,0);
//        Calendar end = Calendar.getInstance();
//        end.set(Calendar.HOUR_OF_DAY,19);
//        end.set(Calendar.MINUTE,45);
//        end.set(Calendar.SECOND,0);
//        end.set(Calendar.MILLISECOND,0);
//        date.set(2019, 4, 8);
//        Meeting asmi = new Meeting(date.getTime(), "marti", "studenti", "FMI", start, end);
//        LOGGER.info("CREATED MEETING");
//            // ADD EVENTS IN EVENTSERVICE
//        eventService.addEvent(firstPrson);
//        LOGGER.info("ADDED ANNIVERSARY");
//        eventService.addEvent(secondPrson);
//        LOGGER.info("ADDED ANNIVERSARY");
//        eventService.addEvent(asmi);
//        LOGGER.info("ADDED MEETING");
//
//        LOGGER.info("PROGRAM ENDED");





        // in baza de date

        List<Anniversary> aniversari = new ArrayList();

        Calendar dateTemp = Calendar.getInstance();
        dateTemp.set(1999, 4, 22);
        Anniversary teo = new Anniversary(dateTemp.getTime(), "", "Teo", "acasa", "mancare");
        teo.setId(eventService.getId("Anniversary"));

        dateTemp.set(1998, 10, 20);
        Anniversary irina = new Anniversary(dateTemp.getTime(), "", "Irina", "terasa", "dulciuri");
        irina.setId(eventService.getId("Anniversary"));

        dateTemp.set(1997, 11, 29);
        Anniversary sarah = new Anniversary(dateTemp.getTime(), "", "Sarah", "bar", "bautura");
        sarah.setId(eventService.getId("Anniversary"));

        dateTemp.set(1900, 9, 01);
        Anniversary tobedeleted = new Anniversary(dateTemp.getTime(), "", "nobody", "neverland", "life");
        sarah.setId(eventService.getId("Anniversary"));

        aniversari.add(teo);
        aniversari.add(irina);
        aniversari.add(sarah);
        aniversari.add(tobedeleted);

        eventService.addEvent(teo);
        eventService.addEvent(irina);
        eventService.addEvent(sarah);
        eventService.addEvent(tobedeleted);


        Quotes quote1 = new Quotes("citat1", "Furtuna spala", "student");
        quote1.setId(noteService.getId("Quotes"));
        Quotes quote2 = new Quotes("citat2", "Afara ploua", "copil");
        quote2.setId(noteService.getId("Quotes"));
        Quotes quote3 = new Quotes("citat3", "Noapte alba", "student");
        quote3.setId(noteService.getId("Quotes"));
        Quotes quote4 = new Quotes("citat4", "Merge", "student");
        quote4.setId(noteService.getId("Quotes"));

        noteService.addNote(quote1);
        noteService.addNote(quote2);
        noteService.addNote(quote3);
        noteService.addNote(quote4);

        Tasks task1 = new Tasks("PAO", "Proiect - Etapa I", Calendar.getInstance());
        task1.setId(noteService.getId("Tasks"));
        Tasks task2 = new Tasks("PAO", "Proiect - Etapa II", Calendar.getInstance());
        task2.setId(noteService.getId("Tasks"));
        Tasks task3 = new Tasks("PAO", "Proiect - Etapa II", Calendar.getInstance());
        task3.setId(noteService.getId("Tasks"));
        Tasks task4 = new Tasks("Retele", "Tema III", Calendar.getInstance());
        task4.setId(noteService.getId("Tasks"));

        noteService.addNote(task1);
        noteService.addNote(task2);
        noteService.addNote(task3);
        noteService.addNote(task4);

         WriteDatabase.DatabaseWriter(aniversari);
        WriteDatabase.DatabaseWriter(noteService.getQuotes());
        WriteDatabase.DatabaseWriter(noteService.getTasks());

        ArrayList<Anniversary> anniversaryTemp = eventService.findBirthdayPersonByName("Sarah");
        Anniversary anTemp = anniversaryTemp.get(0);
        anTemp.setGift("merdenea");
        // UpdateDatabase.DatabaseUpdater(anTemp);

        List<Anniversary> selected = ReadDatabase.DatabaseReader("Anniversary", "Irina");
        for(Anniversary a: selected) {
            a.printEvent();
        }

        // DeleteDatabase.DatabaseDeleter("Anniversary", tobedeleted.getId());

         Interfata_JFrame jf = new Interfata_JFrame();
//        System.out.println(eventService.objectToString(aniversari));
        System.out.println(eventService.objectToString(eventService.findBirthdayPersonByName("Irina")));

        String dt = "20/10/1998";
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
//        System.out.println(date);
//        System.out.println(eventService.objectToString(eventService.findByDate(date)));
    }
}