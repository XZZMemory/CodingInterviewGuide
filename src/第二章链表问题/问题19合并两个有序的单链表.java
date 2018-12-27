package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/23 下午9:04
 */

/**
 * 链表升序
 */
public class 问题19合并两个有序的单链表 {
    public static void main(String[] args)
    {
        Node head1=Node.creatLinkWithoutHead(new int[]{1,2,4,6});
        Node head2=Node.creatLinkWithoutHead(new int[]{3,4,5});
        Node head=merge(head1,head2);
    }
    public static Node merge(Node head1,Node head2)
    {
        if (head1==null||head2==null)
            return head1 ==null?head2:head1;
        Node head=head1.value>head2.value?head2:head1;
        Node pre=head;
        Node p1=head1.value>head2.value?head1:head1.next;
        Node p2=head1.value>head2.value?head2.next:head2;
        while (p1!=null&&p2!=null)
        {
            if (p1.value>p2.value)
            {
                pre.next=p2;
                p2=p2.next;
            }
            else //p1.value<=p2.value
            {
                pre.next=p1;
                p1=p1.next;
            }
            pre=pre.next;
        }
        if (p1!=null)
            pre.next=p1;
        if (p2!=null)
            pre.next=p2;
        return head;
    }
}
