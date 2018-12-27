package 第三章二叉树问题.问题1分别用递归和非递归方式实现二叉树的先序中序和后序遍历;

import 第三章二叉树问题.Node;

import java.util.Stack;

/**
 * created by memory
 * on 2018/10/24 上午10:59
 */
public class 用非递归方式实现先中后遍历 {
    public static void main(String[] args)
    {
        Node root=Node.CreatTree4();
        preOrder(root);
    }

    public static void preOrder(Node root)
    {
        System.out.println("pre-order:");
        if (root==null)
            return;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        Node curNode=null;
        while (!stack.isEmpty())
        {
            curNode=stack.pop();
            System.out.print(curNode.value);
            if (curNode.right!=null)
                stack.push(curNode.right);
            if (curNode.left!=null)
                stack.push(curNode.left);
        }
        System.out.println();
    }
    public static void inOrder(Node root)
    {
        System.out.println("in-order:");
        if (root==null)
            return;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        Node cur=root;
        while (!stack.isEmpty()||cur!=null)
        {
            if (cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }
            else {
                cur=stack.pop();
                System.out.println(cur.value+" ");
                cur=cur.right;
            }
        }
        System.out.println();
    }
    public static void postOrder(Node root)
    {
        System.out.println("post-order:");
        if (root==null)
            return;


    }
}
