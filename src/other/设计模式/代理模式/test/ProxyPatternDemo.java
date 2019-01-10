package other.设计模式.代理模式.test;

/**
 * created by memory
 * on 2018/12/28 下午3:32
 */
public class ProxyPatternDemo {
    public static void main(String[] args)
    {
        Image image=new RealImage("12");
        //图像将从磁盘加载
        image.display();
        //图像不从磁盘加载
        image.display();
    }
}
