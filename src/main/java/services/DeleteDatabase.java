package services;

import models.events.Anniversary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static services.WriteCSV.dateToString;

public class DeleteDatabase {
    public static  void DatabaseDeleter(String type, int id) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/notebook", "root", "");

            switch (type) {
                case "Anniversary":
                    pstmt = conn.prepareStatement("DELETE FROM anniversaries WHERE id = ?");
                    pstmt.setInt(1, id);

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
                    break;

                case "Meeting":
                    pstmt = conn.prepareStatement("DELETE FROM meetings WHERE id = ?");
                    pstmt.setInt(1, id);

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
                    break;

                case "Quotes":
                    pstmt = conn.prepareStatement("DELETE FROM quotes WHERE id = ?");
                    pstmt.setInt(1, id);

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
                    break;

                case "Tasks":
                    pstmt = conn.prepareStatement("DELETE FROM tasks WHERE id = ?");
                    pstmt.setInt(1, id);

                    n = pstmt.executeUpdate();
                    System.out.println("Au fost modificate " + n + " inregistrari!");
                    break;

            }
        } catch (SQLException ex) {
            System.out.println("Eroare la conectarea la BD: " + ex);
        } finally {
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
