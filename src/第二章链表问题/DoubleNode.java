package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/17 下午3:22
 */
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;
    public DoubleNode(int value)
    {
        this.value=value;
    }

    public static DoubleNode creatDoubleLinkWithoutHead(int[] data)
    {
        DoubleNode head=new DoubleNode(data[0]);
        head.next=null;
        head.last=null;
        DoubleNode p=head;
        DoubleNode q;
        for (int i=1;i<data.length;i++)
        {
            q=new DoubleNode(data[i]);
            p.next=q;
            q.last=p;
            q.next=null;
            p=q;
        }
        return head;
    }
    public static void traversalOfLinkWithoutHead(DoubleNode head)
    {
        DoubleNode p=head;
        while (p!=null)
        {
            System.out.print(p.value+" ");
            p=p.next;
        }
        System.out.println();
    }

}
