package 第二章链表问题.问题4翻转单向链表和双向链表;

import 第二章链表问题.DoubleNode;

/**
 * created by memory
 * on 2018/10/18 上午10:55
 */
public class 反转双向链表 {
    public static void main(String[] args)
    {
        DoubleNode head=DoubleNode.creatDoubleLinkWithoutHead(new int[]{1,2,3,4});
        DoubleNode.traversalOfLinkWithoutHead(head);
        DoubleNode headDelete=reverseDoubleLink(head);
        DoubleNode.traversalOfLinkWithoutHead(headDelete);
    }
    public static DoubleNode reverseDoubleLink(DoubleNode head)
    {
        DoubleNode pre=null;
        DoubleNode next=null;
        while (head!=null)
        {
            next=head.next;
            head.next=pre;
            if (pre!=null)
                pre.last=head;
            pre=head;
            head=next;
        }
        return pre;
    }
}
