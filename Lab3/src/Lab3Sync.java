import java.util.ArrayList;
import java.util.Scanner;

public class Lab3Sync {
    static int counter = 0;

    Lab3Sync() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int m, n;
        ArrayList<Thread> threads = new ArrayList<>();
        System.out.println("Введите количество инкрементирующих потоков: ");
        n = scanner.nextInt();
        System.out.println("Введите количество декрементирующих потоков: ");
        m = scanner.nextInt();

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

        System.out.println(counter);
    }

    public synchronized void increment() {
        for(int i=0;i<100000; i++) {
            counter++;
        }
    }

    public synchronized void decrement() {
        for(int i=0;i<100000; i++) {
            counter--;
        }
    }
}
