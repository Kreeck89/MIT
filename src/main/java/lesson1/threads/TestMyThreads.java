package lesson1.threads;

public class TestMyThreads {

    public static void main(String[] args) throws InterruptedException {
        MyThread1 thread1 = new MyThread1();
        Thread thread2 = new Thread(new MyThread2());

        thread1.start();
        Thread.sleep(5000);
        thread1.interrupt();
        thread2.start();
    }

    private static class MyThread1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread break");
                    return;
                }
            }
        }
    }

    private static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
