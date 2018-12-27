package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/18 上午11:08
 */
public class 问题5反转部分单向链表 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,2,3,4,5});
        Node reverseHead=reversePart(head,2,4);
    }
    public static Node reversePart(Node head,int from,int to)
    {
        Node p=head;
        int length=0;
        Node fPre=null;
        Node tPos=null;
        while (p!=null)
        {
            length++;
            fPre=length==from-1?p:fPre;
            tPos=length==to+1?p:tPos;
            p=p.next;
        }
        if (from<0||to>length||from>to)
            return head;
        p=fPre==null?head:fPre.next;
        Node q=p.next;
        p.next=tPos;
        Node next=null;
        while (q!=tPos)
        {
            next=q.next;
            q.next=p;
            p=q;
            q=next;
        }
        fPre.next=p;
        return head;

    }
}
