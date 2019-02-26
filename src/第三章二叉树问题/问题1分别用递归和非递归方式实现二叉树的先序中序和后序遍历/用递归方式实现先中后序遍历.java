package 第三章二叉树问题.问题1分别用递归和非递归方式实现二叉树的先序中序和后序遍历;

import 第三章二叉树问题.Node;

/**
 * created by memory
 * on 2018/10/24 上午10:50
 */
public class 用递归方式实现先中后序遍历 {
    public static void main(String[] args)
    {
        Node root=Node.creatTree4();
        preOrder(root);
        inOrder(root);
        postOrder(root);
    }
    public static void preOrder(Node root)
    {
        if (root==null)
            return;
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root)
    {
        if (root==null)
            return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }
    public static void postOrder(Node root)
    {
        if (root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
}
