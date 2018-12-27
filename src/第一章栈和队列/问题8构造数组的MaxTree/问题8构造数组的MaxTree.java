package 第一章栈和队列.问题8构造数组的MaxTree;

/**
 * created by memory
 * on 2018/9/28 下午3:13
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个没有重复元素的数组arr，写出生成这个数组的MaxTree的函数，要求若数组长度是N，则时间复杂度为O(N)，额外空间复杂度为O(N)
 */

/**
 * 每个数的父节点是她左边第一个比它大的数和它右边第一个比它大的数中，较小的那个
 * 如果一个数左右均没有比它大的数，这个数是整个数组中的最大值，这个数是maxTree得头结点
 */
public class 问题8构造数组的MaxTree {
    public static void main(String[] args)
    {
        int[] arr={3,4,5,1,2};
        Node head=getMaxTree(arr);
        traversalOfBiTree(head);
    }
    public static Node getMaxTree(int[] arr)
    {
        if (arr==null||arr.length==1)
            return null;
        Node [] nArr=new Node[arr.length];
        for (int i=0;i<nArr.length;++i)
            nArr[i]=new Node(arr[i]);
        Stack<Node> stack=new Stack<>();
        HashMap<Node,Node> lBigMap=new HashMap<>();//存储左边最大的数字
        HashMap<Node,Node> rBigMap=new HashMap<>();//存储右边最大的数字
        /**
         * 找到每个数组左边最大的数字，用HashMap存储
         */
        for (int i=0;i<nArr.length;++i)//stack是一个递减数组，
        {
            Node curNode=nArr[i];
            while((!stack.isEmpty())&&stack.peek().value<curNode.value)
                popStackSetMap(stack,lBigMap);
            stack.push(curNode);
        }
        while(!stack.isEmpty())
            popStackSetMap(stack,lBigMap);
        /**
         * 找到每个数组右边最大的数字，用HashMap存储
         */
        for (int i=nArr.length-1;i>=0;--i)
        {
            Node curNode=nArr[i];
            while((!stack.isEmpty())&&stack.peek().value<curNode.value)
                popStackSetMap(stack,rBigMap);
            stack.push(curNode);
        }
        while (!stack.isEmpty())
            popStackSetMap(stack,rBigMap);
        Node head=null;
        for (int i=0;i<nArr.length;i++) {
            Node curNode = nArr[i];//当前节点
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null)
                head = curNode;
            else if (left == null) {
                if (right.left == null)
                    right.left = curNode;
                else
                    right.right = right;
            } else if (right == null) {
                if (left.left == null)
                    left.left = curNode;
                else
                    left.right = curNode;
            } else {//左右均不为空，选择最的那个
                Node parent=left.value<right.value?left:right;
                if (parent.left==null)
                    parent.left=curNode;
                else
                    parent.right=curNode;
            }
        }
        return head;
    }
    public  static void popStackSetMap(Stack<Node> stack, HashMap<Node,Node> hashMap)
    {
        Node popNode=stack.pop();
        if (stack.isEmpty())
            hashMap.put(popNode,null);
        else
            hashMap.put(popNode,stack.peek());
    }
    public static void traversalOfBiTree(Node head)
    {
        if (head==null)
            return;
        System.out.println(head.value);
        traversalOfBiTree(head.left);
        traversalOfBiTree(head.right);

    }
}

