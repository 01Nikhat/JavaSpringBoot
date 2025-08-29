import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {

        /*
         * -------------------- HASHMAP --------------------
         * - Part of java.util package.
         * - Stores key-value pairs (like a dictionary).
         * - Keys are unique → if you insert duplicate key,
         *   the new value will replace the old value.
         * - Allows one null key and multiple null values.
         * - Not synchronized → faster, but not thread-safe.
         * - Order of keys is not guaranteed (no fixed order).
         */
        Map<String,Integer> students = new HashMap<>();

        // Adding entries (key = student name, value = marks)
        students.put("Navin",56);
        students.put("Harsh",23);
        students.put("Sushil",67);
        students.put("Kiran",92);

        // Duplicate key → "Harsh" already exists
        // So this will replace Harsh's old value (23) with 45
        students.put("Harsh",45);

        // Print all keys (unordered because HashMap doesn’t preserve order)
        System.out.println("HashMap Keys: " + students.keySet());

        // Loop through all key-value pairs
        for(String key : students.keySet()) {
            System.out.println(key + " : " + students.get(key));
        }



        /*
         * -------------------- HASHTABLE --------------------
         * - Older class (before HashMap, from legacy collections).
         * - Also stores key-value pairs.
         * - Keys are unique, duplicate key replaces the old value.
         * - Does NOT allow null keys or null values (will throw NullPointerException).
         * - Synchronized → thread-safe, but slower than HashMap.
         * - Like HashMap, order is not guaranteed.
         */
        Map<String,Integer> student = new Hashtable<>();

        // Adding entries
        student.put("Navin",56);
        student.put("Harsh",23);
        student.put("Sushil",67);
        student.put("Kiran",92);

        // Duplicate key → "Harsh" gets updated to 45
        student.put("Harsh",45);

        // Print all keys
        System.out.println("Hashtable Keys: " + student.keySet());

        // Loop through all key-value pairs
        for(String key : student.keySet()) {
            System.out.println(key + " : " + student.get(key));
        }
    }
}
