package functionalInterface;

/*
 * Functional Interface:
 * ---------------------
 * 1. A Functional Interface is an interface that has ONLY ONE abstract method.
 * 2. It can have multiple default or static methods (with body), but only one abstract method.
 * 3. Functional Interfaces are used heavily in Lambda Expressions and Streams.
 * 4. Example: Runnable, Comparable, Comparator, etc.
 */

interface A {
    // Only one abstract method → makes it a functional interface
    void show();

    // If you uncomment this run() method, then A will have TWO abstract methods,
    // so it will no longer be a Functional Interface
    // void run();
}

/*
// Option 1: Implement using a normal class
class B implements A {
    public void show() {
        System.out.println("in Show");
    }
}
*/

public class FunctionalInterface {
    public static void main(String[] args) {

        /*
         * Option 2: Anonymous Inner Class
         * --------------------------------
         * Instead of creating a separate class (like B),
         * we directly create an object of A using an anonymous inner class.
         * This provides implementation of the abstract method on the spot.
         */
        A obj = new A() {
            public void show() {
                System.out.println("in Show (Anonymous Inner Class)");
            }
        };

        /*
         * Now obj is an object of A,
         * but behind the scenes, Java creates an anonymous class that implements A.
         */
        obj.show();  // calls the implementation of show()


        /*
         * Option 3 (Best with Functional Interfaces): Lambda Expression
         * -------------------------------------------------------------
         * Since A is a Functional Interface (only 1 abstract method),
         * we can use a Lambda Expression instead of writing anonymous inner class.
         */
        A obj2 = () -> System.out.println("in Show (Lambda Expression)");
        obj2.show();
    }
}
