package other.ActionEvent事件;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * created by memory
 * on 2019/2/18 下午6:58
 */
public class WindowActionEvent extends JFrame {
    JTextField text;
    public WindowActionEvent()
    {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init()
    {
        setLayout(new FlowLayout());
        text=new JTextField(10);
        add(text);
    }
    public void setListener(ActionListener listener)
    {
        text.addActionListener(listener);
    }
}
