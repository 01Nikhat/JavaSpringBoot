package interfaceWithoutAbstract;

// ✅ Interface 1: Computer
// - In Java, an interface is like a contract/blueprint.
// - By default:
//    • variables → public static final (constants)
//    • methods   → public abstract (no body, just definition)
//  Multiple Inheritance – Java doesn’t support multiple inheritance with classes,
//  but you can implement multiple interfaces.
//   A class can extend only one abstract class
interface Computer {
    String device();  // abstract method → any implementing class must define it
}

// ✅ Interface 2: OwnerOfDevice
// - An interface can also declare other responsibilities.
// - A class can implement multiple interfaces (unlike abstract classes).
interface OwnerOfDevice {
    String getOwnerName();
}

// ------------------- Implementation Classes -------------------

// ✅ Laptop class implements Computer
// - Must provide its own definition of device()
class Laptop implements Computer {
    @Override
    public String device() {
        return "Laptop"; // returns device type
    }
}

// ✅ Desktop implements TWO interfaces: Computer + OwnerOfDevice
// - This is an example of multiple inheritance (allowed via interfaces in Java).
class Desktop implements Computer, OwnerOfDevice {
    @Override
    public String device() {
        return "Desktop"; // returns device type
    }

    @Override
    public String getOwnerName() {
        return "Nikhat"; // returns owner's name
    }
}

// ------------------- Developer Class -------------------

// ✅ Developer is dependent only on interfaces (not on specific classes).
// - This allows "loose coupling" → Developer doesn’t care whether it’s Laptop/ Desktop.
// - As long as the object implements Computer & OwnerOfDevice, it can be passed in.
class Developer {
    public void code(Computer obj, OwnerOfDevice obj2) {
        // obj.device()  → comes from Computer
        // obj2.getOwnerName() → comes from OwnerOfDevice
        System.out.println("Hey " + obj2.getOwnerName() +
                " , To start code " + obj.device() + " is required");
    }
}

// ------------------- Main Class -------------------

public class Interface {
    public static void main(String[] args) {
        // ❌ Cannot create object of an interface directly
        // Computer obj3 = new Computer(); // ERROR

        // ✅ Create objects of classes implementing interface
        Computer lap = new Laptop();     // Laptop implements Computer
        Computer desk = new Desktop();   // Desktop implements Computer
        OwnerOfDevice owner = new Desktop(); // Same Desktop object can be referred by different interface type

        // ✅ Developer object
        Developer obj = new Developer();

        // Passing interface references
        // obj.code(lap, owner);  // ❌ Not valid because Laptop doesn't implement OwnerOfDevice
        obj.code(desk, owner);   // ✅ Works because Desktop implements both
    }
}
