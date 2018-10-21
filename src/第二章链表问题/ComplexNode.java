package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/21 上午10:39
 */
public class ComplexNode {
    public int value;
    public ComplexNode next;
    public ComplexNode random;
    public ComplexNode(int data)
    {
        this.value=data;
    }
    public static ComplexNode creatList()
    {
        ComplexNode a=new ComplexNode(1);
        ComplexNode b=new ComplexNode(2);
        ComplexNode c=new ComplexNode(3);
        a.next=b;
        b.next=c;
        c.next=null;
        a.random=c;
        b.random=null;
        c.random=a;
        return a;
    }
}
