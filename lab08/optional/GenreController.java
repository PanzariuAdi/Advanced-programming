package DAO;

import lab08.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreController {
    private static int id = 1;
    private GenreController() {}

    public static void create(String name) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String checkValue = "SELECT 1 FROM genres WHERE name = '" + name + "'";
            ResultSet rs = stmt.executeQuery(checkValue);

            if (!rs.isBeforeFirst()) {
                String insertIntoTable = "INSERT INTO genres VALUES(" +
                        id + ",'" +
                        name + "')";
                stmt.executeUpdate(insertIntoTable);
                id++;
            }
            stmt.close();
        } catch (SQLException throwable) {
            System.out.println("Genre Controller SQL exception");
        }
    }

    public static void showGenres() {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM genres");
            System.out.println("\nID Name");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " "  + rs.getString(2));
            }

        } catch (SQLException throwable) {
            System.out.println("Show genres SQL Exception");
        }
    }

    public static void getByID(int id) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String command = "SELECT * FROM genres WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(command);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException throwable) {
            System.out.println("Genre controller find SQL Exception");
        }
    }
}
