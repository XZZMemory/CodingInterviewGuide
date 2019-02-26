package 第三章二叉树问题.问题4二叉树的序列化与反序列化;

import 第三章二叉树问题.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * t通过层次遍历实现序列化与反序列化
 */
public class SerializePro2 {
    public static void main(String[] args)
    {
        SerializePro2 serializePro2=new SerializePro2();
        Node root=Node.creatTree4();
        String values=serializePro2.serialByLevel(root);
        System.out.println(values);
        Node reconRoot=serializePro2.reconByLevelString(values);

    }
    //第一种方案，表示为一个字符串String，并根据字符串重建原来的二叉树，层次遍历
    public String serialByLevel(Node root)
    {
        if (root==null)
            return "#!";
        Queue<Node> queue=new LinkedList<>();
        String values=root.value+"!";
        queue.add(root);
        while (queue!=null&&queue.size()>0)
        {
            Node currentNode=queue.poll();
            if (currentNode!=null)
            {
                //左子树进队列
                 if (currentNode.left==null)
                     values+="#!";
                 else {
                     values += currentNode.left.value+"!";
                     queue.add(currentNode.left);
                 }
                //右子树进队列
                if (currentNode.right==null)
                    values+="#!";
                else {
                    values += currentNode.right.value+"!";
                    queue.add(currentNode.right);
                }
            }
        }
        return values;
    }
    //1.根据层次遍历重建二叉树，使用递归
    public Node reconByLevelString(String levelStr)
    {
        String[] values=levelStr.split("!");
        return reconByLevelValues(values,1);
    }
    public Node reconByLevelValues(String[] values,int index)
    {
        //当前的值，再数组中实际下标是index-1
        if (values[index-1].equals("#")||index<0||index>=values.length)
            return null;
        Node root=new Node(Integer.parseInt(values[index-1]));
        root.left=reconByLevelValues(values,index*2);
        root.right=reconByLevelValues(values,index*2+1);
        return root;
    }
    //2.根据层次遍历重建二叉树，使用队列
    public Node reconByLevelString2(String levelStr)
    {
        String[] values=levelStr.split("!");
        return reconByLevelValues(values,1);
    }
    public Node reconByLevelValues2(String[] values)
    {
        return null;

    }


}
