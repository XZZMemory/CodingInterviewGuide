package 第三章二叉树问题.问题2打印二叉树的边界节点;

/**
 * created by memory
 * on 2018/10/25 下午4:13
 */

import 第三章二叉树问题.Node;

/**
 * 给定一颗二叉树的头结点root，按照如下两种标准分别实现边界节点的逆时针打印
 * 标准一：1.头节点为边界节点
 *        2.叶节点为边界节点
 *        3.如果节点在其所在的层中是最左或最右的，那么也是边界节点
 * 标准二：1.头结点为边界节点
 *        2.叶节点为边界节点
 *        3.树左边界延伸下去的路径为边界节点
 *        4.树右边界延伸下去的路径为边界节点
 * 要求：如果节点数为N，两种标准实现的时间复杂度均为O(N)，额外空间复杂度为O(h) ,h为二叉树高度
 *      两种标准都要求逆时针顺序且不重复打印所有的边界节点
 */
public class printLeafNode {
    public static void main(String[] args) {
        Node root =creatTree();
        printEdge1(root);
    }

    public static void printEdge1(Node root)
    {
        if (root==null)
            return;
        int height=getHeight(root);
        Node[][] edgeMap=new Node[height][2];
        setEdgeMap(root,0,edgeMap);
        //打印左边界
        for (int i=0;i!=edgeMap.length;++i)
            System.out.println(edgeMap[i][0].value+" ");
        //打印既不是左边界也不是右边界的叶子节点
        printLeafNotInMap(root,0,edgeMap);
        //打印右边界但不是左边界的叶子节点
        for (int i=edgeMap.length-1;i!=-1;--i)
        {
            if (edgeMap[i][0]!=edgeMap[i][1])
                System.out.println(edgeMap[i][1].value+" ");
        }
    }
    public static int getHeight(Node root)
    {
        if (root==null)
            return 0;
        if (root.left==null&&root.right==null)
            return 1;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left+1,right+1);
    }
    //获得左边界
    public static void setEdgeMap(Node root,int l,Node[][] edgeMap)
    {
        if (root==null)
            return;
        edgeMap[l][0]=edgeMap[1][0]==null?root:edgeMap[l][0];
        edgeMap[l][1]=root;
        setEdgeMap(root.left,l+1,edgeMap);
        setEdgeMap(root.right,l+1,edgeMap);
    }
    //打印既不是右边界，也不是右边界的叶子节点
    public static void printLeafNotInMap(Node root,int l,Node[][] m)
    {
        if (root==null)
            return;
        if (root.left==null&&root.right==null&&root!=m[1][0]&&root!=m[1][1])
            System.out.println(root.value);
        printLeafNotInMap(root.left,1+1,m);
        printLeafNotInMap(root.right,1+1,m);
    }
    public static Node creatTree()
    {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        Node node8=new Node(8);
        Node node9=new Node(9);
        Node node10=new Node(10);
        Node node11=new Node(11);
        Node node12=new Node(12);
        Node node13=new Node(13);
        Node node14=new Node(14);
        Node node15=new Node(15);
        Node node16=new Node(16);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node5.left=node9;
        node5.right=node10;
        node8.right=node11;
        node9.left=node12;
        node11.left=node14;
        node11.right=node14;
        node12.left=node15;
        node12.right=node16;
        return node1;
    }
}
