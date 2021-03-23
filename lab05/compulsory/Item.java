package lab05;

import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String location;

    private Map<String, Object> tags = new HashMap<>();

    public void addTag(String key, String id) { this.id = id; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
