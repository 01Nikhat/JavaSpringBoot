package abstractAnonymous;

// Abstract class (cannot be instantiated directly)
abstract class A
{
    // Abstract methods → must be implemented by any subclass
    public abstract void show();
    public abstract void config();
}

/*
 Example 1 (commented out):

 If we create a normal concrete class (B) extending A,
 we must implement all abstract methods of A.

 class B extends A
 {
     public void show() {
         System.out.println("in B show");
     }

     public void config() {
         System.out.println("in B config");
     }
 }
*/

public class AbstractAnonymous {

    public static void main(String[] args) {

//     Case 1 (using normal concrete class):
//     A obj = new B();  // Allowed if class B is defined as above
//     obj.show();
//     obj.config();

        // Case 2 (using Anonymous Inner Class):
        // Instead of creating a separate concrete class (B),
        // we create an "anonymous class" that directly provides
        // the implementation of abstract methods inside main().
        A obj = new A()
        {
            // Implementing abstract method show()
            public void show()
            {
                System.out.println("in new show");
            }

            // Implementing abstract method config()
            public void config() {
                System.out.println("iN A CONFIG MEthod");
            }
        };

        // Calls overridden method from anonymous inner class
        obj.show();
        obj.config();
    }
}
