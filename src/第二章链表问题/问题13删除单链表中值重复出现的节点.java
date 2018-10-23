package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/23 下午4:46
 */

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个无序单链表的头节点head，删除其中值重复出现的节点
 * 要求：方法1：时间复杂度O(N)
 *      防范2：空间复杂度O(1)
 */
public class 问题13删除单链表中值重复出现的节点 {
    public static void  main(String[] args)
    {
        Node head=Node.creatLinkWithoutHead(new int[]{1,2,3,4,5,3,2,3,4,7});
        removeRep1(head);
    }
    //方法1：时间复杂度O(N)，利用哈希表，额外空间复杂度O(N)
    public static void removeRep1(Node head)
    {
        if (head==null||head.next==null)
            return;
        Set<Integer> set=new HashSet<>();
        set.add(head.value);
        Node pre=head;
        Node cur=head.next;
        Node next=null;
        while (cur!=null)
        {
            next=cur.next;
            if (set.contains(cur.value))
                pre.next=next;
            else
            {
                set.add(cur.value);
                pre=cur;
            }
            cur=next;
        }
    }
    //往后检查到值相等的节点，均删除
    public static void removeRep2(Node head)
    {

    }


}
