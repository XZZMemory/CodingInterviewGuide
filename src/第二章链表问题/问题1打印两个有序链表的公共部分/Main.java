package 第二章链表问题.问题1打印两个有序链表的公共部分;

import 第二章链表问题.Node;

/**
 * created by memory
 * on 2018/10/17 下午2:40
 */
public class Main {
    public static void main(String[] args)
    {
        Node head1=creatLinkList(new int[]{1,2,3,5,8,9,10});
        Node head2=creatLinkList(new int[]{});
        printCommonPart(head1.next,head2.next);
    }
    public static void printCommonPart(Node head1,Node head2)
    {
        if (head1==null||head2==null)
            return;
        Node p1=head1;
        Node p2=head2;
        while (p1!=null&&p2!=null)
        {
            if (p1.value<p2.value)
                p1=p1.next;
            else if (p1.value>p2.value)
                p2=p2.next;
            else //p1.value=p2.value
            {
                System.out.print(p1.value+" ");
                p1=p1.next;
                p2=p2.next;
            }
        }
    }
    //创建带头节点的链表
    public static Node creatLinkList(int[] data) {
        Node head = new Node(0);
        Node p = head;//head;
        for (int i = 0; i < data.length; i++) {
            Node q = new Node(data[i]);
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }
}
