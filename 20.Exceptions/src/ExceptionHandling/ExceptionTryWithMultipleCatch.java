package ExceptionHandling;

public class ExceptionTryWithMultipleCatch {
    public static void main(String[] args) {
        int i = 0;
        int j = 6;
        int result;
        String str = null;
        int[] arr = new int[5];

        // NOTE: If any line inside try block throws an exception,
        // the remaining lines in the try block will NOT be executed.
        try {
            // ❌ This will throw ArithmeticException if j = 0
            result = i / j;
            // ❌ This will throw ArrayIndexOutOfBoundsException
            // because array has indexes 0 to 4 only, but we are accessing index 5
            System.out.println(arr[5]);
            // ❌ This will throw NullPointerException
            // because str is null and we are calling length() on it
            System.out.println(str.length());

        }
        // First specific catch: Handles division by zero
        catch (ArithmeticException e) {
            System.out.println("I cannot be divided by 0... " + e);
        }
        // Second specific catch: Handles array index out of bounds
        catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Array index is out of bound... " + a);
        }
        // General catch: This will catch any other exceptions (like NullPointerException)
        catch (Exception e) {
            System.out.println("Something went wrong... " + e);
        }
        // finally block: Always runs whether an exception occurs or not
        // Used for cleanup activities like closing DB connections, files, etc.
        finally {
            System.out.println("Either code goes to try or catch, finally must run in both cases.");
        }
    }
}
