import models.events.Academical;
import models.events.Anniversary;
// import notebook.PlanningNotebook;
import models.events.Meeting;
import models.notes.Notes;
import models.notes.Quotes;
import models.notes.Story;
import models.notes.Tasks;
import services.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Logger;

public class OperationsClass {

        public static Logger LOGGER = null;

        public static void main(String[] args) throws IOException, ParseException {


            // CREATE NOTES
            Quotes quote = new Quotes("Speranta moare ultima", "Student");
            Story story = new Story("Capra vecinului", "A fost calcata de un bolovan in cadere libera", "Langa nuc");
            Tasks task = new Tasks("PAO", "Proiect - Etapa I", Calendar.getInstance());

            // ADD NOTES IN NOTESERVICE
            NoteService noteService = NoteService.getInstance();
            noteService.addNote(quote);
            noteService.addNote(story);
            noteService.addNote(task);

            List<Tasks> toDo = noteService.findTasksToDo();
            for(Tasks remainingTask: toDo) {
                remainingTask.printNote();
            }

            // ADD NOTES IN EVENTSERVICE
            EventService eventService = EventService.getInstance();

            // CREATE ANNIVERSARY
            Calendar date = Calendar.getInstance();
            date.set(1999, 4, 22);
            Anniversary luzar = new Anniversary(date.getTime(), "Teo");

            date.set(1998, 10, 20);
            System.out.println("WATCH OUT");
            System.out.println(date.getTime());
            System.out.println(date.get(Calendar.DAY_OF_MONTH));
            Anniversary sarah = new Anniversary(date.getTime(), "Sarah");
            eventService.addEvent(luzar);
            eventService.addEvent(sarah);
            System.out.println(eventService.findBirthdayByName("Sarah"));

            System.out.println(eventService.containsEvent(sarah));


            Set<Anniversary> birthdays = new HashSet<>();
            birthdays.add(sarah);
            birthdays.add(sarah);
            birthdays.add(luzar);


            // CSV

            Calendar start = Calendar.getInstance();
            start.set(Calendar.HOUR_OF_DAY,17);
            start.set(Calendar.MINUTE,30);
            start.set(Calendar.SECOND,0);
            start.set(Calendar.MILLISECOND,0);
            System.out.println(start.get(Calendar.MINUTE));
            Calendar end = Calendar.getInstance();
            end.set(Calendar.HOUR_OF_DAY,19);
            end.set(Calendar.MINUTE,45);
            end.set(Calendar.SECOND,0);
            end.set(Calendar.MILLISECOND,0);
            date.set(2019, 4, 8);
            Meeting asmi = new Meeting(date.getTime(), "marti", "studenti", "FMI", start, end);
            eventService.addEvent(asmi);
            asmi.printEvent();

            //WriteCSV.CSVWriter(Arrays.asList(asmi));
            ReadCSV.CSVReader("Meeting");

            // LOGGER
            LOGGER = MyLogger.getInstance();
            LOGGER.info("PROGRAM RUNNING");

            // INCARCA DATELE DIN CSV
            System.out.println("BIRTHDAY PPL");
            LOGGER.info("LOADING ANNIVERSARIES FROM anniversary.csv");
            List<Anniversary> anniversaryList= ReadCSV.CSVReader("Anniversary");
            for(Anniversary anniversary: anniversaryList) {
                anniversary.printEvent();
            }

            System.out.println("MEETINGS");
            LOGGER.info("LOADING MEETINGS FROM meeting.csv");
            List<Meeting> meetingsList = ReadCSV.CSVReader("Meeting");
            for(Meeting meeting: meetingsList) {
                meeting.printEvent();
            }

            System.out.println("QUOTES");
            LOGGER.info("LOADING QUOTES FROM quotes.csv");
            List<Quotes> quotesList = ReadCSV.CSVReader("Quotes");
            for(Quotes quotee: quotesList) {
                quotee.printNote();
            }

            LOGGER.info("PROGRAM ENDED");


        }

}
