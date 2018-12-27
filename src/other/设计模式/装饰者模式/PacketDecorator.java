package other.设计模式.装饰者模式;

public class PacketDecorator implements IPacketCreator {
    IPacketCreator compent;
    public PacketDecorator(IPacketCreator compent)
    {
        this.compent=compent;
    }
    @Override
    public String handleContent() {
        return null;
    }
}
