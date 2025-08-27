// Example: Different ways of creating and running Threads in Java

// -----------------------------------------------
// 1st Way: Extending Thread class
// -----------------------------------------------
class M extends Thread {
    @Override
    public void run() {
        // This will run in a separate thread
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}

class N extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}

// -----------------------------------------------
// 2nd Way: Implementing Runnable Interface
// -----------------------------------------------
class P implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Don't");
        }
    }
}

class Q implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Giveup");
        }
    }
}

// -----------------------------------------------
// MAIN CLASS
// -----------------------------------------------
public class RunnableAndThrowable {
    public static void main(String[] args) {
        // ===========================
        // OPTION 1: Extending Thread
        // ===========================
        M obj1 = new M();  // Thread object 1
        N obj2 = new N();  // Thread object 2

        // start() → internally calls run() method in a new thread
        obj1.start();

        try {
            // Thread.sleep(2) pauses current thread (main thread in this case)
            // ⚠️ obj1.sleep(2) is misleading → it's not making obj1 sleep, but current thread
            obj1.sleep(2);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        obj2.start(); // start second thread

        // Output: "Hello" and "Hi" will be printed concurrently (order not guaranteed)

        // ===========================
        // OPTION 2: Runnable Interface
        // ===========================
        Runnable obj3 = new P();
        Runnable obj4 = new Q();

        // When using Runnable, we must pass it to a Thread object
        Thread t1 = new Thread(obj3);
        Thread t2 = new Thread(obj4);

        // Start the threads
        t1.start();
        t2.start();

        // Output: "Don't" and "Giveup" printed concurrently

        // ===========================
        // OPTION 3: Using Anonymous Class / Lambda
        // ===========================
        // Instead of creating separate classes, we create Runnable objects directly

        Runnable obj5 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("hey");
                    try {
                        Thread.sleep(10); // sleep for smooth output
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable obj6 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("nikki");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t3 = new Thread(obj5);
        Thread t4 = new Thread(obj6);

        t3.start();
        t4.start();

        // Output: "hey" and "nikki" will run together
        // Advantage: No need to create separate classes, concise code
    }
}
