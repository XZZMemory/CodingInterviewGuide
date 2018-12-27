package 第一章栈和队列;

import java.util.Stack;

/**
 * created by memory
 * on 2018/9/27 下午12:38
 */
public class 问题3如何仅用递归和栈操作逆序一个栈 {
    public static void main(String[] args)
    {
        Stack<Integer> stack=new Stack<>();
        int[] data={1,2,3,4};
        for (int i=0;i<data.length;i++)
            stack.push(data[i]);
        reverse(stack);
    }
    public static int getAndRemoveLastElement(Stack<Integer> stack)
    {
        int currentData=stack.pop();
        if (stack.isEmpty())
            return currentData;
        int last=getAndRemoveLastElement(stack);
        stack.push(currentData);
        return last;
    }
    public static void reverse(Stack<Integer> stack)
    {
        if (stack==null||stack.isEmpty())
            return;
        int last=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);

    }

}
