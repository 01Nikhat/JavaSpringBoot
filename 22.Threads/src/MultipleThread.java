/*
-------------------- THREADS IN JAVA --------------------

📌 What is a Thread?
- A thread is a lightweight sub-process.
- It is the smallest unit of execution in a program.
- Threads allow **parallel execution** of tasks.
- By default, every Java program runs with one thread → called the "main thread".

📌 Why do we use Threads?
- To perform multiple tasks simultaneously.
- To make programs faster and more efficient (e.g., downloading a file while playing music).

📌 Ways to create a Thread in Java:
1. Extending the Thread class
2. Implementing the Runnable interface

Here, we are using **extending Thread class**.

---------------------------------------------------------
*/

class A extends Thread { // Class A is a thread because it extends Thread
    /*
     🔹 run() method:
     - Every thread’s task must be written inside the run() method.
     - When we call start(), JVM internally calls run().
     - We NEVER call run() directly for thread execution (that will just act like a normal method).
    */
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi"); // Task for Thread A
        }
    }
}

class B extends Thread { // Another thread class
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello"); // Task for Thread B
        }
    }
}

public class MultipleThread {
    public static void main(String[] args) {
        /*
         🔹 Step 1: Create objects of thread classes
         - These are not threads yet, just objects.
        */
        A obj1 = new A();
        B obj2 = new B();

        /*
         🔹 Without threads:
         If we just call obj1.run() and obj2.run(),
         - First obj1 will complete fully,
         - Then obj2 will start.
         → This is sequential execution (not parallel).
        */
//        obj1.run();  // runs like a normal method (not multithreaded)
//        obj2.run();

        /*
         🔹 With threads:
         - When we call start():
              → A separate thread is created
              → JVM calls the run() method internally
         - Now obj1 and obj2 can run simultaneously.
        */
        obj1.start(); // Starts thread A (prints "Hi")
        obj2.start(); // Starts thread B (prints "Hello")

        /*
         🔹 Output:
         - "Hi" and "Hello" will appear mixed.
         - Why? Because JVM gives CPU time to both threads.
         - CPU switches rapidly between threads → looks parallel.
         - Actual order depends on OS thread scheduler, so output is unpredictable.
        */
    }
}

/*
-------------------- KEY POINTS --------------------
✅ Thread is created by extending Thread class or implementing Runnable.
✅ run() → contains task logic.
✅ start() → creates a new thread and calls run() internally.
✅ Execution order is decided by thread scheduler → not in our control.
✅ With threads, multiple tasks execute in parallel (multithreading).
*/
