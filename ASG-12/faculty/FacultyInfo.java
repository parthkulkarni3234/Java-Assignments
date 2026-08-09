package faculty;

public class FacultyInfo {
    String name;
    String subject;

    public FacultyInfo(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void display() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Subject: " + subject);
    }
}