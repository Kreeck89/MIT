package lesson1.threads;

import java.io.*;

public class SeconTestMyThreads {
    static String path = "src/main/resources/Thread.txt";

    public static void main(String[] args) throws InterruptedException {

        SecondThread secondThread = new SecondThread();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                FirstThread firstThread = new FirstThread();
                firstThread.start();
                firstThread.join();
            }
        }
        secondThread.start();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int n = 0;
            while ((n = reader.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class FirstThread extends Thread {
        @Override
        public void run() {
            File file = new File(path);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write("Again write two users!" + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SecondThread extends Thread {
        @Override
        public void run() {
            System.out.println();
        }
    }

}
