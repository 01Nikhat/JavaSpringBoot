package ExceptionHandling;

// Step 1: Create a custom exception by extending the Exception class
class MyOwnCustomeException extends Exception {
    // Constructor to pass the error message
    public MyOwnCustomeException(String str) {
        // Call parent Exception class constructor with message
        super(str);
    }
}

public class CustomeException {
    public static void main(String[] args) {
        int i = 0; // dividing number (divisor)
        int j = 0; // result variable

        try {
            // Step 2: Add a condition to check divisor (i)
            if (i == 0) {
                // Step 3: Throw custom exception if divisor is 0
                // Instead of letting ArithmeticException occur,
                // we forcefully throw our own exception with a custom message.
                throw new MyOwnCustomeException("Hey, you should try value above 0...");
            }

            // Step 4: If no exception, do the division
            j = 18 / i;

        } catch (MyOwnCustomeException e) {
            // Step 5: This block handles only our custom exception
            System.out.println("My custom Exception Handling: " + e.getMessage());

        } catch (Exception e) {
            // Step 6: This block handles any other unexpected exceptions
            System.out.println("Something went wrong: " + e);
        }

        // Step 7: Print final values, program continues even after exception handling
        System.out.println(j); // Will remain 0 because division never happened
        System.out.println("Bye"); // Proves program didn’t crash
    }
}
