import java.util.Scanner;

class SalaryConverter {

    public Integer toInteger(String value) {
        return Integer.valueOf(value);
    }

    public Double toDouble(String value) {
        return Double.valueOf(value);
    }
}

// Main class
public class EmployeePayroll {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SalaryConverter converter = new SalaryConverter();

        System.out.print("Enter Employee ID: ");
        String empIdInput = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String salaryInput = sc.nextLine();

        System.out.print("Enter Bonus Amount: ");
        String bonusInput = sc.nextLine();

        // Using the SalaryConverter class to convert String to wrapper objects
        Integer empId = converter.toInteger(empIdInput);
        Double basicSalary = converter.toDouble(salaryInput);
        Double bonus = converter.toDouble(bonusInput);

        // Validation
        if (basicSalary < 0 || bonus < 0) {
            System.out.println("Error: Salary and bonus cannot be negative.");
        } else {
            // Unboxing wrapper objects back to primitives for calculation
            double netSalary = basicSalary.doubleValue() + bonus.doubleValue();

            System.out.println("\nPayroll Details: ");
            System.out.println("Employee ID: " + empId);
            System.out.println("Basic Salary: Rs. " + basicSalary);
            System.out.println("Bonus: Rs. " + bonus);
            System.out.println("Net Salary: Rs. " + netSalary);
        }

        sc.close();
    }
}