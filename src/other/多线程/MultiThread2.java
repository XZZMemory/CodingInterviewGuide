package other.多线程;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nowcoder on 2016/7/23.
 */

class MyThread extends Thread {
    private int tid;
    public MyThread(int tid) {
        this.tid = tid;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; ++i) {
                Thread.sleep(1000);
                System.out.println(String.format("T%d:%d", tid, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class MultiThread2{
    private static int counter = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void sleep(int mills) {
        try {
         //Thread.sleep(new Random().nextInt(mills));
            Thread.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testWithAtomic() {
        for (int i = 0; i < 10; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sleep(1000);
                    for (int j = 0; j < 10; ++j) {
                        System.out.println(atomicInteger.incrementAndGet());
                    }
                }
            }).start();
        }
    }

    public static void testWithoutAtomic() {
        for (int i = 0; i < 10; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sleep(1000);
                    for (int j = 0; j < 10; ++j) {
                        counter++;
                        System.out.println(counter);
                    }
                }
            }).start();
        }
    }

    public static void testAtomic() {
        testWithAtomic();
        testWithoutAtomic();
    }

    private static ThreadLocal<Integer> threadLocalUserIds = new ThreadLocal<>();
    private static int userId;

    public static void testThreadLocal() {
        for (int i = 0; i < 10; ++i) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocalUserIds.set(finalI);
                    sleep(1000);
                    System.out.println("ThreadLocal: " + threadLocalUserIds.get());
                }
            }).start();
        }

        for (int i = 0; i < 10; ++i) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userId = finalI;
                    sleep(1000);
                    System.out.println("NonThreadLocal: " + userId);
                }
            }).start();
        }
    }

    public static void testExecutor() {
        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    sleep(1000);
                    System.out.println("Execute1 " + i);
                }
            }
        });

        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    sleep(1000);
                    System.out.println("Execute2 " + i);
                }
            }
        });

        service.shutdown();
        while (!service.isTerminated()) {
            sleep(1000);
            System.out.println("Wait for termination.");
        }
    }

    public static void testFutrue() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                sleep(1000);
                return 1;
                //throw new IllegalArgumentException("异常");
            }
        });

        service.shutdown();

        try {
            //System.out.println(future.get());
            System.out.println(future.get(100, TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //testThread();
        //testSynchronized();
        //testBlockingQueue();
        //testAtomic();
        testThreadLocal();
        //testExecutor();
        //testFutrue();
    }
}
