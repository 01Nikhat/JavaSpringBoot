package enumClass;

// Enum is a special class in Java used to define constants (fixed set of objects)
enum Laptop {
    // Enum constants (objects)
    // Here we pass values to the constructor like normal objects
    MacBooc(50000), Hp(45000), Dell(39000), Lenovo;
    // Notice: Lenovo does not have a price mentioned,
    // so the default constructor will be called for it

    private int price; // instance variable for each enum constant

    // Default constructor (needed because Lenovo has no price passed)
    private Laptop() {
        price = 5000; // assigning default value
        // this.name() → gives the name of the enum constant as a String
        // Example: if the current object is Lenovo, it prints "Lenovo"
        System.out.println("Default Constructor called for " + this.name());
    }

    // Parameterized constructor (called when price is passed)
    private Laptop(int price) {
        this.price = price;
        // this.name() here will return MacBooc / Hp / Dell (whichever is being created)
        System.out.println("Parameterized constructor called for " + this.name());
    }

    // Setter method → allows us to change price of a Laptop
    public void setPrice(int price) {
        this.price = price;
    }

    // Getter method → returns price of Laptop
    public int getPrice() {
        return price;
    }
}

public class EnumClass {
    public static void main(String[] args) {
        // Laptop.values() → gives array of all enum constants (MacBooc, Hp, Dell, Lenovo)
        Laptop[] lapValues = Laptop.values();

        // Loop through all Laptop enum constants
        for (Laptop lap : lapValues) {
            // Printing name of constant and its price
            // lap.toString() prints the constant name (like MacBooc, Hp, etc.)
            // lap.getPrice() prints the price (either from constructor or default)
            System.out.println(lap + " : " + lap.getPrice());
        }
    }
}

/*
### Notes & Explanation:
1. Enum constants (MacBooc, Hp, Dell, Lenovo) are like objects created internally.
   - MacBooc → calls parameterized constructor with 50000
   - Hp → calls parameterized constructor with 45000
   - Dell → calls parameterized constructor with 39000
   - Lenovo → no value passed → calls default constructor with price = 5000

2. `this.name()`:
   - `this` refers to the current enum constant (like MacBooc or Lenovo).
   - `.name()` is a method from Enum class → returns the constant’s name as String.

   Example:
   - For MacBooc → this.name() returns "MacBooc"
   - For Lenovo → this.name() returns "Lenovo"

3. Constructor calls:
   - When you first run the program, enum constants are initialized first.
   - So you will see constructor messages printed before the loop.

4. Loop (main method):
   - After initialization, we fetch all constants with `Laptop.values()`.
   - Print each constant with its assigned price.

### Output Example:
Parameterized constructor called for MacBooc
Parameterized constructor called for Hp
Parameterized constructor called for Dell
Default Constructor called for Lenovo
MacBooc : 50000
Hp : 45000
Dell : 39000
Lenovo : 5000
*/
