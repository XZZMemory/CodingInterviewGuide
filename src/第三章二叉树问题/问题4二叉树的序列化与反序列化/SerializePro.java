package 第三章二叉树问题.问题4二叉树的序列化与反序列化;

import 第三章二叉树问题.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 二叉树被记录为文件的过程叫做二叉树的序列化，通过文件内容重建原来二叉树的过程称为二叉树的反序列化。
 * 已知二叉树节点值的类型为32位整数，设计一种二叉树序列化和 反序列化的方案。
 */
public class SerializePro {
    public static void main(String[] args)
    {
        Node root=Node.creatTree4();
        SerializePro serializePro=new SerializePro();
        String str=serializePro.serialByPre(root);
        System.out.println(str);
//        Queue<Node> queue=new LinkedList<>();
//        Node deserializeRoot=serializePro.deserialize(str,queue);
    }

    //第一种方案，表示为一个字符串String，并根据字符串重建原来的二叉树，前序遍历建立字符串
    public String serialByPre(Node root)
    {
        if (root==null)
            return "#!";
        return root.value+"!"+serialByPre(root.left)+serialByPre(root.right);
    }

    /**
     * 反序列化
     * 10!6!4!#!#!8!#!#!14!#!#!
     * 自己想的，用while循环的，会比较复杂，没写出来。parent需要进出站两次。没想到怎么写，放弃这个方法
     * 考虑使用递归
     */
    public Node deserialize(String str,Queue<Node> queue)
    {
        if (str==null||str.length()<=0)
            return null;
        int currentDataIndex= getCurrentNodeIndex(str);
        String currentData=str.substring(0,currentDataIndex);
        if (currentData.equals("#"))
            return null;
        Node root=new Node(Integer.parseInt(currentData));
        queue.add(root);
        str=str.substring(currentDataIndex+1);
        while (str!=null&&str.length()>0)
        {
            Node parentNode=queue.poll();
            int leftDataIndex= getCurrentNodeIndex(str);
            String leftData=str.substring(0,leftDataIndex);
            if (leftData.equals("#"))
                parentNode.left=null;
            else
            {
                Node leftNode=new Node(Integer.parseInt(leftData));
                parentNode.left=leftNode;
                queue.add(leftNode);
            }
            if (str==null||str.length()<=0)
                break;
            str=str.substring(leftDataIndex+1);
            int rightDataIndex= getCurrentNodeIndex(str);
            String rightData=str.substring(0,rightDataIndex);
            if (rightData.equals("#"))
                parentNode.right=null;
            else
            {
                Node rightNode=new Node(Integer.parseInt(rightData));
                parentNode.right=rightNode;
                queue.add(rightNode);
            }
            str=str.substring(rightDataIndex+1);
        }
        return root;
    }
    public Node reconByPreString(String preStr)
    {
        String[] values=preStr.split("!");
        Queue<String> queue=new LinkedList<>();
        for (int i = 0; i <values.length ; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }
    public Node reconPreOrder(Queue<String>queue)
    {
        String value=queue.poll();
        if (value.equals("#"))
            return null;
        Node head=new Node(Integer.parseInt(value));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);
        return head;


    }
    public int getCurrentNodeIndex(String str)
    {
        int i;
        for ( i= 0; i < str.length(); i++) {
            if (str.charAt(i)=='!')
                break;
        }
        return i;
    }
}
