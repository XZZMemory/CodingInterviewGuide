package other.设计模式.装饰者模式.装饰者模式1;

public class PacketHTTPHeaderDecorator extends PacketDecorator {
    IPacketCreator compent;
    public PacketHTTPHeaderDecorator(IPacketCreator compent)
    {
        super(compent);
    }
    @Override
    public String handleContent()//将给定数据封装成HTML格式
    {
        StringBuilder sb=new StringBuilder();
        sb.append("header ");
        if (super.compent==null)
            return"http:内容为空";
        sb.append(super.compent.handleContent());
        return sb.toString();
    }
}
