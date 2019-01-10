package other.锁Lock.ReentrantReadWriteLock.普通的方法;

/**
 * 　　假如有多个线程要同时进行读操作的话，先看一下synchronized达到的效果：
 *   　　而改成用读写锁的话，看例子package other.锁Lock.ReentrantReadWriteLock.使用读写锁.CloneDemo
 */
public class Test {
    public static void main(String[] args)  {
        final Test test = new Test();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName()+"正在进行读操作");
        }
        System.out.println(thread.getName()+"读操作完毕");
    }
}
/*
这段程序的输出结果会是，直到thread1执行完读操作之后，才会打印thread2执行读操作的信息。
*/
