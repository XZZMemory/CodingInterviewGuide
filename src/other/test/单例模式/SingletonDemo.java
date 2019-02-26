package other.test.单例模式;

public class SingletonDemo {
    public static void main(String[] args)
    {
        //不合法的构造函数，编译时会出错
//    Singleton singleton=new Singleton();


        for (int i = 0; i <1000 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton=Singleton.getInstance();
                    System.out.println(singleton);
                }
            }).start();

        }
    }
}