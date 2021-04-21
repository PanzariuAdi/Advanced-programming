package DAO;

import lab08.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActorController {
    private static int id = 1;
    private ActorController() {}

    public static void create(String name) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String checkValue = "SELECT 1 FROM actors WHERE nume = '" + name + "'";
            ResultSet rs = stmt.executeQuery(checkValue);

            if (!rs.isBeforeFirst()) {
                String insertIntoTable = "INSERT INTO actors VALUES(" +
                        id + ",'" +
                        name + "')";
                stmt.executeUpdate(insertIntoTable);
                id++;
            }
            stmt.close();
        } catch (SQLException throwable) {
            System.out.println("Actor controller SQL Exception");
        }
    }
}
