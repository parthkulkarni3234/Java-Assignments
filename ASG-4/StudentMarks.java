class MarksConverter {

    public Integer toInteger(String value) {
        return Integer.valueOf(value);
    }
}

// Main class
public class StudentMarks {

    public static void main(String[] args) {

        MarksConverter converter = new MarksConverter();

        // Marks stored as Strings
        String mark1 = "85";
        String mark2 = "90";
        String mark3 = "76";

        // Using MarksConverter class to convert String to Integer wrapper objects
        Integer m1 = converter.toInteger(mark1);
        Integer m2 = converter.toInteger(mark2);
        Integer m3 = converter.toInteger(mark3);

        //sum of marks
        int total = m1 + m2 + m3;

        System.out.println("Subject 1 Marks: " + m1);
        System.out.println("Subject 2 Marks: " + m2);
        System.out.println("Subject 3 Marks: " + m3);
        System.out.println("Total Marks: " + total);
    }
}