package other.并发包.同步辅助类.栅栏CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class BillTask extends Thread{
    private String billName;
    private CyclicBarrier barrier;
    public BillTask(String workName,CyclicBarrier barrier)
    {
        this.billName=workName;
        this.barrier=barrier;
    }
    @Override
    public void run()
    {
        try {
            System.out.println("市区"+billName+"运算开始");
            Thread.sleep(1000l);
            System.out.println("市区"+billName+"运算完成，等待中。。。");
            barrier.await();
            System.out.println("全部结束"+billName+"才开始时后面的运算");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
