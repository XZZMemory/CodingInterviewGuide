package 第一章栈和队列;

import java.util.Stack;

/**
 * created by memory
 * on 2018/9/27 下午4:06
 */
/*
 * 将栈从顶到底按照从大到小的顺序排序，只许申请一个栈，初次之外，可以申请新的变量，但不能申请额外的数据结构，如何完成排序
 */
public class 问题5用一个栈实现另一个栈的排序 {
    public static void main(String[] args)
    {
        Stack<Integer> stack=new Stack<>();
        int[] data={3,1,6,5};
        for (int i=0;i<data.length;i++)
            stack.push(data[i]);
        sortStackByStack(stack);
    }
    public static void sortStackByStack(Stack<Integer> stack)
    {
        Stack<Integer> help=new Stack<>();
        while (!stack.isEmpty())
        {
            int currentData=stack.pop();
            while(!help.isEmpty()&&help.peek()<currentData)
                stack.push(help.pop());
            help.push(currentData);
        }
        while (!help.isEmpty())
            stack.push(help.pop());
    }
}

