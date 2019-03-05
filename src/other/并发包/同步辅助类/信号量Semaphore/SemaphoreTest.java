package other.并发包.同步辅助类.信号量Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args)
    {
        ExecutorService exec= Executors.newCachedThreadPool();
        //只能5个线程同时访问
        final Semaphore semp=new Semaphore(5);
        //模拟20个客户端访问
        for (int index = 0; index <20 ; index++) {
            final int NO=index;
            Runnable run=new Runnable() {
                @Override
                public void run() {
                    try {
                        semp.acquire();//获取许可
                        System.out.println("Accessing: "+NO);
                        Thread.sleep((long)(Math.random()*10000));
                        semp.release();//访问完后，释放资源
                    }catch (Exception e){}
                }
            };
            exec.execute(run);
            exec.shutdown();//退出线程池
        }
    }
}
