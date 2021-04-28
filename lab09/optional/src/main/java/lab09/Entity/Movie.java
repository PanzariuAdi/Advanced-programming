package lab09.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "movies")
public class Movie implements Serializable, Comparable<Movie>{

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "score", nullable = false)
    private int score;

//    Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public int compareTo(Movie o) {
        return Integer.compare(o.getScore(), this.getScore());
    }
}
