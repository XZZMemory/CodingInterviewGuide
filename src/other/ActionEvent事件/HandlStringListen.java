package other.ActionEvent事件;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * created by memory
 * on 2019/2/18 下午7:10
 */
public class HandlStringListen implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        System.out.println(str+"的长度是："+str.length());
    }
}
