package lab03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Location implements Comparable<Location>{
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();
    private Integer distance = Integer.MAX_VALUE;
    private List<Location> shortestPath = new LinkedList<>();

    public String getName()  { return this.name; }
    public void setName(String name) { this.name = name; }
    public void setCost(Location location, Integer cost) { this.cost.put(location, cost); } //Add a new location and the cost needed to reach that destination from current destination
    public Map<Location, Integer> getCost() { return cost; } // Return cost Hashmap
    public Integer getDistance() { return distance; }
    public void setDistance(Integer distance) { this.distance = distance; }
    public void showCosts() { System.out.println(cost); } // Show cost Hashmap
    public List<Location> getShortestPath() { return shortestPath; }
    public void setShortestPath(List<Location> shortestPath) { this.shortestPath = shortestPath; }



    @Override
    public String toString() {
        return "Location{" +
                "name='" + getName() + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Location other) {
        if (this.name == null || other.name == null) return -1;
        return this.name.compareTo(other.name);
    }
}
