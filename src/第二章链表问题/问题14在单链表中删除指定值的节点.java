package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/23 下午5:05
 */

import java.util.Stack;

/**
 * 给定一个链表的头结点head和一个整数num，请实现函数将值为num的节点全部删除
 */
public class 问题14在单链表中删除指定值的节点 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{3,3});
        Node head2=removeValue2(head,3);
    }
    //方法1利用栈或者其他容器收集节点的方法。时间复杂度是O(N)，额外空间复杂度是O(N)
    public static Node removeValue1(Node head,int num)
    {
        if (head==null)
            return null;
        Stack<Node> stack=new Stack<>();
        while (head!=null)
        {
            if (head.value!=num)
                stack.push(head);
            head=head.next;

        }
        head=stack.pop();
        head.next=null;
        Node next=null;
        while (!stack.isEmpty())
        {
            next=head;
            head=stack.pop();
            head.next=next;
        }
        return head;

    }
    //方法2：不利用任何容器而直接调整的方法。时间复杂度是O(N)，额外空间复杂度是O(1)
    public static Node removeValue2(Node head,int num)
    {
        if (head==null)
            return null;
        Node newHead=null;
        Node pre=null;
        while (head!=null)
        {
            if (head.value!=num)
            {
                if (newHead==null){
                    newHead=head;
                    pre=head;
                }else {
                    pre.next=head;
                    pre=pre.next;
                }
            }
            head=head.next;
        }
        return newHead;
    }
}
