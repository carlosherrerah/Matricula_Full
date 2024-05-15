package s01.basico;

interface Calculator {
    int calculate(int a, int b);
}

class Operation {
    // A static method that performs addition
    public static int add(int a, int b) {
        return a + b;
    }

    // A static method that performs addition
    public static int subtract(int a, int b) {
        return a - b;
    }

}

public class Lambdas1 {
    public static void main(String[] args) {

        // Por Interface
        Calculator addition1 = (a, b) -> a + b;
        int result1 = addition1.calculate(5, 3);
        System.out.println("Addition: " + result1); // Output: Addition: 8

        Calculator subtraction1 = (a, b) -> a - b;
        int result2 = subtraction1.calculate(10, 4);
        System.out.println("Subtraction: " + result2); // Output: Subtraction: 6

        // Por Interface y Clase

        // Using a method reference to the static add method
        Calculator addition2 = Operation::add;
        int result3 = addition2.calculate(5, 3);
        System.out.println("AdditionResult: " + result3); // Output: Addition result: 8

        // Using a method reference to the static substract method
        Calculator subtraction2 = Operation::subtract;
        int result4 = subtraction2.calculate(10, 4);
        System.out.println("SubstractionResult: " + result4); // Output: Addition result: 8        

    }
    
}
