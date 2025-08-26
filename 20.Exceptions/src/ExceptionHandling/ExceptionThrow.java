package ExceptionHandling;

public class ExceptionThrow {
    public static void main(String[] args) {
        int i = 0;   // If i is ZERO, division will cause ArithmeticException
        int j = 0;

        try {
            // ✅ Manual throw:
            // We are checking the condition explicitly.
            // Even though dividing by zero will automatically throw an ArithmeticException,
            // here we want to STOP execution earlier and throw our own CUSTOM message.
            if(i == 0){
                throw new ArithmeticException("We are not accepting i value as zero...");
            }

            // ✅ Automatic exception:
            // If the above 'if' condition is false, program comes here.
            // If i is 0, division 23/0 will AUTOMATICALLY throw ArithmeticException.
            j = 23 / i;
        }
        catch (ArithmeticException e) {
            // ✅ This block handles BOTH:
            // 1) Exception thrown automatically (23/0)
            // 2) Exception thrown manually (throw new ArithmeticException)
            System.out.println("Please enter some correct value.. " + e);
        }
        catch (Exception e) {
            // ✅ Generic catch block:
            // Handles ANY OTHER type of exception (like NullPointerException, etc.)
            System.out.println("Something went wrong. " + e);
        }

        // ✅ This block executes after try-catch if program didn't terminate
        // (because exception was handled successfully).
        System.out.println(j); // If exception occurred before assignment, j stays 0.
        System.out.println("Bye");
    }
}
