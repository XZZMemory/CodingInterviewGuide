package other.锁Lock.ReentrantLock.正确的Lock使用;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方，声明lock是一个公共的锁
    public static void main(String[] args)  {
        final Test test = new Test();

        for (int i = 0; i <4 ; i++) {
            new Thread(){
                public void run() {
                    test.insert(Thread.currentThread());
                };
            }.start();
        }
}

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁。");
            lock.unlock();
            System.out.println();
        }
    }
}
/*
输出结果：
*Thread-1得到了锁
Thread-1释放了锁
Thread-0得到了锁
Thread-0释放了锁
Thread-3得到了锁
Thread-3释放了锁
Thread-2得到了锁
Thread-2释放了锁
正确的结果
 */
