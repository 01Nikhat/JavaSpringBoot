package ExceptionHandling;



/*
 * =========================
 *   Error vs Exception
 * =========================
 * In Java, both Error and Exception classes extend the "Throwable" class.
 * Throwable itself extends the Object class.
 *
 * Throwable
 *    |
 *    |--> Error        (represents serious problems - cannot be handled by program)
 *    |
 *    |--> Exception    (represents issues that can be handled inside the program)
 *
 * --------------------------------------------------------
 *                Error
 * --------------------------------------------------------
 * Errors usually indicate serious problems beyond the control of the programmer.
 * They cannot be handled through try-catch.
 * Examples:
 *   1. ThreadDeath
 *   2. VirtualMachineError (e.g., OutOfMemoryError, StackOverflowError)
 *   3. IOError
 *
 * --------------------------------------------------------
 *                Exception
 * --------------------------------------------------------
 * Exceptions indicate problems that can be handled using exception handling (try-catch, throw, throws).
 * Exceptions are divided into 2 types:
 *
 * 1. Unchecked Exceptions (Runtime Exception)
 *    - These occur at runtime and compiler does not force you to handle them.
 *    - Examples:
 *        a) ArithmeticException (e.g., divide by zero)
 *        b) ArrayIndexOutOfBoundsException
 *        c) NullPointerException
 *    - It is optional to handle them.
 *
 * 2. Checked Exceptions
 *    - These must be either handled with try-catch or declared using 'throws'.
 *    - Compiler checks these during compilation.
 *    - Examples:
 *        a) SQLException
 *        b) IOException
 *    - It is mandatory to handle them.
 *
 * --------------------------------------------------------
 * Why we use Exception Handling?
 * --------------------------------------------------------
 * 1. To prevent abnormal termination of the program.
 * 2. To provide a way to deal with unexpected situations at runtime.
 * 3. To maintain normal flow of the application even when an error occurs.
 * 4. To separate error-handling code from normal business logic.
 *
 * Techniques used:
 * - try-catch block
 * - throw (used to throw an exception object explicitly)
 * - throws (used in method signature to declare exceptions)
 * - finally (always executes regardless of exception)
 */

public class ExceptionHierarchy {
    public static void main(String[] args) {
        System.out.println("Program Started...");

        // Example of Runtime Exception (Unchecked)
        try {
            int result = 10 / 0; // ArithmeticException: divide by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Handled ArithmeticException: " + e.getMessage());
        }

        // Example of NullPointerException
        try {
            String str = null;
            System.out.println(str.length()); // will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException: " + e.getMessage());
        }

        // Example of ArrayIndexOutOfBoundsException
        try {
            int arr[] = {1, 2, 3};
            System.out.println(arr[5]); // accessing invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        System.out.println("Program Ended Normally...");
    }
}
