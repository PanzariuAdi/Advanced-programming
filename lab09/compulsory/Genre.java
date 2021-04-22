package DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQuery(name="Genre.findByName", query =  "SELECT * FROM genres WHERE genres.name = name")
public class Genre implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    private int id = 0;

    @Column(name = "name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
