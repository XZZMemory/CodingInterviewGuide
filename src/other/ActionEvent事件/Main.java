package other.ActionEvent事件;

/**
 * created by memory
 * on 2019/2/18 下午6:57
 */
public class Main {
    public static void main(String[] args)
    {
        WindowActionEvent win=new WindowActionEvent();
        win.setBounds(100,100,310,260);
        win.setTitle("event");
        win.setListener(new HandlStringListen());
    }
}
