package 第一章栈和队列;

import java.util.LinkedList;

/**
 * created by memory
 * on 2018/9/28 上午10:21
 */
/*
* 输入：整型数组arr，窗口大小为w {4,3,5,4,3,3,6,7}
* 输出：一个长度为n-w+1的数组res.res[i]表示每一中窗口状态下的最大值 {5,5,5,4,6,7}
* */
public class 问题7生成窗口最大值数组 {
    public static void main(String[] args)
    {
        int[] arr={4,3,5,4,3,3,6,7};
        int[] max=getMaxWIndow(arr,3);

    }
    public static int[] getMaxWIndow(int[] arr,int w)
    {
        if (arr==null||arr.length<w)
            return null;
        int[] res=new int[arr.length-w+1];
        int index=0;
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i=0;i<arr.length;i++)
        {
            while ((!linkedList.isEmpty())&&arr[linkedList.peekLast()]<=arr[i])
                linkedList.pollLast();
            linkedList.addLast(i);
            if (linkedList.peekFirst()==i-w)
                linkedList.pollFirst();
            if (i>=w-1)
                res[index++]=linkedList.peekFirst();
        }
        return res;
    }
}
