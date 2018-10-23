package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/22 下午4:32
 */

import java.util.Stack;

/**
 * 给定一个单链表的头结点，实现一个调整单链表的函数，使得每K个节点之间逆序，如果最后不够K格节点一组，则不调整最后几个节点
 */
public class 问题12将单链表的每K个节点之间逆序 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,2,3,4,5});
        Node head2=reverseKNodes2(head,3);

    }
    //在原链表上直接调整 时间复杂度O(N),空间复杂度O(1)
    public static Node reverseKNodes(Node head,int k)
    {
        if (k<1||head==null||head.next==null)
            return head;
        Node cur=head;
        Node start=null;//旋转的部分链表的起始节点，旋转start-cur之间的链表，连接pre和next
        Node pre=null;
        Node next=null;
        int count=1;
        while (cur!=null)
        {
            next=cur.next;
            if (count==k)//旋转pre-next之间的链表，需要添加变量
            {
                start=pre==null?head:pre.next;
                head=pre==null?cur:head;
                resign2(pre,start,cur,next);
                pre=start;
                count=0;
            }
            cur=next;
            count++;
        }
        return head;
    }
    public static void resign2(Node left,Node start,Node end,Node right)
    {
        Node pre=start;
        Node cur=start.next;
        Node next=null;
        while (cur!=right)
        {
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        if (left!=null)
            left.next=end;
        start.next=right;
    }
    //方法2，利用栈，事假复杂O(N),空间复杂度O(K)
    public static Node reverseKNodes2(Node head,int k)
    {
        if (head==null||head.next==null||k<2)
            return head;
        Stack<Node> stack=new Stack<>();
        Node cur=head;
        Node pre=null;
        Node next=null;
        while (cur!=null)
        {
            next=cur.next;
            stack.push(cur);
            if (k==stack.size())
            {
                head=pre==null?cur:head;
                pre=resign1(stack,pre,next);
            }
            cur=next;

        }
        return head;
    }
    public static Node resign1(Stack<Node> stack,Node left, Node right)
    {
        Node cur=stack.pop();
        if (left!=null)
            left.next=cur;
        Node next=null;
        while (!stack.isEmpty())
        {
            next=stack.pop();
            cur.next=next;
            cur=next;
        }
        cur.next=right;
        return cur;
    }


}
