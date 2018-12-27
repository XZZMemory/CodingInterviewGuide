package other.设计模式.装饰者模式.装饰者模式1;

public class PacketHTMLHeaderDecorator extends PacketDecorator {
    public PacketHTMLHeaderDecorator(IPacketCreator compent) {
        super(compent);
    }
    @Override
    public String handleContent()//将给定数据封装成HTML格式
    {
        StringBuilder sb=new StringBuilder();
        sb.append("html ");
        sb.append(compent.handleContent());//把内容一步步加上的
        return sb.toString();
    }
}
