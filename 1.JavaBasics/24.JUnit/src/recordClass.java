import java.util.Objects;

class Human {
    // ✅ Instance variables (private final)
    // Making them final means they cannot be modified once set (immutability-like behavior)
    private final int age;
    private final String name;

    // ✅ Constructor (needed to initialize final fields)
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // ✅ Getters to access private fields
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    // ✅ Custom toString() method
    // Without this, printing the object would give something like: Human@15db9742
    // Now, it shows object data in a readable format
    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    // ✅ Custom equals() method
    // By default, equals() checks memory reference (different objects → false)
    // We override it to compare values (age and name)
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name);
    }

    // ✅ Custom hashCode() method
    // Ensures that objects with same data have the same hashCode (important for HashSet, HashMap, etc.)
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}

/* ------------------------------------------------------
   🔹 Using record (introduced in Java 14, stable in Java 16)
   ------------------------------------------------------
   ➝ Record is a special type of class for immutable data
   ➝ It automatically generates:
      - private final fields
      - constructor
      - getters (called accessors in record)
      - toString()
      - equals()
      - hashCode()
   ➝ Much less boilerplate code
*/
record Humans(int age, String name) {

    // ✅ Compact Canonical Constructor
    // This allows adding extra validation logic
    // e.g., here we restrict age to not be zero
    public Humans {
        if (age == 0) {
            throw new IllegalArgumentException("Age cannot be zero..");
        }
    }
}


public class recordClass {
    public static void main(String[] args) {
        // ------------------- Normal Class --------------------
        Human user1 = new Human(24,"Nikhat");
        // Printing the object → uses overridden toString()
        System.out.println(user1);
        // Output: Human{age=24, name='Nikhat'}

        Human user2 = new Human(24,"Nikhat");

        // Checking equality → uses overridden equals()
        System.out.println(user1.equals(user2));
        // Output: true (because values are same, even if objects are stored in different memory)

        // ------------------- Record Class --------------------
        Humans human1 = new Humans(10,"Naureen");
        Humans human2 = new Humans(10,"Naureen");

        // Automatically generated toString()
        System.out.println(human1); // Output: Humans[age=10, name=Naureen]
        System.out.println(human2); // Output: Humans[age=10, name=Naureen]

        // Automatically generated equals()
        System.out.println(human1.equals(human2)); // true

        // This will throw an exception because of our custom constructor rule
        Humans human3 = new Humans(0,"naaz");
        System.out.println(human3);
    }
}
