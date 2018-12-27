package 第二章链表问题;

import java.util.Stack;

/**
 * created by memory
 * on 2018/10/21 下午2:49
 */
//链表 9->3->7 代表937，链表6->3代表 63，则两个链表相加生成的联表示1->0->0->0
public class 问题10两个单链表生成相加链表 {
    public static void main(String[] args)
    {
        Node head1=Node.creatLinkWithoutHead(new int[]{9,3,7});
        Node head2=Node.creatLinkWithoutHead(new int[]{});
        Node head=addList2(head1,head2);
    }
    //方法一，利用栈，将两个链表的元素均进栈，从而实现链表倒序操作
    public static Node addList1(Node head1,Node head2)
    {
        if (head1==null)
            return head2;
        if (head2==null)
            return head1;
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        Node p1=head1;
        Node p2=head2;
        while (p1!=null) {
            stack1.push(p1.value);
            p1 = p1.next;
        }
        while (p2!=null)
        {
            stack2.push(p2.value);
            p2=p2.next;
        }
        int ca=0;//ca进位
        int data1=0;
        int data2=0;
        int data=0;
        Node node=null;
        Node pre=null;
        while (!stack1.isEmpty()||!stack2.isEmpty())
        {
            data1=stack1.isEmpty()?0:stack1.pop();
            data2=stack2.isEmpty()?0:stack2.pop();
            data=data1+data2+ca;
            pre=node;
            node=new Node(data%10);
            node.next=pre;
            ca=data/10;
        }
        if (ca==1)
        {
            pre=node;
            node=new Node(1);
            node.next=pre;
        }
        return node;
    }
    //方法二利用链表的逆序求解，可以省掉用栈的空间
    public static Node addList2(Node head1,Node head2)
    {
        if (head1==null)
            return head2;
        if (head2==null)
            return head1;
        Node head1Reverse=reverseList(head1);
        Node head2Reverse=reverseList(head2);
        Node p1=head1Reverse;
        Node p2=head2Reverse;
        Node pre=null;
        Node cur=null;
        int ca=0;//进位
        int data1=0;
        int data2=0;
        int data=0;
        while(p1!=null||p2!=null)
        {
            data1=p1==null?0:p1.value;
            data2=p2==null?0:p2.value;
            data=data1+data2+ca;
            cur=new Node(data%10);
            ca=data/10;
            cur.next=pre;
            pre=cur;
            p1=p1==null?null:p1.next;
            p2=p2==null?null:p2.next;
        }
        if (ca==1)
        {
            cur=new Node(1);
            cur.next=pre;
            pre=cur;
        }
        head1=reverseList(head1Reverse);
        head2=reverseList(head2Reverse);
        return pre;
    }
    public static Node reverseList(Node head)
    {
        if (head==null||head.next==null)
            return head;
        Node cur=head;
        Node pre=null;
        Node next=null;
        while (cur!=null)
        {
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
