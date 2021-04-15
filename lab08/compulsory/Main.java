package lab08;

import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String createTable = "CREATE TABLE movies(" +
                    "id INTEGER NOT NULL," +
                    "title VARCHAR2(20)," +
                    "release_date DATE," +
                    "duration INTEGER," +
                    "score INTEGER," +
                    "PRIMARY KEY (id))";
            stmt.executeQuery(createTable);

            createTable = "CREATE TABLE genres(" +
                    "id INTEGER NOT NULL," +
                    "gender VARCHAR2(20)" +
                    "PRIMARY KEY (id))";
            stmt.executeQuery(createTable);

            createTable = "CREATE TABLE description(" +
                    "id INTEGER NOT NULL," +
                    "gender VARCHAR2(20))";
            stmt.executeQuery(createTable);

            DatabaseConnection.getInstance().getConnection().close();

            DAO.MovieController.create("Star Wars", "1977", 120, 10);
            DAO.GenderController.create("SF");
            DAO.MovieController.create("Indiana Jones", "1980", 120, 10);
            DAO.GenderController.create("Action");

        } catch (Exception e) {
            System.out.println("Nu s-a putut realiza conexiunea");
        }

    }
}
