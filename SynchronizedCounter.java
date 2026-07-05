public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedCounter counter = new SynchronizedCounter();
        final int iterations = 100000;

        // Thread to increment
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < iterations; i++) {
                    counter.increment();
                }
            }
        });

        // Thread to decrement
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < iterations; i++) {
                    counter.decrement();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter value: " + counter.value());
    }
}
