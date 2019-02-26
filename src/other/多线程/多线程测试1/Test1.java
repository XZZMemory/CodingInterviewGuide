package other.多线程.多线程测试1;

public class Test1 {
    public static void testThread() {
        for (int i = 0; i < 10; ++i) {
            //new MyThread(i).start();
        }

        for (int i = 0; i < 10; ++i) {
            final int tid = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 10; ++i) {
                            Thread.sleep(1000);
                            System.out.println(String.format("T2%d:%d", tid, i));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
