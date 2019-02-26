package other.多线程.阻塞队列实现生产者消费者模式;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private BlockingQueue<String> q;
    public Consumer(BlockingQueue<String> q) {
        this.q = q;
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + q.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}