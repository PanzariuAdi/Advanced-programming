package lab04;

public class School implements Comparable<School>{
    private String nume;
    private int capacity;

    public School(String nume) { this.nume = nume; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }


    @Override
    public int compareTo(School other) {
        return this.nume.compareTo(other.getNume());
    }
}
