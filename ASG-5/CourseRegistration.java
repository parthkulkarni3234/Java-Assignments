import java.util.ArrayList;


class CourseListGenerator {

    public String generateList(ArrayList<String> courses) {
        StringBuffer sb = new StringBuffer();
        sb.append("Registered Courses: \n");

        for (int i = 0; i < courses.size(); i++) {
            sb.append((i + 1) + ". " + courses.get(i) + "\n");
        }

        return sb.toString();
    }
}

// Main class
public class CourseRegistration {

    public static void main(String[] args) {

        ArrayList<String> registeredCourses = new ArrayList<>();
        CourseListGenerator generator = new CourseListGenerator();

        // Adding courses
        registeredCourses.add("Programming with Java");
        registeredCourses.add("Data Structures");
        registeredCourses.add("Database Management Systems");

        System.out.println(generator.generateList(registeredCourses));

        // Removing a course
        registeredCourses.remove("Data Structures");
        System.out.println("After removing 'Data Structures':");
        System.out.println(generator.generateList(registeredCourses));

        // Viewing final registered courses
        System.out.println("Final Registered Courses:");
        System.out.println(generator.generateList(registeredCourses));
    }
}