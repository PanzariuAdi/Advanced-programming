import java.util.List;
import java.util.Map;

public class Problem {
    Map<Student, List<School>> studentPreferences;
    Map<School, List<Student>> schoolPreferences;
    List<Solution> solutions;

    public Map<Student, List<School>> getStudentPreferences() { return studentPreferences; }
    public Map<School, List<Student>> getSchoolPreferences() { return schoolPreferences; }
    public void setStudentPreferences(Map<Student, List<School>> studentPreferences) { this.studentPreferences = studentPreferences; }
    public void setSchoolPreferences(Map<School, List<Student>> schoolPreferences) { this.schoolPreferences = schoolPreferences; }

//    public void solve () {
//        for (Map.Entry<Student, List<School>> entry : studentPreferences.entrySet()) {
//            if (entry.getValue().lastIndexOf(entry) == 0 && schoolPreferences.get(entry.getValue()).lastIndexOf(entry.getKey()) == 0) {
////                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^       ^^^^^^^^^^^^^^^^^^^^^^^
////                      First school option
//                System.out.println("PRIMA OPTIUNE LA AMANDOIIIIIIIIIIIIIIIII");
//            }
//            System.out.println(entry.getValue());
//        }
//    }
}
