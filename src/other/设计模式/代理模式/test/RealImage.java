package other.设计模式.代理模式.test;

/**
 * created by memory
 * on 2018/12/28 下午3:22
 */
public class RealImage implements Image{
    private String fileName;
    public RealImage(String fileName)
    {
        this.fileName=fileName;
        loadFromDisk();
    }
    @Override
    public void display() {
        System.out.println(fileName+" display");
    }
    public void loadFromDisk()
    {
        System.out.println("loading from disk");
    }
}
