package other.设计模式.装饰者模式.装饰者模式1;

public class Main {
    public static void main(String[] args)
    {
        IPacketCreator iPacketCreator=new PacketHTTPHeaderDecorator(new PacketHTMLHeaderDecorator(new PacketBodyCreator()));
        System.out.println(iPacketCreator.handleContent());
    }
}
