package services;

import models.events.Anniversary;
import models.events.Meeting;
import models.notes.Quotes;
import models.notes.Tasks;

import java.sql.*;
import java.util.Calendar;
import java.util.List;

import static services.WriteCSV.dateToString;

public class WriteDatabase {

    private static int id_database = 0;

    public static <T> void DatabaseWriter(List<T> listOfObjects) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/notebook", "root", "");

            switch( listOfObjects.get(0).getClass().getSimpleName() ) {
                case "Anniversary":
                    for( T object: listOfObjects) {
                        Anniversary anniversary = Anniversary.class.cast(object);
//                        Date date = anniversary.getDate();
//                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                        String strDate = dateFormat.format(date);
                        pstmt = conn.prepareStatement("INSERT INTO anniversaries VALUES (?, ?, ?, ?, ?, ?)");
                        pstmt.setInt(1, anniversary.getId());
                        pstmt.setString(2, dateToString(anniversary.getDate()));
                        pstmt.setString(3, anniversary.getDescription());
                        pstmt.setString(4, anniversary.getBirthdayPerson());
                        pstmt.setString(5, anniversary.getPartyPlace());
                        pstmt.setString(6, anniversary.getGift());
                        n = pstmt.executeUpdate();
                        System.out.println("Au fost modificate " + n + " inregistrari!");

                    }
                    break;

                case "Meeting":
                    for( T object: listOfObjects) {
                        Meeting meeting = Meeting.class.cast(object);
                        pstmt = conn.prepareStatement("INSERT INTO meetings VALUES (?, ?, ?, ?, ?, ?, ?)");
                        pstmt.setInt(1, meeting.getId());
                        pstmt.setString(2, dateToString(meeting.getDate()));
                        pstmt.setString(3, meeting.getDescription());
                        pstmt.setString(4, meeting.getPurpose());
                        pstmt.setString(5, meeting.getPlace());
                        String startTime = Integer.toString(meeting.getStartTime().get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(meeting.getStartTime().get(Calendar.MINUTE));
                        String endTime = meeting.getEndTime().get(Calendar.HOUR_OF_DAY) + ":" + meeting.getEndTime().get(Calendar.MINUTE);
                        pstmt.setString(6, startTime);
                        pstmt.setString(7, endTime);

                        n = pstmt.executeUpdate();
                        System.out.println("Au fost modificate " + n + " inregistrari!");

                    }
                    break;

                case "Quotes":
                    for( T object: listOfObjects) {
                        Quotes quote = Quotes.class.cast(object);
                        pstmt = conn.prepareStatement("INSERT INTO quotes VALUES (?, ?, ?, ?)");
                        pstmt.setInt(1, quote.getId());
                        pstmt.setString(2, quote.getName());
                        pstmt.setString(3, quote.getText());
                        pstmt.setString(4, quote.getAuthor());

                        n = pstmt.executeUpdate();
                        System.out.println("Au fost modificate " + n + " inregistrari!");

                    }
                    break;

                case "Tasks":
                    for( T object: listOfObjects) {
                        Tasks task = Tasks.class.cast(object);
                        pstmt = conn.prepareStatement("INSERT INTO tasks VALUES (?, ?, ?, ?, ?)");
                        pstmt.setInt(1, task.getId());
                        pstmt.setString(2, task.getName());
                        pstmt.setString(3, task.getText());
                        pstmt.setBoolean(4, task.isDone());
                        String deadline = task.getDeadline().get(Calendar.DAY_OF_MONTH) + "/" + task.getDeadline().get(Calendar.MONTH) + "/" + task.getDeadline().get(Calendar.YEAR);
                        pstmt.setString(5, deadline);

                        n = pstmt.executeUpdate();
                        System.out.println("Au fost modificate " + n + " inregistrari!");

                    }
                    break;
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Eroare la conectarea la BD: " + ex);
        }
        finally
        {
            try {
                if (pstmt != null)
                    pstmt.close();

                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println("Eroare la închiderea conexiunii cu BD!");
            }
        }

    }
}
