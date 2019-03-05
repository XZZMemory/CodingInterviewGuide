package other.并发包.同步辅助类.闭锁CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 只有三个程序都完成了，才算项目完成。
 * 实现原理：共享锁，主线程会等待共享锁可用时，才能获取共享锁继续执行，而共享锁可用的条件就是“锁计数器”为0
 */
public class CountDownLatchDemo {
    public static void main(String[] args)
    {
        CountDownLatch latch=new CountDownLatch(3);
        Worker worker1=new Worker("程序员1",latch);
        Worker worker2=new Worker("程序员2",latch);
        Worker worker3=new Worker("程序员3",latch);
        worker1.start();
        worker2.start();
        worker3.start();
        try {
            latch.await();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Main thread end");
    }
}
