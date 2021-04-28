package lab09.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "nume", nullable = false)
    private String name;

//    Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
