package lab08;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            stmt.executeQuery("DROP TABLE movies");
            String createTable = "CREATE TABLE movies(" +
                    "id INTEGER NOT NULL," +
                    "title VARCHAR2(30)," +
                    "release_year INTEGER," +
                    "duration INTEGER," +
                    "score INTEGER)";
            stmt.executeQuery(createTable);

            stmt.executeQuery("DROP TABLE genres");
            createTable = "CREATE TABLE genres(" +
                    "id INTEGER NOT NULL," +
                    "name VARCHAR2(20))";
            stmt.executeQuery(createTable);

            stmt.executeQuery("DROP TABLE assoc_movie_gender");
            createTable = "CREATE TABLE assoc_movie_gender(" +
                    "id_movie INTEGER NOT NULL," +
                    "id_gender INTEGER NOT NULL)";
            stmt.executeQuery(createTable);

            stmt.executeQuery("DROP TABLE actors");
            createTable = "CREATE TABLE actors(" +
                    "id_actor INTEGER NOT NULL," +
                    "nume VARCHAR2(30))";
            stmt.executeQuery(createTable);

            stmt.executeQuery("DROP TABLE directors");
            createTable = "CREATE TABLE directors(" +
                    "id_director INTEGER NOT NULL," +
                    "nume VARCHAR2(30))";
            stmt.executeQuery(createTable);

            stmt.executeQuery("DROP TABLE cast");
            createTable = "CREATE TABLE cast(" +
                    "id_person INTEGER NOT NULL," +
                    "id_movie INTEGER NOT NULL)";
            stmt.executeQuery(createTable);
            stmt.close();

//            DAO.MovieController.create("Star Wars IV", 1977, 120, 10);
//            DAO.MovieController.create("Star Wars V", 1980, 120, 10);
//            DAO.MovieController.create("Star Wars VI", 1983, 120, 10);
//
//            DAO.GenreController.create("Action");
//            DAO.GenreController.create("SF");
//            DAO.GenreController.create("Drama");
//
//            DAO.ActorController.create("Harrison Ford");
//            DAO.ActorController.create("Mark Hamil");
//
//            DAO.DirectorController.create("George Lucas");
//            DAO.DirectorController.create("Steven Spielberg");
//
//            DAO.CastController.create(1, 1);
//            DAO.CastController.create(1, 2);
//            DAO.CastController.create(1, 3);

            Tool.importDate("C:\\Users\\panza\\Desktop\\lab8_opt\\IMDb movies.csv");

        } catch (SQLException throwable) {
            System.out.println("SQL Exception in main");
        }

    }
}
