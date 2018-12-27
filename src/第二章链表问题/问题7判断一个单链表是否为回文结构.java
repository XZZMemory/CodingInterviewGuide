package 第二章链表问题;

import java.util.Stack;

/**
 * created by memory
 * on 2018/10/18 下午1:29
 */
public class 问题7判断一个单链表是否为回文结构 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,2,3,4,3,2,1});
        boolean isPalindromel2=isPalindromel(head);
    }
    //方法1利用栈将所有数据压入栈中，栈数据出来的顺序应该与链表顺序一致。时间复杂度O(N)，额外的空间O(N)
    public static boolean isPalindromel(Node head)
    {
        if(head==null||head.next==null)
            return true;
        Node p=head;
        Stack<Node> stack=new Stack<>();
        while (p!=null){
            stack.push(p);
            p=p.next;
        }
        p=head;
        while(!stack.isEmpty())
        {
            if (stack.pop().value!=p.value)
                return false;
            p=p.next;
        }
        return true;
    }
    //方法2，利用栈将链表右半or左半部分数据压入栈中，时间复杂度O(N),空间复杂度O(N/2),利用一个指针走得快，一个指针走得慢，慢的指针走到链表中间
    public static boolean isPalindromel2(Node head)
    {
        if (head==null||head.next==null)
            return true;
        Node slow=head;
        Node fast=head;
        while (fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        Stack<Node> stack=new Stack<>();
        while(slow!=null)
        {
            stack.push(slow);
            slow=slow.next;
        }
        fast=head;
        while (!stack.isEmpty())
        {
            if (stack.pop().value!=fast.value)
                return false;
            fast=fast.next;
        }
        return true;
    }
    /**
     *    方法3不需要栈和其他数据结构，只用有限几个变量，其额外空间度复杂度为O(1)，空间复杂度是O(N)
     *    首先将链表的右半部分反转进行判断
     *    判断完毕之后将右半部分链表反转，回复原有链表的形式
     */
    public static boolean isPalindromel3(Node head)
    {
        if (head==null||head.next==null)
            return true;
        Node n1=head;
        Node n2=head;
        while (n2.next!=null&&n2.next.next!=null)
        {
            n1=n1.next;
            n2=n2.next.next;
        }
        n2=n1.next;
        n1.next=null;
        Node n3=null;
        //n1就是中间节点
        while (n2!=null)
        {
            n3=n2.next;
            n2.next=n1;
            n1=n2;
            n2=n3;
        }//头结点是n1
        n2=head;
        n3=n1;
        while (n1!=n3)
        {
            if (n1.value!=n3.value) {
                //反转链表

                return false;
            }
            n1=n1.next;
            n2=n3.next;
        }
        //反转链表
        return true;
    }

}
