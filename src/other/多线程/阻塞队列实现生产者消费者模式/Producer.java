package other.多线程.阻塞队列实现生产者消费者模式;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue<String> q;
    public Producer(BlockingQueue<String> q) {
        this.q = q;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; ++i) {
                Thread.sleep(10);
                q.put(String.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
