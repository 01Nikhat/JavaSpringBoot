import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo<I extends Number> {
    public static void main(String[] args) {
        /*
         🔹 COLLECTION INTERFACE
         - `Collection<E>` is the root interface for all collection types in Java (except Maps).
         - It defines generic operations such as:
             • add(), remove(), size(), contains(), isEmpty(), clear(), etc.
         - It does NOT provide index-based operations (no get(i), set(i)).
         - It's good when you only care about a *bag* of elements, not order/position.

         Here: Using Collection<Integer> reference for an ArrayList.
         */
        Collection<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(7);
        nums.add(2);
        nums.add(8);

        System.out.println("nums size :" + nums.size());           // prints number of elements
        System.out.println("is nums contain 8 :" + nums.contains(8)); // true if 8 is present
        System.out.println("nums array :" + nums);                 // ArrayList has a nice toString() that prints elements

        /*
         🔹 LIST INTERFACE
         - `List<E>` extends `Collection<E>`.
         - Provides *ordered* collection with index-based access:
             • get(index), set(index, value), add(index, value), remove(index), subList(), etc.
         - Implementations: ArrayList, LinkedList, Vector, CopyOnWriteArrayList, etc.
         - Maintains insertion order.

         Here: Using List<Integer> reference to hold an ArrayList object.
         */
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(9);
        list.add(1);
        list.add(89);
        list.add(21);

        // get element at index 2 (0-based indexing → gives 1)
        System.out.println("at index 2 contain :" + list.get(2));

        // indexOf searches for element, returns its index → 89 is at index 3
        System.out.println("89 contain index of :" + list.indexOf(89));

        /*
         ⚡ Newer Java Feature (Java 21+): `list.reversed()`
         - Returns an unmodifiable view of the list in reversed order.
         - Does not actually reverse the list internally.
         */
        System.out.println("reverse list :" + list.reversed());

        // Prints the list in normal order → [3, 9, 1, 89, 21]
        System.out.println("list :" + list);

        /*
         🔹 Iterating over list
         Two ways are shown:
        */

        // Enhanced for-loop with type-safe int → no casting required
        for (int n : list) {
            System.out.println(n);
        }

        // Using Object reference (polymorphism, but loses type safety)
        // Here we need to downcast back to Integer
        for (Object m : list) {
            int num = (Integer) m;  // Explicit cast back to Integer
            System.out.println(num);
        }

        /*
         ⚖️ Collection vs List (Summary):
         - Collection:
              • General interface for groups of objects (e.g., Set, Queue, List all extend it).
              • No indexing, unordered (depends on implementation).
              • Basic methods: add, remove, contains, size.
         - List:
              • Ordered collection, preserves insertion order.
              • Allows duplicates.
              • Supports index-based access and searching.
              • Extra methods: get(), set(), add(index, element), remove(index), subList().
         */
    }
}
