package other.多线程.Synchronized测试;

public class sy {


    private static Object obj = new Object();

    public static void testSynchronized1() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 10; ++i) {
                    Thread.sleep(1000);
                    System.out.println(String.format("T3%d", i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronized2() {
        synchronized (new Object()) {
            try {
                for (int i = 0; i < 10; ++i) {
                    Thread.sleep(1000);
                    System.out.println(String.format("T4%d", i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronized() {
        for (int i = 0; i < 10; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testSynchronized1();
                    testSynchronized2();
                }
            }).start();
        }
    }

}
