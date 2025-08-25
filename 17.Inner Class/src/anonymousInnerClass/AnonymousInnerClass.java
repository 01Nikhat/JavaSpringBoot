// ✅ Anonymous Inner Class in Java
// An "Anonymous Inner Class" is a class without a name.
// It is declared and instantiated in a single statement using `new`.
// We use it when:
//   1. We want to override a method of a class or interface.
//   2. The implementation is needed only once (so no need to create a full separate class).
//   3. Saves boilerplate code.

// -------------------- OUTER CLASS --------------------
package anonymousInnerClass;

class A {
    int number = 32;

    // Method that can be overridden
    public void show() {
        System.out.println("Inside A show() " + number);
    }

//    ✅ Example of normal inner class (commented):
//    class B extends A {
//        public void show() {
//            System.out.println("Inner class B");
//        }
//    }
}

// -------------------- MAIN CLASS --------------------
public class AnonymousInnerClass {
    public static void main(String[] args) {

        // 🔹 Creating an anonymous inner class here:
        // - We extend class A (without naming the new class).
        // - Override the show() method on the spot.
        // - This class exists ONLY for this object and cannot be reused.
        // instead of creating a new class and overriding the method only once it's better to use anonymous inner class
        A obj = new A() { //this is a inner class because it's inside the main class
            public void show() {
                System.out.println("Anonymous class runs only once");
            }
        };

        // Calling the overridden show() method
        obj.show();  // Output: Anonymous class runs only once

        // ⚡ If we used the normal class B (commented above):
        // A obj2 = new B();
        // obj2.show();  // Output: Inner class B

        // Difference:
        //   - Normal Inner Class (B) → can be reused, named, multiple objects possible.
        //   - Anonymous Inner Class → one-time use, no class name, short and quick.
    }
}

/*
⚡ WHY USE ANONYMOUS INNER CLASS?
1. For short one-time implementations → avoids writing extra classes.
2. Common in event handling (e.g., GUI, button clicks, listeners).
3. Common with interfaces → when you don’t want to implement the whole interface in a new file.

Example (interface):
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Thread running...");
    }
};
new Thread(r).start();

⚡ Summary:
- Normal Inner Class → reusable, has a name, can create multiple objects.
- Anonymous Inner Class → one-time, no name, defined at object creation.
*/
