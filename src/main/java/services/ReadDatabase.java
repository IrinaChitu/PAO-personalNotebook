package services;

import models.events.Anniversary;
import models.events.Meeting;
import models.notes.Quotes;
import models.notes.Tasks;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReadDatabase {

    public static <T> List<T> DatabaseReader(String type, String query) {
        List<T> selected = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/notebook", "root", "");

            switch( type ) {
                case "Anniversary":
                    pstmt = conn.prepareStatement("SELECT * FROM anniversaries WHERE birthday_person = ?");
                    pstmt.setString(1, query);
                    rs = pstmt.executeQuery();
                    while(rs.next()) {
                        String dataTemp = rs.getString("date");
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTemp);
                        Anniversary anniversary = new Anniversary(date, rs.getString("description"), rs.getString("birthday_person"), rs.getString("party_place"), rs.getString("gift"));
                        anniversary.setId(rs.getInt("id"));
                        selected.add((T) anniversary);
                    }
                    return selected;

                case "Meeting":
                    pstmt = conn.prepareStatement("SELECT * FROM meetings WHERE place = ?");
                    pstmt.setString(1, query);
                    rs = pstmt.executeQuery();
                    while(rs.next()) {
                        String dataTemp = rs.getString("date");
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTemp);

                        String startTemp = rs.getString("start_time");
                        Calendar startTime = Calendar.getInstance();
                        String [] splitStartTime = startTemp.split(":");
                        startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splitStartTime[0]));
                        startTime.set(Calendar.MINUTE, Integer.parseInt(splitStartTime[1]));
                        startTime.set(Calendar.SECOND,0);
                        startTime.set(Calendar.MILLISECOND,0);

                        String endTemp = rs.getString("end_time");
                        Calendar endTime = Calendar.getInstance();
                        String [] splitEndTime = startTemp.split(":");
                        endTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splitEndTime[0]));
                        endTime.set(Calendar.MINUTE, Integer.parseInt(splitEndTime[1]));
                        endTime.set(Calendar.SECOND,0);
                        endTime.set(Calendar.MILLISECOND,0);

                        Meeting meeting = new Meeting(date, rs.getString("description"), rs.getString("purpose"), rs.getString("place"), startTime, endTime);

                        meeting.setId(rs.getInt("id"));
                        selected.add((T) meeting);
                    }
                    return selected;

                case "Quotes":
                    pstmt = conn.prepareStatement("SELECT * FROM quotes WHERE author = ?");
                    pstmt.setString(1, query);
                    rs = pstmt.executeQuery();
                    while(rs.next()) {
                        Quotes quote = new Quotes(rs.getString("name"), rs.getString("text"), rs.getString("author"));
                        quote.setId(rs.getInt("id"));
                        selected.add((T) quote);
                    }
                    return selected;

                case "Tasks":
                    pstmt = conn.prepareStatement("SELECT * FROM tasks WHERE id = ?");
                    pstmt.setString(1, query);   // aici trebuie conversie din string in int
                    rs = pstmt.executeQuery();
                    while(rs.next()) {
                        String deadlineTemp = rs.getString("deadline");
                        Calendar deadline = Calendar.getInstance();
                        String [] splitDeadline = deadlineTemp.split("/");
                        deadline.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitDeadline[0]));
                        deadline.set(Calendar.MONTH, Integer.parseInt(splitDeadline[1]));
                        deadline.set(Calendar.YEAR, Integer.parseInt(splitDeadline[2]));
                        Tasks task = new Tasks(rs.getString("name"), rs.getString("text"), deadline);
                        task.setId(rs.getInt("id"));
                        selected.add((T) task);
                    }
                    return selected;

            }
        }
        catch(SQLException ex)
        {
            System.out.println("Eroare la conectarea la BD: " + ex);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally
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

        return selected;

    }

}
