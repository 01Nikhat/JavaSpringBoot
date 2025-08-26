package LambdaExpression;

// A functional interface (only 1 abstract method allowed)
// This is required for using Lambda Expressions
@FunctionalInterface
interface B {
    public int show(int i, int j); // Abstract method
}

// Traditional way: implementing the interface in a separate class
class C implements B {
    @Override
    public int show(int i, int j) {
        return i + j; // Adds two numbers
    }
}

public class LambdaExpressionWithReturn {
    public static void main(String[] args) {

        // --------- Traditional Method ---------
        // Create an object of class C (which implements interface B)
        B obj = new C();
        int show = obj.show(3, 5); // Calls show() method
        System.out.println("With traditional class implementation: " + show);


        // --------- Lambda Expression ---------
        // Instead of creating a separate class (like C),
        // we directly provide the implementation of the interface method using Lambda
        // (m, n) -> m + n means: take two parameters m and n, return m + n
        B obj2 = (m, n) -> m + n;

        // Now call the method
        int result = obj2.show(8, 9);
        System.out.println("With lambda expression result: " + result);


        // --------- Anonymous Inner Class (optional note) ---------
        // Before Lambda (Java 7 and below), if we wanted a one-time implementation,
        // we would use an anonymous inner class like this:
        B obj3 = new B() {
            @Override
            public int show(int i, int j) {
                return i * j; // Example: multiply instead of add
            }
        };
        System.out.println("With anonymous inner class (multiplication): " + obj3.show(4, 6));
    }
}
