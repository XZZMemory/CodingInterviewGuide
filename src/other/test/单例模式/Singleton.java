package other.test.单例模式;
//保证程序只有一个实例，并且能全部访问到
public class Singleton {
    public static volatile Singleton instance=null;
    private Singleton()//构造函数
    { }

    //双重校验锁
    public static Singleton getInstance()
    {
        if (instance==null)
        {
            synchronized (Singleton.class)
            {
                if (instance==null)
                    instance=new Singleton();
            }
        }
        return instance;
    }
}
