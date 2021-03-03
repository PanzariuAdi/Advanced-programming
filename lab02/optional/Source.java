package lab02;

public abstract class Source {
    protected String name;
    protected String type = "Source";
    protected int capacity;

    public String getType() { return type; }

    Source() { this.type = "Source"; }
    Source(String name, int capacity) { this.name = name; this.capacity = capacity; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity;}
    public void setCapacity(int capacity) { this.capacity = capacity; }


    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                "capacity='" + capacity + '\'' +
                '}';
    }

    @Override
    public boolean equals (Object source) {
        if(source == this) { return true; }
        if(source == null) { return false; }

        Source copy = (Source) source;
        return name.equals(copy.name);
    }
}
