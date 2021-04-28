package lab09.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "actors")
public class Actor implements Serializable {
    @Id
    @Column(name = "id_actor", unique = true)
    private int id;

    @Column(name = "nume", nullable = false)
    private String name;

//  Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
