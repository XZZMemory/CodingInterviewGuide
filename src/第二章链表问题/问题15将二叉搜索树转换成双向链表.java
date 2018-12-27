package 第二章链表问题;


/**
 * created by memory
 * on 2018/10/23 下午6:39
 */
public class 问题15将二叉搜索树转换成双向链表 {
    public static void main(String[] args)
    {

        BiTreeNode root=BiTreeNode.CreatTree5();


    }
    public static BiTreeNode convert1(BiTreeNode root)
    {
        if(root==null)
            return null;
        //左
        root.left=convert1(root.left);
        //中
        root.right=convert1(root.right);
        //右
        return null;
    }
}
