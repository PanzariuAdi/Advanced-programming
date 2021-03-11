package lab04;

import java.util.stream.IntStream;

public class Student implements Comparable<Student>{
    private String nume;

    public Student(String nume) { this.nume = nume; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    @Override
    public int compareTo(Student other) {
        return this.nume.compareTo(other.getNume());
    }

}
