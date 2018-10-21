package 第二章链表问题;

import java.util.HashMap;
import java.util.Map;

/**
 * created by memory
 * on 2018/10/18 下午3:06
 */
public class 问题9复制含有随机指针节点的链表 {
    public static void main(String[] args)
    {
        ComplexNode head=ComplexNode.creatList();//没有头结点
        ComplexNode head2=copyListWithRandom1(head);
    }
    //利用哈希表hash，=时间复杂度为O(N),空间复杂度是O(N)
    public static ComplexNode copyListWithRandom1(ComplexNode head)
    {
        HashMap<ComplexNode,ComplexNode> hashMap=new HashMap<>();
        ComplexNode cur=head;
        while (cur!=null)
        {
            hashMap.put(cur,new ComplexNode(cur.value));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null)
        {
            hashMap.get(cur).random=hashMap.get(cur.random);
            hashMap.get(cur).next=hashMap.get(cur.next);
            cur=cur.next;
        }
        return hashMap.get(head);
    }
    public static ComplexNode copyListWithRandom2(ComplexNode head)
    {
        if (head==null)
            return null;
        ComplexNode cur=head;
        ComplexNode next=null;
//1.复制next
        while (cur!=null)
        {
            next=cur.next;
            ComplexNode p=new ComplexNode(cur.value);
            cur.next=p;
            p.next=next;
            cur=next;
        }
        //2.复制random指针
        cur=head;
        ComplexNode curCopy=null;
        while(cur!=null)
        {
            curCopy=cur.next;
            if (cur.random!=null)
                curCopy.random=cur.random.next;
            cur=curCopy.next;
        }
        //3.分离
        cur=head;
        ComplexNode head2=cur.next;
        curCopy=head.next;
        while(cur!=null)
        {
            cur.next=curCopy.next;
            cur=cur.next;
            if (cur != null) {
                curCopy.next=cur.next;
                curCopy=curCopy.next;
            }
        }
        return head2;
    }


}