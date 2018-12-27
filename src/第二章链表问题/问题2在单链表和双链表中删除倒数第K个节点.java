package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/17 下午3:06
 */
public class 问题2在单链表和双链表中删除倒数第K个节点 {
    public static void main(String[] args)
    {
        Node head1=Node.creatLinkWithoutHead(new int[]{1,2,3,4,5});
        Node head1DeletedKthNode=removeLastKthNode(head1.next,1);
        Node head2=Node.creatLinkWithHead(new int[]{1,2,3,4});
        Node head2DeletedKthNode=removeLastKthNode2(head1,1);
        DoubleNode headDoubleNode=DoubleNode.creatDoubleLinkWithoutHead(new int[]{1,2,3});
        DoubleNode headDoubleNodeDeleted=removeLastKthDoubleNode(headDoubleNode,3);
    }
    //剑指Offer上的方法,处理带头结点的链表
    public static Node removeLastKthNode2(Node head,int lastKth) {
        if (head == null || lastKth < 0)
            return head;
        Node curNode = head.next;
        while (curNode != null && lastKth >0) {
            curNode = curNode.next;
            lastKth--;
        }
        if (lastKth > 0)
        {
            System.out.println("链表节点个数不足");
            return head;
        }
        else {
            Node pre=head;
            Node p=pre.next;
            while (curNode!=null)
            {
                p=p.next;
                pre=pre.next;
                curNode=curNode.next;
            }
            if (p.next==null)
                pre.next=null;
            else
                pre.next=p.next;
        }
        return head;
    }
    //这本书上的方法，处理不带头节点的链表
    public static Node removeLastKthNode(Node head,int lastKth)
    {
        if (head==null||lastKth<1)
            return head;
        Node curNode=head;//链表是带头结点的链表
        while (curNode!=null){
            curNode=curNode.next;
            lastKth--;
        }
        if (lastKth==0)
            head=head.next;
         else if(lastKth<0){
            curNode=head;
            while(++lastKth!=0)
                curNode=curNode.next;
            curNode.next=curNode.next.next;
         }
        return head;

    }
    //创建的是带头节点的链表

    public static DoubleNode removeLastKthDoubleNode(DoubleNode head,int lastKth)
    {
        if (head==null||lastKth<1)
            return head;
        DoubleNode p=head;
        while (p!=null)
        {
            p=p.next;
            lastKth--;
        }
        if(lastKth==0) {
            head = head.next;
            head.last=null;
        }
        else if (lastKth<0)
        {
            DoubleNode curDoubleNode=head;
            lastKth++;
            while (lastKth!=0)
            {
                curDoubleNode=curDoubleNode.next;
                lastKth++;
            }
            DoubleNode doubleNodeDeleted=curDoubleNode.next;
            if (doubleNodeDeleted.next!=null) {
                curDoubleNode.next = doubleNodeDeleted.next;
                doubleNodeDeleted.next.last = curDoubleNode;
            }
            else
            {
                curDoubleNode.next=null;
            }
        }
        return head;
    }
}
