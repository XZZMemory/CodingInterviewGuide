package other.并发包.同步辅助类.闭锁CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
    private String workName;
    private CountDownLatch latch;
    public Worker(String workName,CountDownLatch latch)
    {
        this.workName=workName;
        this.latch=latch;
    }
    @Override
    public void run()
    {
        try {
            System.out.println(workName+" is begin");
            Thread.sleep(1000l);
            System.out.println(workName+" is end");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        latch.countDown();
    }

}
