public class Main {
    public static void main(String[] args) {
        System.out.println("Вариация программы без синхронизации:");
        Lab3NoSync lab3NoSync = new Lab3NoSync();
        lab3NoSync.run();
        System.out.println("Вариация программы c синхронизации:");
        Lab3Sync lab3Sync = new Lab3Sync();
        lab3Sync.run();
        System.out.println("Вариация программы c ReentrantLock:");
        Lab3ReentrantLock lab3ReentrantLock = new Lab3ReentrantLock();
        lab3ReentrantLock.run();
    }
}