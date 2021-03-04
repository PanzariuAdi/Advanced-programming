package lab03;

import java.util.HashMap;
import java.util.Map;

public abstract class Location{
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();

    public void setCost (Location node, int value) {
        cost.put(node, value);
    }

//    @Override
//    public int compareTo(Location other) {
//        if (other == null || this.name == null) return 0;
//        return this.name.compareTo(other.name);
//    }
}
