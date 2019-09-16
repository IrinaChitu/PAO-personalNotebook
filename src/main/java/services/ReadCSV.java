package services;

//public interface ReadCSV {
//}

import models.events.Anniversary;
import models.events.Meeting;
import models.notes.Quotes;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReadCSV {
//    private static final String CSV_FILE_PATH = "./src/main/resources/anniversary.csv";
//
//    public static void main(String[] args) throws IOException {
//        try (
//                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
//                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
//                        .withFirstRecordAsHeader()
//                        .withIgnoreHeaderCase()
//                        .withTrim());
//        ) {
//            for (CSVRecord csvRecord : csvParser) {
//                // Accessing values by Header names
//                String date = csvRecord.get("date");
//                String birthdayPerson = csvRecord.get("birthdayPerson");
//                String partyPlace = csvRecord.get("partyPlace");
//                String gift = csvRecord.get("gift");
//
//                System.out.println("Record No - " + csvRecord.getRecordNumber());
//                System.out.println("---------------");
//                System.out.println("date : " + date);
//                System.out.println("birthdayPerson : " + birthdayPerson);
//                System.out.println("partyPlace : " + partyPlace);
//                System.out.println("gift : " + gift);
//                System.out.println("---------------\n\n");
//            }
//
//
//        }
//    }

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

//                        System.out.println("Record No - " + csvRecord.getRecordNumber());
//                        System.out.println("---------------");
//                        System.out.println("date : " + date);
//                        System.out.println("description : " + description);
//                        System.out.println("birthdayPerson : " + birthdayPerson);
//                        System.out.println("partyPlace : " + partyPlace);
//                        System.out.println("gift : " + gift);
//                        System.out.println("---------------\n\n");
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;

            case "Meeting":
                //name, text, author
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
                        Meeting meeting = new Meeting(date, csvRecord.get("Description"),
                                csvRecord.get("Purpose"), csvRecord.get("Place"), startTime, endTime);
                        read.add((T) meeting);

//                        System.out.println("Record No - " + csvRecord.getRecordNumber());
//                        System.out.println("---------------");
//                        System.out.println("Date : " + csvRecord.get("Date"));
//                        System.out.println("Description : " + csvRecord.get("Description"));
//                        System.out.println("Purpose : " + csvRecord.get("Purpose"));
//                        System.out.println("Purpose : " + csvRecord.get("Place"));
//                        System.out.println("StartTime : " + csvRecord.get("StartTime"));
//                        System.out.println("EndTime : " + csvRecord.get("EndTime"));
//                        System.out.println("---------------\n\n");
                    }

                }
                break;

            case "Quotes":
                //name, text, author
                try (
                        Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/quotes.csv"));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                .withFirstRecordAsHeader()
                                .withIgnoreHeaderCase()
                                .withTrim());
                ) {
                    for (CSVRecord csvRecord : csvParser) {
                        // Accessing values by Header names
//                        String name = csvRecord.get("Name");
//                        String text = csvRecord.get("Text");
//                        String author = csvRecord.get("Author");

                        Quotes quote = new Quotes(csvRecord.get("Name"), csvRecord.get("Text"), csvRecord.get("Author"));
                        read.add((T) quote);

//                        System.out.println("Record No - " + csvRecord.getRecordNumber());
//                        System.out.println("---------------");
//                        System.out.println("name : " + csvRecord.get("Name"));
//                        System.out.println("text : " + csvRecord.get("Text"));
//                        System.out.println("author : " + csvRecord.get("Author"));
//                        System.out.println("---------------\n\n");
                    }

                }
                break;

            case "Tasks":
                //"Name", "Text", "Done", "Deadline"
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

//                        System.out.println("Record No - " + csvRecord.getRecordNumber());
//                        System.out.println("---------------");
//                        System.out.println("name : " + csvRecord.get("Name"));
//                        System.out.println("text : " + csvRecord.get("Text"));
//                        System.out.println("done : " + csvRecord.get("Done"));
//                        System.out.println("deadline : " + csvRecord.get("Deadline"));
//                        System.out.println("---------------\n\n");
                    }

                }
                break;


        }

        return read;
    }
}

// interfata generica pe care ulterior fiecare clasa o implementeaza
// o singura clasa cu switch