package other.并发包.同步辅助类.栅栏CyclicBarrier;

public class TotalTask extends Thread {
    @Override
    public void run(){
        System.out.println("所有任务都执行完了，开始执行主线程");
    }
}
