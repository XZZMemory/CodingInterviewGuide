package 第三章二叉树问题.问题3如何较为直观的打印二叉树3;

import 第三章二叉树问题.Node;

/**
 * 考虑层次遍历打印，不行
 */
public class PrintTree {
    public static void main(String[] args)
    {
        Node head=Node.creatTree4();
        PrintTree p=new PrintTree();
        p.printTree(head);
    }
    public void printTree(Node head)
    {
        System.out.println("Binary Tree:");
        printInOrder(head,0,"H",17);
        System.out.println();
    }
    public void printInOrder(Node head,int height,String to,int len)
    {
        if (head==null)
            return;
        printInOrder(head.left,height+1,"V",len);
        String val=to+head.value+to;
        int lenM=val.length();
        int lenL=(len-lenM)/2;
        int lenR=len-lenM-lenL;
        val=getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(height*len)+val);
        printInOrder(head.right,height+1,"^",len);
    }
    public String getSpace(int num)
    {
        StringBuffer buf=new StringBuffer("");
        for (int i = 0; i <num ; i++) {
            buf.append(" ");
        }
        return buf.toString();
    }






















}

