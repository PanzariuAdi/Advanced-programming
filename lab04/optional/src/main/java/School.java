public class School {
    private String name;
    private int capacity;
    private boolean isFull;

    public School(String name) { this.name = name; }
    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.isFull = (capacity <= 0);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        this.isFull = (capacity <= 0);
    }
}
