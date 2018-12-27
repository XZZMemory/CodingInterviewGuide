package other.设计模式.装饰者模式;

public class PacketHTTPHeaderCreator  extends PacketDecorator{
    IPacketCreator compent;
    public PacketHTTPHeaderCreator(IPacketCreator compent)
    {
        super(compent);
    }
    @Override
    public String handleContent()//将给定数据封装成HTML格式
    {
        StringBuilder sb=new StringBuilder();
        sb.append("CacheController");
        sb.append(compent.handleContent());
        return sb.toString();
    }
}
