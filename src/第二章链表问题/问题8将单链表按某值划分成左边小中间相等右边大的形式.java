package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/18 下午2:31
 */
//要求改变之后，链表内部节点大小不变
public class 问题8将单链表按某值划分成左边小中间相等右边大的形式 {
    public static void main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{3,2,4,5,8,4});
        Node headPartition=listPartition(head,9);
    }
    //时间复杂度是O(N)，空间复杂度是O(1)
    public static Node listPartition(Node head,int pivot)
    {
        Node sH=null;//小的头
        Node sT=null;//小的尾
        Node eH=null;//相等的头
        Node eT=null;//相等生物尾
        Node bH=null;//大的头
        Node bT=null;//大的尾
        Node next=null;
        while (head!=null)
        {
            next=head.next;
            if (head.value<pivot){//小值
                if (sH==null) {
                    sH =head;
                    sT = head;
                }
                else {
                    sT.next=head;
                    sT=sT.next;
                }
            }
            else if (head.value==pivot){//相等
                if(eH==null) {
                    eH = head;
                    eT = head;
                }
                else {
                    eT.next=head;
                    eT=eT.next;
                }
            }
            else {
                if (bH==null) {
                    bH = head;
                    bT = head;
                }
                else
                {
                    bT.next=head;
                    bT=bT.next;
                    bT.next=null;
                }
            }
            head=next;
        }
        if (sT!=null)
        {
            sT.next=eH;
            eT=eT==null?sT:eT;
        }
        //所有的重新连接
        if (eT!=null)
            eT.next=bH;
        return sH!=null? sH:eH!=null?eH:bH;
    }
}
