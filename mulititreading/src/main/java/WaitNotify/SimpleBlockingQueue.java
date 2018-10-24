package WaitNotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Дмитрий on 24.10.2018.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    private final int LIMIT;

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public SimpleBlockingQueue(int limit) {
        LIMIT = limit;
    }

    public synchronized void offer(T value) throws InterruptedException {
        while (size() == LIMIT) {
            wait();
        }
        queue.offer(value);
        notify();
    }


    public synchronized T poll() throws InterruptedException {
        while (size() == 0) {
            wait();
        }
        T result = queue.poll();
        notify();
        return result;
    }


    public synchronized int size() {
        return queue.size();
    }
}