package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/23 下午8:12
 */

/**
 * 一个环形单链表从头结点head开始不降序，同时由最后的节点返回头节点，给定这样一个环形单链表的头节点head和一个整数num，
 * 请生成节点值为num的新节点
 */
public class 问题18向有序的环形单链表中插入新节点 {
    public static void main(String[] args)
    {
        Node head=creatCircleLink(new int[]{1,1,2,4});
        Node head2=insertNum(head,8);

    }
    public static Node insertNum(Node head,int num)
    {
        Node node=new Node(num);
        if (head==null)
        {
            node.next=node;
            return node;
        }
        Node pre=head;
        Node cur=pre.next;
        while (cur!=head)
        {
            if (pre.value<=num&&cur.value>num)
            {
                break;
            }
            pre=cur;
            cur=cur.next;
        }
        pre.next=node;
        node.next=cur;
        return  head.value>num?node:head;

    }
    public static Node creatCircleLink(int[] data)
    {
        if (data==null||data.length==0)
            return null;
        Node head=null;
        Node p=null;
        Node pre=null;
        for (int i=0;i<data.length;i++)
        {
            p=new Node(data[i]);
            if (head==null)
            {
                head=p;
                pre=p;
            }
            else {
                pre.next=p;
                pre=p;
            }
        }
        pre.next=head;
        return head;
    }
}
