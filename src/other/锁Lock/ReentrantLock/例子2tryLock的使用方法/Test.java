package other.锁Lock.ReentrantLock.例子2tryLock的使用方法;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 博客地址：http://www.cnblogs.com/dolphin0520/p/3923167.html
 */

/**
 * ReentrantLock，意思是“可重入锁”，ReentrantLock是唯一实现了Lock接口的类
 */
public class Test {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方
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
        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName()+"得到了锁");
                for(int i=0;i<5;i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }
}
