package lab03;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String nume;
    private List<Location> nodes = new ArrayList<>();

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public Location getLocation(int index) {
        int i = 1;
        for(Location location : nodes) {
            if(i == index) return location;
        }
        return null;
    }

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}
