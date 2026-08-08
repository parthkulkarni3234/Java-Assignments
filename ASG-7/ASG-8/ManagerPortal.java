class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void showDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;

    Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    void showManagerDetails() {
        super.showDetails();
        System.out.println("Department: " + department);
    }
}

public class ManagerPortal {
    public static void main(String[] args) {
        Manager manager = new Manager("Rahul Sharma", 85000.0, "Sales");
        manager.showManagerDetails();
    }
}