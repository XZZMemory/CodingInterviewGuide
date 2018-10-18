package 第二章链表问题.问题3删除链表的中间结点和a除以b处的节点;

import 第二章链表问题.Node;

/**
 * created by memory
 * on 2018/10/17 下午8:09
 */
public class 删除链表的中间节点 {
    public static int errorStatus=0;//利用一个全局变量，表示出错情况
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,2,3,4});//创建的是不带头结点的链表
        Node headDeletedMid=removeMidNode(head);
    }
    //给定一个链表的头结点head，实现删除链表中间节点的函数
    public  static Node removeMidNode(Node head)
    {
        if (head==null||head.next==null) {
            errorStatus=-1;//errorStatus=-1表示当前出错情况是链表为空！
            return null;
        }
        Node fast=head.next.next;
        Node slow=head;
        while (fast!=null&&fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        slow.next=slow.next.next;
        return head;
    }
    //带头结点的链表，得到中间节点
    public static Node GetMiddleNode(Node head)
    {
        if (head==null||head.next==null)
        {
            System.out.print("链表为空！没有中间节点！");
            return null;
        }
        Node slow=head.next;
        Node fast=slow.next;
        while(fast!=null&&slow!=null)
        {
            slow=slow.next;
            fast=fast.next;
            if (fast!=null)
                fast=fast.next;
        }
        return slow;
    }

}
