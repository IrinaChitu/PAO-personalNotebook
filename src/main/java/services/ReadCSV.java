package services;

import models.events.Academical;
import models.events.Anniversary;
import models.events.Meeting;
import models.notes.Quotes;
import models.notes.Story;
import models.notes.Tasks;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadCSV {

    public static <T> List<T> CSVReader(String type) throws IOException, ParseException {
        List<T> read = new ArrayList<>();
        switch (type) {
            case "Anniversary":
                try (
                        Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/anniversary.csv"));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                .withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
                ) {
                    for (CSVRecord csvRecord : csvParser) {

                        // Accessing values by Header names
                        String dataTemp = csvRecord.get("Date");
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTemp);
                        String description = csvRecord.get("Description");
                        String birthdayPerson = csvRecord.get("BirthdayPerson");
                        String partyPlace = csvRecord.get("PartyPlace");
                        String gift = csvRecord.get("Gift");

                        Anniversary anniversary = new Anniversary(date, description, birthdayPerson, partyPlace, gift);
                        read.add((T) anniversary);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;

            case "Academical":
                try (
                        Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/academical.csv"));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                .withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
                ) {
                    for (CSVRecord csvRecord : csvParser) {

                        // Accessing values by Header names
                        String dataTemp = csvRecord.get("Date");
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTemp);
                        String description = csvRecord.get("Description");
                        String typee = csvRecord.get("Type");
                        String field = csvRecord.get("Field");
                        String place = csvRecord.get("Place");
                        int startTime = Integer.parseInt(csvRecord.get("StartTime"));
                        int endTime = Integer.parseInt(csvRecord.get("EndTime"));

                        Academical academical = new Academical(date, description, typee, field, place, startTime, endTime);
                        read.add((T) academical);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;

            case "Meeting":
                try (
                        Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/meeting.csv"));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                .withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
                ) {
                    for (CSVRecord csvRecord : csvParser) {

                        // Accessing values by Header names
                        String dataTemp = csvRecord.get("Date");
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTemp);

                        String startTemp = csvRecord.get("StartTime");
                        Calendar startTime = Calendar.getInstance();
                        String [] splitStartTime = startTemp.split(":");
                        startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splitStartTime[0]));
                        startTime.set(Calendar.MINUTE, Integer.parseInt(splitStartTime[1]));
                        startTime.set(Calendar.SECOND,0);
                        startTime.set(Calendar.MILLISECOND,0);

                        String endTemp = csvRecord.get("EndTime");
                        Calendar endTime = Calendar.getInstance();
                        String [] splitEndTime = startTemp.split(":");
                        endTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splitEndTime[0]));
                        endTime.set(Calendar.MINUTE, Integer.parseInt(splitEndTime[1]));
                        endTime.set(Calendar.SECOND,0);
                        endTime.set(Calendar.MILLISECOND,0);
                        Meeting meeting = new Meeting(date, csvRecord.get("Description"), csvRecord.get("Purpose"), csvRecord.get("Place"), startTime, endTime);
                        read.add((T) meeting);
                    }
                }
                break;

            case "Quotes":
                try (
                        Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/quotes.csv"));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                .withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
                ) {
                    for (CSVRecord csvRecord : csvParser) {

                        Quotes quote = new Quotes(csvRecord.get("Name"), csvRecord.get("Text"), csvRecord.get("Author"));
                        read.add((T) quote);
                    }
                }
                break;

            case "Story":
                try (
                        Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/story.csv"));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                .withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
                ) {
                    for (CSVRecord csvRecord : csvParser) {

                        String[] people = csvRecord.get("PeopleInvolved").split(", ");
                        Set<String> peopleInvolved = new HashSet<String>();
                        for (String person: people) {
                            peopleInvolved.add(person);
                        }

                        Story story = new Story(csvRecord.get("Name"), csvRecord.get("Text"), csvRecord.get("Place"), peopleInvolved);
                        read.add((T) story);
                    }
                }
                break;

            case "Tasks":
                try (
                        Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/tasks.csv"));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                .withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
                ) {
                    for (CSVRecord csvRecord : csvParser) {
                        // Accessing values by Header names\
                        String deadlineTemp = csvRecord.get("Deadline");
                        Calendar deadline = Calendar.getInstance();
                        String [] splitDeadline = deadlineTemp.split("/");
                        deadline.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitDeadline[0]));
                        deadline.set(Calendar.MONTH, Integer.parseInt(splitDeadline[1]));
                        deadline.set(Calendar.YEAR, Integer.parseInt(splitDeadline[2]));
                        Tasks task = new Tasks(csvRecord.get("Name"), csvRecord.get("Text"), deadline);
                        read.add((T) task);
                    }
                }
                break;
        }
        return read;
    }
}
