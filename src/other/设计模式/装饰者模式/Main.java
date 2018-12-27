package other.设计模式.装饰者模式;

public class Main {
    public static void main(String[] args)
    {
        IPacketCreator iPacketCreator=new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(iPacketCreator.handleContent());
    }
}
