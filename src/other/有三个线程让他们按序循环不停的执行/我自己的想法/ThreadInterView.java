package other.有三个线程让他们按序循环不停的执行.我自己的想法;

/**
 * created by memory
 * on 2019/1/10 下午7:42
 */
public class ThreadInterView {
    public static void main(String[] args)
    {
        Thread1 thread1=new Thread1();
        Thread2 thread2=new Thread2();
        Thread3 thread3=new Thread3();

        while (true)
        {
            thread1.start();
            try {
            thread1.join();
            }catch (Exception e){
                System.out.println("线程1111111111不能阻塞主线程");
            }
            thread2.start();
            try {
                thread2.join();
            }catch (Exception e){
                System.out.println("线程22222222222不能阻塞主线程");
            }
            thread3.start();
            try {
                thread3.join();
            }catch (Exception e){
                System.out.println("线程333333333333不能阻塞主线程");
            }
        }
    }
}
class  Thread1 extends Thread {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程11111111111");
        }
    }
}
    class  Thread2 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程22222222222");
            }        }
}
class  Thread3 extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3333333333");
        }    }
}
