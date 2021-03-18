import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student(faker.name().firstName())).toArray(Student[]::new);
        var schools = IntStream.rangeClosed(0,2).mapToObj(i -> new School(faker.gameOfThrones().house())).toArray(School[]::new);
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        Map<Student, List<School>> studentPreferences = new HashMap<>();
        Map<School, List<Student>> schoolPreferences = new HashMap<>();

        List<School> schoolList = new LinkedList<>();
        List<Student> studentList = new LinkedList<>();
        Collections.addAll(schoolList, schools);
        Collections.addAll(studentList, students);

        studentPreferences.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        studentPreferences.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        studentPreferences.put(students[2], Arrays.asList(schools[0], schools[1]));
        studentPreferences.put(students[3], Arrays.asList(schools[0], schools[2]));

        schoolPreferences.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schoolPreferences.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schoolPreferences.put(schools[2], Arrays.asList(students[0], students[1], students[3]));


//        Using Java Stream API, write queries that display the students who find acceptable a given list of schools,
//        and the schools that have a given student as their top preference.

        List<School> givenList = new LinkedList<>();
        givenList.add(schools[0]);
        givenList.add(schools[1]);
        givenList.add(schools[2]);

        Student s = students[3];

        studentList.stream().filter(st -> studentPreferences.get(st).containsAll(givenList)).forEach(System.out::println);
        System.out.println("--------------------");
        schoolList.stream().filter(h -> schoolPreferences.get(h).lastIndexOf(s) == 0).forEach(System.out::println);
        System.out.println("--------------------");

        Problem p = new Problem();
        p.setStudentPreferences(studentPreferences);
        p.setSchoolPreferences(schoolPreferences);

    }
}
