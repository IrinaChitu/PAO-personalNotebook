package services;

import models.events.Anniversary;
import models.events.Meeting;
import models.notes.Quotes;
import models.notes.Tasks;

import java.sql.*;
import java.util.Calendar;
import java.util.List;

import static services.WriteCSV.dateToString;

public class UpdateDatabase {
    public static <T> void DatabaseUpdater(T object) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/notebook", "root", "");

            switch( object.getClass().getSimpleName() ) {
                case "Anniversary":
                    Anniversary anniversary = Anniversary.class.cast(object);
                    pstmt = conn.prepareStatement("UPDATE anniversaries SET date=?, description=?, birthday_person=?, party_place=?, gift = ? WHERE id= ?");
                    pstmt.setString(1, dateToString(anniversary.getDate()));
                    pstmt.setString(2, anniversary.getDescription());
                    pstmt.setString(3, anniversary.getBirthdayPerson());
                    pstmt.setString(4, anniversary.getPartyPlace());
                    pstmt.setString(5, anniversary.getGift());
                    pstmt.setInt(6, anniversary.getId());

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
                    break;

                case "Meetings":
                    Meeting meeting = Meeting.class.cast(object);
                    pstmt = conn.prepareStatement("UPDATE anniversaries SET date=?, description=?, purpose=?, place=?, start_time= ?, end_time=? WHERE id= ?");
                    pstmt.setString(1, dateToString(meeting.getDate()));
                    pstmt.setString(2, meeting.getDescription());
                    pstmt.setString(3, meeting.getPurpose());
                    pstmt.setString(4, meeting.getPlace());
                    String startTime = Integer.toString(meeting.getStartTime().get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(meeting.getStartTime().get(Calendar.MINUTE));
                    String endTime = meeting.getEndTime().get(Calendar.HOUR_OF_DAY) + ":" + meeting.getEndTime().get(Calendar.MINUTE);
                    pstmt.setString(5, startTime);
                    pstmt.setString(6, endTime);
                    pstmt.setInt(7, meeting.getId());

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
                    break;

                case "Quotes":
                    Quotes quote = Quotes.class.cast(object);
                    pstmt = conn.prepareStatement("UPDATE anniversaries SET name=?, text=?, author=? WHERE id= ?");
                    pstmt.setString(1, quote.getName());
                    pstmt.setString(2, quote.getText());
                    pstmt.setString(3, quote.getAuthor());
                    pstmt.setInt(4, quote.getId());

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
                    break;

                case "Tasks":
                    Tasks task = Tasks.class.cast(object);
                    pstmt = conn.prepareStatement("UPDATE anniversaries SET name=?, text=?, done=?, deadline=? WHERE id= ?");
                    pstmt.setString(1, task.getName());
                    pstmt.setString(2, task.getText());
                    pstmt.setBoolean(3, task.isDone());
                    String deadline = task.getDeadline().get(Calendar.DAY_OF_MONTH) + "/" + task.getDeadline().get(Calendar.MONTH) + "/" + task.getDeadline().get(Calendar.YEAR);
                    pstmt.setString(4, deadline);

                    pstmt.setInt(5, task.getId());

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
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
