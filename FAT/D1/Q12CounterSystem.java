package D1;

class Counter {
    private int count = 0;

    // Synchronized method to increment and get counter value
    public synchronized void increment() {
        count += 2;
        System.out.println("Counter: " + count);
    }
}

class CounterIncrementer implements Runnable {
    private Counter counter;

    public CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(100); // Small delay for demonstration
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class Q12CounterSystem {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread incrementerThread = new Thread(new CounterIncrementer(counter));
        
        System.out.println("Starting counter incrementer thread...");
        incrementerThread.start();
        
        try {
            // Wait for the incrementer thread to finish
            incrementerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        System.out.println("Counter incrementing complete.");
    }
}