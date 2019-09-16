package services;

//public interface WriteCSV {
//}

import models.events.Academical;
import models.events.Anniversary;
import models.events.Meeting;
import models.notes.Quotes;
import models.notes.Story;
import models.notes.Tasks;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class WriteCSV {

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static <T> void CSVWriter(List<T> listOfObjects) throws IOException {

        switch( listOfObjects.get(0).getClass().getSimpleName() ) {
            case "Anniversary":
                try (
                        BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src/main/resources/anniversary.csv"));

                        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                                .withHeader("Date", "Description", "BirthdayPerson", "PartyPlace", "Gift"));

                ) {
                    for( T object: listOfObjects) {
                        Anniversary anniversary = Anniversary.class.cast(object);
                        csvPrinter.printRecord(dateToString(anniversary.getDate()), anniversary.getDescription(),
                                anniversary.getBirthdayPerson(), anniversary.getPartyPlace(), anniversary.getGift());
                    }
                    csvPrinter.flush();
                }
                break;

            case "Academical":
                try (
                        BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src/main/resources/academical.csv"));

                        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                                .withHeader("Date", "Description", "Type", "Field", "Place", "StartTime", "EndTime"));

                ) {
                    for( T object: listOfObjects) {
                        Academical academical = Academical.class.cast(object);
                        csvPrinter.printRecord(dateToString(academical.getDate()), academical.getDescription(),
                                academical.getField(), academical.getPlace(), academical.getStartTime(), academical.getEndTime());
                    }
                    csvPrinter.flush();
                }
                break;

            case "Meeting":
                try (
                        BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src/main/resources/meeting.csv"));

                        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                                .withHeader("Date", "Description", "Purpose", "Place", "StartTime", "EndTime"));

                ) {
                    for( T object: listOfObjects) {
                        Meeting meeting = Meeting.class.cast(object);
                        String startTime = Integer.toString(meeting.getStartTime().get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(meeting.getStartTime().get(Calendar.MINUTE));
                        String endTime = meeting.getEndTime().get(Calendar.HOUR_OF_DAY) + ":" + meeting.getEndTime().get(Calendar.MINUTE);
                        csvPrinter.printRecord(dateToString(meeting.getDate()), meeting.getDescription(),
                                meeting.getPurpose(), meeting.getPlace(), startTime, endTime);
                    }
                    csvPrinter.flush();
                }
                break;

            case "Quotes":
                try (
                        BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src/main/resources/quotes.csv"));

                        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                                .withHeader("Name", "Text", "Author"));

                ) {
                    for( T object: listOfObjects) {
                        Quotes quote = Quotes.class.cast(object);
                        csvPrinter.printRecord(quote.getName(), quote.getText(), quote.getAuthor());
                    }
                    csvPrinter.flush();
                }
                break;

            case "Story":
                try (
                        BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src/main/resources/story.csv"));

                        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                                .withHeader("Name", "Text", "Place"));

                ) {
                    for( T object: listOfObjects) {
                        Story story = Story.class.cast(object);
                        csvPrinter.printRecord(story.getName(), story.getText(), story.getPlace(), story.getPeopleInvolved().toString());
                    }
                    csvPrinter.flush();
                }
                break;

            case "Tasks":
                try (
                        BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src/main/resources/tasks.csv"));

                        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                                .withHeader("Name", "Text", "Done", "Deadline"));
                ) {
                    for( T object: listOfObjects) {
                        Tasks task = Tasks.class.cast(object);
                        String deadline = task.getDeadline().get(Calendar.DAY_OF_MONTH) + "/" + task.getDeadline().get(Calendar.MONTH) + "/" + task.getDeadline().get(Calendar.YEAR);
                        csvPrinter.printRecord(task.getName(), task.getText(),
                                task.isDone(), deadline);
                    }
                    csvPrinter.flush();
                }
                break;
        }
    }
}

