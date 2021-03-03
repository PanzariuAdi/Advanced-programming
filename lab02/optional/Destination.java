package lab02;

public class Destination {
    private String name;
    private int demands;

    Destination() {};
    Destination(String name, int demands) { this.name = name; this.demands = demands; }

    public int getDemands() { return demands; }
    public void setDemands(int demands) { this.demands = demands; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                "demands='" + demands + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object dest) {
        if(dest == this) { return true; }
        if(dest == null) { return false; }

        Destination copy = (Destination) dest;

        return name.equals(copy.name);
    }

}
