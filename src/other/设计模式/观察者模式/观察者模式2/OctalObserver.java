package other.设计模式.观察者模式.观察者模式2;

/**
 * created by memory
 * on 2018/12/27 下午10:55
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
