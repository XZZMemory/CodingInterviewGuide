package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/17 下午2:36
 */
public class Node {
    public int value;
    public Node next;
    public  Node(int value)
    {
        this.value=value;
    }
    public static Node creatLinkedListWithHead(int[] data) {
        Node head = new Node(0);
        Node p = head;//head;
        for (int i = 0; i < data.length; i++) {
            Node q = new Node(data[i]);
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }
    public static Node creatLinkedListWithoutHead(int[] data) {
        Node head=new Node(data[0]);
        Node p = head;//head;
        for (int i = 1; i < data.length; i++) {
            Node q = new Node(data[i]);
            q.next = null;
            p.next = q;
            p = q;
        }
        return head;
    }
}
