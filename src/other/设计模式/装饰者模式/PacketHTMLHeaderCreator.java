package other.设计模式.装饰者模式;

public class PacketHTMLHeaderCreator extends PacketDecorator {
    public PacketHTMLHeaderCreator(IPacketCreator compent) {
        super(compent);
    }
    @Override
    public String handleContent()//将给定数据封装成HTML格式
    {
        StringBuilder sb=new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(compent.handleContent());//把内容一步步加上的
        sb.append("</html>");
        sb.append("</body>");
        return sb.toString();
    }
}
