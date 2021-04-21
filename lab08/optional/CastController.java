package DAO;

import lab08.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class CastController {
    private CastController() {}

    public static void create(int id_person, int id_movie) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();

            String insertIntoTable = "INSERT INTO cast VALUES(" +
                    id_person + "," +
                    id_movie + ")";
            stmt.executeQuery(insertIntoTable);
            stmt.close();
        } catch (SQLException throwable) {
            System.out.println("Cast controller SQL Exception");
        }
    }
}
