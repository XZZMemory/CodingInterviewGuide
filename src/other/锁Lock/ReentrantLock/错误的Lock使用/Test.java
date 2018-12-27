package other.锁Lock.ReentrantLock.错误的Lock使用;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
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
        Lock lock = new ReentrantLock();    //注意这个地方,lock是一个本地变量
        lock.lock();
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
    }
}
/*
*输出结果：
Thread-0得到了锁
Thread-0释放了锁
Thread-3得到了锁
Thread-1得到了锁
Thread-2得到了锁
Thread-1释放了锁
Thread-3释放了锁
Thread-2释放了锁
怎么会输出这个结果？第二个线程怎么会在第一个线程释放锁之前得到了锁？
原因在于，在insert方法中的lock变量是局部变量，每个线程执行该方法时都会保存一个副本，
那么理所当然每个线程执行到lock.lock()处获取的是不同的锁，所以就不会发生冲突。
 */
