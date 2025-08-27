package ExceptionHandling;


// Ducking Exception means:
// If a method does not handle the exception itself (using try-catch),
// it declares the exception in its method signature using 'throws' keyword.
// This way, it passes ("ducks") the responsibility of handling the exception
// to the calling method (propagation).

public class DuckingExceptionExample {

    // Step 1: Create a method that might throw an exception
    // Instead of handling it here, we declare it with 'throws'
    // This means: "I am not handling ArithmeticException here,
    // whoever calls me must handle it".
    static int divide(int a, int b) throws ArithmeticException {
        return a / b;  // may throw ArithmeticException if b = 0
    }

    // Step 2: Another method that calls divide()
    // It doesn't handle the exception either, so it also "ducks" the exception
    static void calculate() throws ArithmeticException {
        System.out.println("Result is: " + divide(10, 0));
    }

    // Step 3: main() is the caller method
    // Now we must handle the exception here (otherwise the program will crash)
    public static void main(String[] args) {
        try {
            calculate(); // calling the method that "ducked" the exception
        } catch (ArithmeticException e) {
            System.out.println("Exception handled in main(): " + e);
        }

        System.out.println("Program continues after handling exception...");
    }
}
