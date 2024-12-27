import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Lab3ReentrantLock {
    static int counter = 0;
    ReentrantLock locker = new ReentrantLock();

    public Lab3ReentrantLock() {
    }

    public void run() {
        int[] num_threads = {1, 2, 4, 8};

        for(int i : num_threads) {
            long startTime = System.nanoTime();
            run2(i, i);
            long execTime = System.nanoTime() - startTime;

            try (FileWriter writer = new FileWriter("Lab3.txt", true)) {
                writer.write("Lab3 ReentrantLock results:\nSystem info:\n");
                Runtime runtime = Runtime.getRuntime();
                String os = System.getProperty("os.name");
                int cpuCores = runtime.availableProcessors();
                long freeMemory = runtime.freeMemory();
                long totalMemory = runtime.totalMemory();
                writer.write(String.format(
                        "OS name: %s\nCpu: %d\nFree memory: %d\nTotal memory: %d\n",
                        os,
                        cpuCores,
                        freeMemory,
                        totalMemory
                ));
                writer.write(String.format("\nThreads: increment %d, decrement %d\n", i, i));
                writer.write(String.format("Final counter value: %d\n", counter));
                writer.write(String.format("Execution time: %d seconds\n\n", execTime));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void run2(int m, int n) {
        ArrayList<Thread> threads = new ArrayList<>();

        for(int i=0;i<n;i++) {
            Thread thread = new Thread(this::increment);
            threads.add(thread);
            thread.start();
        }

        for(int i=0;i<m;i++) {
            Thread thread = new Thread(this::decrement);
            threads.add(thread);
            thread.start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void increment() {
        locker.lock();
        try {
            for(int i=0;i<100000; i++) {
                counter++;
            }
        } finally {
            locker.unlock();
        }
    }

    public void decrement() {
        locker.lock();
        try {
            for(int i=0;i<100000; i++) {
                counter--;
            }
        } finally {
            locker.unlock();
        }
    }
}
