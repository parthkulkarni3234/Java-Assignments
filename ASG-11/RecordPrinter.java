interface Printable {
    void print();
}

class Student implements Printable {
    String name;
    int rollNumber;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void print() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Employee implements Printable {
    String name;
    String designation;

    Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public void print() {
        System.out.println("Employee Name: " + name);
        System.out.println("Designation: " + designation);
    }
}

public class RecordPrinter {
    public static void main(String[] args) {
        Printable student = new Student("Vishrut Chinta", 218);
        student.print();

        System.out.println();

        Printable employee = new Employee("Aniruddha Pratap Singh", "Software Engineer");
        employee.print();
    }
}