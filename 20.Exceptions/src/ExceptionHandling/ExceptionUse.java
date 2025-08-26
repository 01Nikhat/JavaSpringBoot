package ExceptionHandling;

/*
 * ---------------------- WHY DO WE NEED EXCEPTION HANDLING? ----------------------
 * In programming, errors can occur at different stages.
 * If we don’t handle them properly, our program will crash.
 * Exception handling provides a way to handle runtime errors gracefully
 * (without breaking the entire program).
 *
 * ---------------------- TYPES OF ERRORS ----------------------
 * 1. Logical Error:
 *    - These are mistakes in the logic of the program.
 *    - The code runs fine (no compiler/runtime error), but the output is not what we expect.
 *    Example: int result = 2 * 3;  // If we wanted addition, but wrote multiplication by mistake
 *
 * 2. Compile-time Error:
 *    - Errors that occur while writing the code (before running).
 *    - These are detected by the compiler.
 *    Example: Missing semicolon, using undeclared variable.
 *
 * 3. Runtime Error:
 *    - Errors that occur while the program is running.
 *    - They are often caused by "Exceptions".
 *    Example: Dividing by zero, accessing an invalid array index, null pointer access.
 *
 * ---------------------- WHAT IS AN EXCEPTION? ----------------------
 * - Exception is an unwanted event that disrupts the normal flow of a program.
 * - Example: Trying to divide by zero -> ArithmeticException.
 *
 * ---------------------- HANDLING EXCEPTIONS ----------------------
 * 1. try-catch block:
 *    - Code that may cause exception is written inside 'try'.
 *    - 'catch' handles the exception if it occurs.
 *
 * 2. throw:
 *    - Used to manually throw an exception.
 *
 * 3. throws:
 *    - Used in method declaration to specify which exceptions a method may throw.
 *
 * With exception handling, instead of crashing, the program can display a meaningful
 * message or take alternate action.
 */

public class ExceptionUse {
    public static void main(String[] args) {

        System.out.println("Program started...");

        // Example of normal execution
        System.out.println("2 + 2 = " + (2 + 2)); // Correct logic → Output = 4

        // Example of Runtime Exception
        try {
            int result = 10 / 0;  // This will throw ArithmeticException (divide by zero)
            System.out.println("Result = " + result); // This will not run if exception occurs
        } catch (ArithmeticException e) {
            System.out.println("⚠️ Exception caught: Cannot divide by zero!");
        }

        // Program continues normally after handling exception
        System.out.println("Program ended without crashing ✅");
    }
}
