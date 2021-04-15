package DAO;

import lab08.DatabaseConnection;
import java.sql.Statement;

public class GenderController {
    private static int id;
    private GenderController() {}
    public static void create(String gender) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String insertGender = "INSERT INTO genres VALUES(" + id + "," + gender + ")";
            id++;
            DatabaseConnection.getInstance().getConnection().close();
        } catch (Exception e) {
            System.out.println("Gender controller exception");
        }

    }
}
