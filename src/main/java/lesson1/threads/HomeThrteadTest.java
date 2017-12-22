package lesson1.threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HomeThrteadTest {

    static AtomicInteger i = new AtomicInteger(0);
    static volatile int j = 0;
    static int l = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(HomeThrteadTest::printString);
        Thread thread2 = new Thread(HomeThrteadTest::printString);
        thread1.start();
        thread2.start();

//        for (int k = 0; k < 10000; k++) {
//            Thread thread1 = new Thread(HomeThrteadTest::incrementInt);
//            Thread thread2 = new Thread(HomeThrteadTest::volotileInt);
//            Thread thread3 = new Thread(HomeThrteadTest::incrementAtomic);
//            thread2.start();
//            thread1.start();
//            thread3.start();
//        }
//        System.out.println(l);
//        System.out.println(j);
//        System.out.println(i.get());
//
    }

    private static void incrementAtomic() {
        i.incrementAndGet();
    }

    private static void volotileInt() {
        j++;
    }

    private static void incrementInt() {
        l++;
    }

    private static void printString() {
        System.out.println("Enter too class:");
        lock.lock();
            for (int v = 0; v < 10; v++) {
                System.out.println("String for example " + v);
        }
        lock.unlock();
    }
}
