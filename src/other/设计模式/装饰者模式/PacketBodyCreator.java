package other.设计模式.装饰者模式;

public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent() {
        return "content of Packet";
    }
}
