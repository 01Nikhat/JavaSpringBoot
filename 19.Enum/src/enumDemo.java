// Enum in Java is used to represent a group of named constants (fixed values).
// Example: Days of the week (MONDAY, TUESDAY,...), Status (SUCCESS, FAILED,...)
// It makes code more readable, type-safe, and avoids using magic numbers or strings.

enum Status {
    Running,   // constant → represents "Running" state
    Failed,    // constant → represents "Failed" state
    Success,   // constant → represents "Success" state
    Pending    // constant → represents "Pending" state
}

public class enumDemo {
    public static void main(String[] args) {
        // Assigning an enum value
        Status s = Status.Success;  // s refers to "Success"
        Status m = Status.Failed;   // m refers to "Failed"
        Status n = Status.Pending;  // n refers to "Pending"
        Status p = Status.Running;  // p refers to "Running"

        // Printing an enum variable directly shows its name
        System.out.println(s); // Output: Success

        // ordinal() → returns the position(index) of the constant in the enum declaration
        // Index starts from 0 → Running=0, Failed=1, Success=2, Pending=3
        System.out.println(s.ordinal()); // Output: 2

        // values() → returns an array of all enum constants in the order they are declared
        Status[] val = Status.values();

        // Looping through all enum constants
        for (Status enumVal : val) {
            // Print constant name
            System.out.println(enumVal);

            // Print constant name with its ordinal (index)
            System.out.println(enumVal + " : " + enumVal.ordinal());
        }
    }
}
