package DAO;

import lab08.DatabaseConnection;

import java.sql.Statement;

public class MovieController {
    private static int id = 1;
    private MovieController() {}
    public static void create(String title, String release_date, int duration, int score) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String insertIntoTable = "INSERT INTO TABLE movies VALUES(" +
            title + "," +
            release_date + "," +
            duration + "," +
            score + ");";

            id++;
            DatabaseConnection.getInstance().getConnection().close();
        } catch (Exception e) {
            System.out.println("Exception movie controller");
        }
    }
}
