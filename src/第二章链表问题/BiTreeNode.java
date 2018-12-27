package 第二章链表问题;

/**
 * created by memory
 * on 2018/10/23 下午7:01
 */
public class BiTreeNode {
    public int  info;
    BiTreeNode left;
    BiTreeNode right;

    public static BiTreeNode CreatTree5()
    {
        BiTreeNode biTree=new BiTreeNode();
        BiTreeNode left1=new BiTreeNode();
        BiTreeNode right1=new BiTreeNode();
        biTree.info=2;
        biTree.left=left1;
        biTree.right=right1;
        left1.info=1;
        left1.left=null;
        left1.right=null;
        right1.info=3;
        right1.left=null;
        right1.right=null;
        return biTree;
    }
}
