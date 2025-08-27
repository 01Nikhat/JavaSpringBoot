/*
Goal: Demonstrate how to FIX a race condition using `synchronized`.

👀 Background
- `count++` is NOT atomic. It is roughly:
   1) read `count`
   2) add 1
   3) write back
  When two threads do this at the same time on the same object, updates can be lost.

✅ Fix
- Wrap the critical section with `synchronized` so that ONLY ONE THREAD at a time can
  execute that section on the SAME OBJECT. This guarantees mutual exclusion + visibility.
*/

class Counter {
    int count; // shared mutable state (accessed by multiple threads)

    /*
     🔒 Method-level `synchronized`:
     - Locks on *this* (the current Counter instance) before entering the method.
     - Only one thread can hold this monitor at a time → others block until it's released.
     - Equivalent to:
          public void counting() {
              synchronized (this) {
                  count++;
              }
          }
     🧠 Memory semantics:
     - Entering the synchronized block: acquires the monitor → establishes a *happens-before* relationship with the
       next release; ensures visibility of prior writes done by the releasing thread.
     - Exiting the synchronized block: releases the monitor → flushes writes (e.g., updated `count`) to main memory.
    */
    public synchronized void counting() {
        count++; // critical section (now executed atomically with respect to other threads)
    }
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        // One shared Counter instance → both threads contend for the SAME lock (important!)
        // If you created TWO different Counter objects, each would have its own lock and
        // synchronization would NOT protect shared state (because it wouldn't be shared).
        Counter calc = new Counter();

        // Thread #1: increments 5 times
        Runnable obj1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    calc.counting(); // acquires calc's monitor, increments, releases
                }
            }
        };

        // Thread #2: increments 5 times (lambda)
        Runnable obj2 = () -> {
            for (int i = 0; i < 5; i++) {
                calc.counting(); // same lock (`calc`), so increments are serialized correctly
            }
        };

        Thread t1 = new Thread(obj1, "T1");
        Thread t2 = new Thread(obj2, "T2");

        // Start both threads → they run concurrently, but only one at a time enters counting()
        t1.start();
        t2.start();

        /*
         👇 Why join?
         - `join()` makes the main thread WAIT until the given thread finishes.
         - Ensures we print the result AFTER both threads are done incrementing.
         🧠 Memory semantics:
         - The completion of a thread *happens-before* a successful return from `join()` on that thread.
           This guarantees main will see the final value written by the worker threads.
        */
        t1.join();
        t2.join();

        // Deterministic result: 5 + 5 = 10, always (no lost updates).
        System.out.println(calc.count);

        /*
         📝 Notes / Alternatives:
         - Instead of `synchronized`, you can use:
              • java.util.concurrent.atomic.AtomicInteger (lock-free, very fast for simple increments)
              • ReentrantLock (more control: tryLock, fairness, interruptible locking)
         - If you make counting() `static synchronized`, the lock becomes the Class object (Counter.class),
           i.e., shared across ALL Counter instances.
         - Synchronization has a small overhead; for tiny loops it's negligible, for hot paths consider AtomicInteger.
        */
    }
}
