package 第三章二叉树问题;

/**
 * created by memory
 * on 2018/10/24 上午10:43
 */
public class Node {
    public int value;
    public Node left;
    public  Node right;
    public  Node(int value)
    {
        this.value=value;
    }

    public static Node CreatTree4()
    {
        Node biTree=new Node(10);
        Node left1=new Node(6);
        Node right1=new Node(14);
        Node left2=new Node(4);
        Node right2=new Node(8);
        biTree.left=left1;
        biTree.right=right1;
        left1.left=left2;
        left1.right=right2;
        return biTree;
    }
}
