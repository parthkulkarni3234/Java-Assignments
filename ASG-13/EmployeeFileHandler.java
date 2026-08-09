import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeFileHandler {
    static File f0 = new File("employee.txt");

    public static void main(String args[]) {
        EmployeeFileHandler.filecreator();
        EmployeeFileHandler.filewriter();
        EmployeeFileHandler.filereader();
    }

    static void filecreator() {
        try {
            if (f0.createNewFile()) {
                System.out.println("File " + f0.getName() + " is created successfully.");
            } else {
                System.out.println("File already exists in the directory.");
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error occurred.");
            exception.printStackTrace();
        }
    }

    static void filewriter() {
        try {
            FileWriter fwrite = new FileWriter(f0);
            fwrite.write("Employee ID: E101\n");
            fwrite.write("Name: Parth Kulkarni\n");
            fwrite.write("Department: Accounts\n");
            fwrite.write("Salary: 4500000\n");
            fwrite.close();
            System.out.println("Employee details successfully written to the file.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

    static void filereader() {
        try {
            Scanner dataReader = new Scanner(f0);
            System.out.println("\n--- Employee Details ---");
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Unexpected error occurred!");
            exception.printStackTrace();
        }
    }
}