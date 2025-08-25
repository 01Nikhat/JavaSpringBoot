// ✅ Inner Classes in Java
// Inner classes are classes defined inside another class.
// They are mainly used for:
// 1. Logical grouping → keep related classes together.
// 2. Encapsulation → hide helper classes from outside code.
// 3. Easier access to outer class members.

class A {
    int number = 32;

    // A normal method of outer class A
    public void show() {
        System.out.println("Inside A show()");
    }

    // -------------------- INNER CLASS --------------------
    // Here B is an inner class inside A.
    // Types of inner classes:
    //   1. Non-static inner class (regular inner class)
    //   2. Static nested class (like this one)
    //
    // Difference:
    //   - Non-static inner class needs an object of the outer class to be created.
    //   - Static inner class does NOT need an outer object.
    //
    static class B {
        // Method of inner class
        public void config() {
            System.out.println("Inside Inner class B");
        }
    }
}
// Outer class A ends here.


// -------------------- MAIN CLASS --------------------
public class InnerClass {
    public static void main(String[] args) {
        // 1️⃣ Create object of outer class A
        A obj = new A();
        obj.show(); // call outer class method

        // 2️⃣ Create object of inner class B (static)
        // Since B is static, we don’t need an instance of A to create B.
        A.B obj1 = new A.B();
        obj1.config();

        // ⚡ If B was NOT static:
        // We would have to create it like this:
        // A.B obj2 = obj.new B();
        // obj2.config();
    }
}
