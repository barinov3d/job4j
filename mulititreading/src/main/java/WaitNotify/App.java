package WaitNotify;

import java.util.Random;

/**
 * Created by Дмитрий on 24.10.2018.
 */
public class App {
    private static SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.offer(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(200);
            Integer value = queue.poll();
            System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
        }
    }
}