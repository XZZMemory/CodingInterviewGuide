package 第二章链表问题.问题3删除链表的中间结点和a除以b处的节点;

import 第二章链表问题.Node;

/**
 * created by memory
 * on 2018/10/17 下午8:58
 */
//给定链表的头结点head、整数a和整数b，实现删除位于a/b处节点的函数
public class 删除链表a除以b处的节点 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,2,3,4});
        Node headDeleted=removeByRatio(head,3,4);

    }
    public static Node removeByRatio(Node head,int a,int b)
    {
        if (a<1||a>=b||b<0)
            return head;
        int length=0;
        Node p=head;
        while (p!=null){
            length++;
            p=p.next;
        }
        int index=(int)Math.ceil((double)a*length/b);//找到删除第几个几点

        if (index==1)
            head=head.next;
        else
        {
            p=head;
            while (index>2)
            {
                p=p.next;
                index--;
            }
            p.next=p.next.next;
        }
        return head;
    }
}
