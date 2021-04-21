package lab08;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Tool {
    public Tool() {}

    public static void importDate(String path) {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] line;
            int year = 0, duration = 0, score = 0;
            while ((line = reader.readNext()) != null) {
                try {
                    year = Integer.parseInt(line[3]);
                    duration = Integer.parseInt(line[6]);
                    score = Integer.parseInt(line[15]);
                } catch (NumberFormatException ex) {
                    System.out.println("Integer parse exception thrown");
                }
                DAO.MovieController.create(line[1], year, duration, score);
                DAO.DirectorController.create(line[9]);

                for(String genre : line[5].split(",+"))
                    DAO.GenreController.create(genre);

                for (String actor : line[10].split(",+"))
                    DAO.ActorController.create(actor);

            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

}
