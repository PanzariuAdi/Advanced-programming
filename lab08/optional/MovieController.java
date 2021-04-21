package DAO;

import jdk.swing.interop.SwingInterOpUtils;
import lab08.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieController {
    private static int id = 1;
    private MovieController() {}

    public static void create(String title, int release_year, int duration, int score) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String insertIntoTable = "INSERT INTO movies VALUES(" +
                    id + ",'" +
                    title + "'," +
                    release_year + "," +
                    duration + "," +
                    score + ")";
            stmt.executeUpdate(insertIntoTable);
            id++;
            stmt.close();
        } catch (SQLException throwable) {
            System.out.println("Movie Controller SQL exception !");
        }

    }

    public static void showMovies() {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
            System.out.println("\nID TITLE RELEASE_YEAR DURATION SCORE");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
            }
        } catch (SQLException throwable) {
            System.out.println("Movie Controller SQL Exception at show function");
        }
    }

    public static void getByID(int id){
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String command = "SELECT * FROM movies WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(command);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
            }
        } catch (SQLException throwable) {
            System.out.println("Movie Controller find SQL Exception ");
        }
    }
}
