import java.util.*;

public class SetsDemo {
    public static void main(String[] args) {

        // ------------------- Using Collection Reference --------------------
        // 'Collection' is the parent interface of all collection types (List, Set, Queue...).
        // Here we use Collection reference with HashSet object.
        // Advantage: Later we can replace HashSet with TreeSet or any other Set without changing the rest of code.
        Collection<Integer> nums = new HashSet<>();

        // HashSet does NOT allow duplicate values, and allows only one null.
        nums.add(2);
        nums.add(1);
        nums.add(4);
        nums.add(3);
        nums.add(1);    // duplicate, will be ignored
        nums.add(null); // HashSet allows null (only one)
        nums.add(8);
        nums.add(20);

        // HashSet does NOT maintain order → output is "unordered" (depends on hashing)
        System.out.println("Hashed Set Unordered  :"+nums);

        // ------------------- Using Collection with TreeSet --------------------
        // TreeSet is a sorted collection → elements stored in ascending order.
        // But TreeSet does NOT allow null, because it needs to compare elements for sorting.
        Collection<Integer> sortSet = new TreeSet<>();
        sortSet.add(2);
        sortSet.add(1);
        sortSet.add(4);
        sortSet.add(3);
        sortSet.add(1);   // duplicate ignored
        sortSet.add(8);
        // sortSet.add(null); // ERROR: null not allowed in TreeSet

        System.out.println("TreeSet Ordered :"+sortSet);


        /* ---------------------------- Using Set Reference ------------------------------ */
        // Now we use 'Set' instead of Collection.
        // 'Set' is a more specific interface (child of Collection), designed for unique elements only.
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(3);
        hashSet.add(1);   // duplicate ignored
        hashSet.add(null);// HashSet allows one null
        hashSet.add(8);
        hashSet.add(20);

        // Iterating HashSet → no indexing available (unlike ArrayList),
        // so we use Iterator to visit elements one by one.
        Iterator<Integer> values = hashSet.iterator();
        while (values.hasNext()){           // hasNext() → checks if more elements exist
            System.out.println(values.next()); // next() → returns next element
        }


        // ------------------- TreeSet with Iterator --------------------
        Set<Integer> TreeSet = new TreeSet<>();
        TreeSet.add(2);
        TreeSet.add(1);
        TreeSet.add(4);
        TreeSet.add(3);
        TreeSet.add(1);   // duplicate ignored
        // TreeSet.add(null); // ERROR: null not allowed (can't compare with numbers)
        TreeSet.add(8);
        TreeSet.add(20);

        // Iterating TreeSet → elements will always come in sorted order.
        Iterator<Integer> elements = TreeSet.iterator();
        while (elements.hasNext()){
            System.out.println(elements.next());
        }
    }
}
