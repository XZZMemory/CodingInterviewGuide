package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/22 上午10:57
 */

/**
 * 在本题中，单链表可能有环，也可能无环，给定两个单链表的头结点head1和head2，这两个链表有可能相交，也有可能不相交
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点，如果不相交，则返回null
 * 要求：如果链表长度为N和M，要求时间复杂福达到O(N+M)，空间复杂度达到O(1)
 */
public class 问题11两个单链表相交的一系列问题 {
    public static void main(String[] args)
    {
//带头节点的链表两个带环的链表相交
        Node head=creatCircleLinkWithHead(new int[]{11,10,19});
        Node head1=creatCircleLinkWithHead(new int[]{1,2,3,4});
        //Node result1=getInsertNode(head,head1);
        Node head2=creatCircleLinkWithHeadImitation(new int[]{5,6,7,8},head1);
        //Node result2=getInsertNode(head1,head2);
        Node head3=Node.creatLinkWithHead(new int[]{7,8,9,10});
        Node head4=Node.creatLinkWithHead(new int[]{1,2,3});
        //Node result3=getInsertNode(head3,head4);
        Node head5=creatLinkWithHeadImitation(new int[]{4,5},head4);
        Node p= getInsertNode(head4,head5);
    }
    public static Node getInsertNode(Node head1,Node head2)
    {
        if (head1==null||head2==null)
            return null;
        Node loop1=getloopNode(head1);
        Node loop2=getloopNode(head2);
        if (loop1==null&&loop2==null)//两个链表均是无环节点
        {
            return noLoop(head1,head2);
        }
        else if (loop1!=null&&loop2!=null)
        {
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }
    //链表带头结点，判断链表是否有环，返回第一个进入环的节点，无环则返回空
    public static Node getloopNode(Node head)
    {
        if (head==null||head.next==null||head.next.next==null)
            return null;
        Node slow=head.next;
        Node fast=head.next.next;
        while (fast.next!=null&&fast.next.next!=null&&slow!=fast)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        if (fast.next==null||fast.next.next==null)
            return null;
        //slow=fast
        fast=head;
        while (slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    //两个链表均是有环链表，判断两个链表是否相交
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2)
    {
        if (loop1==loop2)
        {
            Node p1=head1.next;
            Node p2=head2.next;
            int len1=1;
            int len2=1;
            while (p1.next!=loop1)
            {
                p1=p1.next;
                len1++;
            }
            while (p2.next!=loop2)
            {
                p2=p2.next;
                len2++;
            }
            if (len1>len2)
            {
                p2=head2.next;
                p1=head1.next;
                while (p1!=null&&len1!=len2)
                {
                    p1=p1.next;
                    len1--;
                }
            }
            else if (len1<len2)
            {
                p1=head1.next;
                p2=head2.next;
                while (p2!=null&&len1!=len2)
                {
                    p2=p2.next;
                    len2--;
                }
            }
            while (p1!=loop1&&p2!=loop2)
            {
                if (p1==p2)
                    return p1;
                p1=p1.next;
                p2=p2.next;
            }
            return loop1;
        }
        return null;
    }
    //两个链表均是无环节点，判断两个链表是否相交
    public static Node noLoop(Node head1,Node head2)
    {
        Node p1=head1.next;
        Node p2=head2.next;
        int len1=1;
        int len2=1;
        while (p1.next!=null)
        {
            p1=p1.next;
            len1++;
        }
        while (p2.next!=null)
        {
            p2=p2.next;
            len2++;
        }
        if (p1!=p2)//两个链表的最后一个节点不相等，说明两链表不相交
            return null;
        if (len1>len2)
        {
            p2=head2.next;
            p1=head1.next;
            while (p1!=null&&len1!=len2)
            {
                p1=p1.next;
                len1--;
            }
        }
        else if (len1<len2)
        {
            p1=head1.next;
            p2=head2.next;
            while (p2!=null&&len1!=len2)
            {
                p2=p2.next;
                len2--;
            }
        }
        while (p1!=null&&p2!=null)
        {
            if (p1==p2)
                return p1;
            p1=p1.next;
            p2=p2.next;
        }
        return null;
    }
    public static Node creatCircleLinkWithHead(int[] data)
    {
        if (data==null||data.length==0)
            return  null;
        Node head=new Node(0);
        Node pre=head;
        Node middle=new Node(0);
        for (int i=0;i<data.length;i++)
        {
            Node p=new Node(data[i]);
            if (i==data.length/2)
                middle=p;
            pre.next=p;
            pre=pre.next;
        }
        pre.next=middle;
        return head;
    }
    public static Node creatCircleLinkWithHeadImitation(int[] data,Node head1)
    {
        Node head=new Node(0);
        Node pre=head;
        for (int i=0;i<data.length;i++)
        {
            Node p=new Node(data[i]);
            pre.next=p;
            pre=pre.next;
        }
        pre.next=getloopNode(head1);
        return head;
    }
    public static Node creatLinkWithHeadImitation(int[] data1,Node head1)
    {
        if (data1==null)
             return null;
        Node head=new Node(0);
        Node pre=head;
        for (int i=0;i<data1.length;i++)
        {
            Node p=new Node(data1[i]);
            pre.next=p;pre=pre.next;
        }
        if (head1.next.next!=null)
            pre.next=head1.next.next;
        return head;
    }
}
