package lab04;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);

        List<Student> studentList = new LinkedList<>();
        Collections.addAll(studentList, students);

        studentList.sort(Comparator.comparing(Student::getNume));


        Set<School> schoolSet = new TreeSet<>();
        var schools = IntStream.rangeClosed(0, 3).mapToObj(i -> new School("H" + i)).toArray(School[]::new);
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);
        Collections.addAll(schoolSet, schools);

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        Map<Student, List<School>> stdPrefMap2 = new TreeMap<>();
        stdPrefMap2.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap2.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap2.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap2.put(students[3], Arrays.asList(schools[0], schools[2]));

        for (Map.Entry <Student, List<School>> entry :  stdPrefMap.entrySet()) {
            System.out.print(entry.getKey().getNume() + " -> ");
            for(School s : entry.getValue()) {
                System.out.print(s.getNume() + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
        for (Map.Entry <Student, List<School>> entry :  stdPrefMap2.entrySet()) {
            System.out.print(entry.getKey().getNume() + " -> ");
            for(School s : entry.getValue()) {
                System.out.print(s.getNume() + " ");
            }
            System.out.println();
        }
    }
}
