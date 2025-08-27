// Example of Multithreading with Priority, Sleep, and Exception Handling

// Thread class C
class C extends Thread {
    @Override
    public void run() {
        // Loop will print "Hello" 100 times
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");

            try {
                // Makes the current thread sleep for 10 milliseconds
                // Allows other threads to execute
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                // If thread is interrupted during sleep
                throw new RuntimeException(e);
            }
            catch (RuntimeException e) {
                // Custom catch block for runtime exceptions
                System.out.println("Runtime Exception...");
            }
        }
    }
}

// Thread class D
class D extends Thread {
    @Override
    public void run() {
        // Loop will print "HI" 100 times
        for (int i = 0; i < 100; i++) {
            System.out.println("HI");

            try {
                // Makes the current thread sleep for 10 milliseconds
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        // Create thread objects
        C obj1 = new C();
        D obj2 = new D();

        // Setting priority for obj2 (D thread)
        // MAX_PRIORITY = 10 (highest)
        obj2.setPriority(Thread.MAX_PRIORITY);

        // Start thread obj1 (C thread)
        obj1.start();

        try {
            // Makes the current thread (main) sleep for 2 ms
            // ⚠️ Note: obj1.sleep(2) is same as Thread.sleep(2)
            // It does NOT make obj1 sleep, it pauses the currently running thread
            obj1.sleep(2);
        }
        catch (InterruptedException e) {
            System.out.println("Something went wrong " + e);
        }

        // Start thread obj2 (D thread)
        obj2.start();

        // Output:
        // Both "Hello" and "HI" will be printed, order depends on CPU scheduling.
        // Thread with higher priority (obj2) MAY get more CPU time.
    }
}
