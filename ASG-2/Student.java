public class Student {

    // Variables
    String name;
    int rollNo;

    // Default constructor 
    public Student() {
        name = "Not Assigned";
        rollNo = 0;
    }

    // Parameterized constructor 
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Method to display student details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }

    public static void main(String[] args) {

        // Object created using default constructor
        Student s1 = new Student();

        // Object created using parameterized constructor
        Student s2 = new Student("Parth Kulkarni", 10);

        s1.display();
        s2.display();
    }
}