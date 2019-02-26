package other.多线程.阻塞队列实现生产者消费者模式;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlockingQueue {
    public static void main(String[] args)
    {
        testBlockingQueue();
    }
    public static void testBlockingQueue() {
        BlockingQueue<String> q = new ArrayBlockingQueue<String>(10);
        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q), "Consumer1").start();
        new Thread(new Consumer(q), "Consumer2").start();
    }
}
