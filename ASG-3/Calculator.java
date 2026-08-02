public class Calculator {

    // Static variable
    static int calculationCount = 0;

    // Overloaded method - adds two integers
    public int add(int a, int b) {
        calculationCount++;
        return a + b;
    }

    // Overloaded method - adds two decimals
    public double add(double a, double b) {
        calculationCount++;
        return a + b;
    }

    // Overloaded method - adds three integers
    public int add(int a, int b, int c) {
        calculationCount++;
        return a + b + c;
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        int result1 = calc.add(5, 10);
        double result2 = calc.add(2.5, 3.7);
        int result3 = calc.add(1, 2, 3);

        System.out.println("5 + 10: " + result1);
        System.out.println("2.5 + 3.7: " + result2);
        System.out.println("1+2+3: " + result3);

        // Static variable
        System.out.println("Total calculations performed: " + calculationCount);
    }
}