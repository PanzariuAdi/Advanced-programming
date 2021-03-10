package lab03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class City {
    private String name;
    private List<Location> nodes = new ArrayList<>();

    public List<Location> getNodes() { return nodes; }
    public void setNodes(List<Location> nodes) { this.nodes = nodes; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public void addNode(Location node) { nodes.add(node); }

//    In the City class, create a method to display the locations that are visitable and are not payable, sorted by their opening hour.
    public void showVisitableButNoPayable() {
        for (Location node : nodes) {
            if (node instanceof Visitable && !(node instanceof Payable)) {
                System.out.println(node);
            }
        }
    }

    public void showAllNodes() {
        for(Location node : nodes) {
            System.out.println(node);
        }
    }

}
