package 第二章链表问题.问题4翻转单向链表和双向链表;

import 第二章链表问题.Node;

/**
 * created by memory
 * on 2018/10/18 上午10:34
 */
public class 反转单向链表 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,2,3,4});
        Node headReverse=reverseList(head);
    }
    public static Node reverseList(Node head)
    {
        Node pre=null;
        Node next=null;
        while (head!=null)
        {
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
