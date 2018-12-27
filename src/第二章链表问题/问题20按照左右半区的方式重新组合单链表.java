package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/23 下午9:10
 */

/**
 * 原链表：list:L1->L2->...->R1->R2->...
 * 调整后：list:L1->R1->L2->R2->...
 */
public class 问题20按照左右半区的方式重新组合单链表 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,7,8});
        relocate(head);
    }
    public static void relocate(Node head)
    {
        if (head==null||head.next==null||head.next.next==null)
            return ;
        Node left=head;
        Node right=head.next;
        while (right.next!=null&&right.next.next!=null)
        {
            left=left.next;
            right=right.next.next;
        }
        right=left.next;
        left.next=null;
        left=head;
        Node rightNext=null;
        Node leftNext=null;
        while (left.next!=null)
        {
            rightNext=right.next;
            leftNext=left.next;
            left.next=right;
            right.next=leftNext;
            left=leftNext;
            right=rightNext;
        }
        left.next=right;
    }
}
