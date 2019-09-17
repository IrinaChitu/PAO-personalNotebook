import models.events.Academical;
import models.events.Anniversary;
import models.notes.Quotes;
import models.notes.Story;
import services.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class WorkingWithCSV {
    public static Logger LOGGER = null;

    public static void main(String[] args) throws IOException, ParseException {
        NoteService noteService = NoteService.getInstance();
        EventService eventService = EventService.getInstance();


        LOGGER = MyLogger.getInstance();
        LOGGER.info("PROGRAM RUNNING");

        LOGGER.info("LOADING DATA FROM CSV FILES");

        LOGGER.info("START LOADING academical events FROM academical.csv");
        List<Academical> academicalList = ReadCSV.CSVReader("Academical");
        LOGGER.info("DONE LOADING academical events FROM academical.csv");

        LOGGER.info("START LOADING anniversaries FROM anniversary.csv");
        List<Anniversary> anniversaryList = ReadCSV.CSVReader("Anniversary");
        LOGGER.info("DONE LOADING anniversaries FROM anniversary.csv");

        LOGGER.info("START LOADING quotes FROM quotes.csv");
        List<Quotes> quotesList = ReadCSV.CSVReader("Quotes");
        LOGGER.info("DONE LOADING quotes FROM quotes.csv");

        LOGGER.info("START LOADING stories FROM story.csv");
        List<Story> storyList = ReadCSV.CSVReader("Story");
        LOGGER.info("DONE LOADING stories FROM story.csv");


        LOGGER.info("ADDING DATA TO CSV FILES");

        // de adaugat logger in serviciu
        Calendar dateToAdd = Calendar.getInstance();
        dateToAdd.set(1997, 11, 29);
        Anniversary nela = new Anniversary(dateToAdd.getTime(), "", "Sarah", "bar", "bautura");
        anniversaryList.add(nela);

        dateToAdd.set(1900, 9, 01);
        Anniversary mrnobody = new Anniversary(dateToAdd.getTime(), "", "nobody", "neverland", "life");
        anniversaryList.add(mrnobody);
        WriteCSV.CSVWriter(anniversaryList);



        Collections.sort(anniversaryList, (a1, a2) -> {
            return a1.getBirthdayPerson().compareTo(a2.getBirthdayPerson());
        });

        anniversaryList.stream().forEach(Anniversary::printEvent);

        LOGGER.info("PROGRAM ENDED");
    }

}
