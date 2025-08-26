package LambdaExpression;

/*
 * Lambda Expressions in Java
 * --------------------------
 * 1. Introduced in Java 8.
 * 2. Work only with Functional Interfaces (interfaces that have exactly ONE abstract method).
 * 3. Provide a clean and concise way to implement methods on the spot (shorter than anonymous inner class).
 * 4. Syntax:
 *      (parameters) -> { body }
 *
 * Benefits:
 * - Less boilerplate code
 * - Improves readability
 * - Commonly used in Streams, Collections, and Functional Programming.
 */

interface A {
    void show(); // Single abstract method → makes it a Functional Interface
}

// Normal way (before Java 8) → create a separate class
//class B implements A {
//    @Override
//    public void show() {
//        System.out.println("in B CLASS");
//    }
//}

public class LambdaExpressionDemo {
    public static void main(String[] args) {

        /*
         * ✅ Option 1: Traditional way (Separate Class)
         * --------------------------------------------
         * We create class B that implements A and override show().
         * Advantage → Can reuse B object many times.
         * Disadvantage → Extra boilerplate (extra class, more lines of code).
         */
//        A obj = new B();
//        obj.show();

        /*
         * ✅ Option 2: Anonymous Inner Class
         * ----------------------------------
         * Instead of making a separate class (B),
         * we directly create an object of interface A using an inner class.
         * This is shorter but still requires writing class-like syntax.
         */
        A obj1 = new A() {
            @Override
            public void show() {
                System.out.println("Anonymous Inner Class: Implementation of show() created on the spot!");
            }
        };
        obj1.show();

        /*
         * ✅ Option 3: Lambda Expression (Java 8+)
         * ----------------------------------------
         * Simplest way when interface has ONLY ONE abstract method.
         * No need to mention method name, class name, or even return keyword
         * (if it's a single statement).
         *
         * () -> System.out.println("...");
         * ^   ^                         ^
         * |   |                         |
         * |   |                         body of the method (what it should do)
         * |   parameters (empty here because show() takes no arguments)
         *
         */
        A obj = () -> System.out.println("Lambda Expression: Cleanest implementation of show()");
        obj.show();
    }
}
