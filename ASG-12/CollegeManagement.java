import student.StudentInfo;
import faculty.FacultyInfo;

public class CollegeManagement {
    public static void main(String[] args) {
        StudentInfo student = new StudentInfo("Parth Thikrul", 15);
        student.display();

        System.out.println();

        FacultyInfo faculty = new FacultyInfo("Dr. Prashant Ahire", "DS");
        faculty.display();
    }
}