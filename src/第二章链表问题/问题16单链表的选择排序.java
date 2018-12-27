package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/23 下午7:21
 */
public class 问题16单链表的选择排序 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{3,2,4,5,4});
        Node headSorted=getSmallestPreNode(head);
    }
    public static Node getSmallestPreNode(Node head)
    {
        //head存储的是有序链表的最小值，pre存储的是有序链表的最大值
        Node pre=head;
        Node cur=head.next;
        Node next=null;
        while (cur!=null)
        {
            next=cur.next;
            if (head.value>cur.value)//head->...->pre->cur->next
            {
                cur.next=head;
                head=cur;
                pre.next=next;
            }
            else if (pre.value>cur.value)
            {
                Node precur=head;
                Node curcur=precur.next;
                while (curcur!=pre)
                {
                    if (curcur.value>=cur.value)
                    {
                        precur.next=cur;
                        cur.next=curcur;
                        break;
                    }
                    precur=curcur;
                    curcur=curcur.next;
                }
                pre.next=next;
            }
            else
                pre=cur;
            cur=next;
        }
        return head;
    }
}
