package 第一章栈和队列;

/**
 * created by memory
 * on 2018/10/16 下午8:56
 */

import java.util.LinkedList;

/**题目：
 * 给定数组arr和整数num，共返回多少个子数组满足如下情况：
 *   max(arr[i...j])-min(arr[i...j])<=num
 *   要求：如果数组长度为N，请实现时间复杂度为O(N)的解法
 */
public class 问题10最大值减去最小值小于或等于num子数组数量 {
    public static void main(String[] args){
        int[] arr={1,2,4,3};
        int num=getNum(arr,1);
    }
    public static int getNum(int[] arr,int num)
    {
        if (arr==null||arr.length==0)
            return 0;
        LinkedList<Integer>  qmax=new LinkedList<>();
        LinkedList<Integer> qmin=new LinkedList<>();
        int res=0;
        int i=0;
        int j=0;
        while (i<arr.length){
            while (j<arr.length){
                while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j])
                    qmin.pollLast();
                qmin.addLast(j);
                while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j])
                    qmax.pollLast();
                qmax.addLast(j);
                if (arr[qmax.getFirst()]-arr[qmin.getFirst()]>num)
                    break;
                j++;
            }
            if (qmin.peekFirst()==i)
                qmin.pollFirst();
            if (qmax.pollFirst()==i)
                qmax.pollFirst();
            res+=j-i;
            i++;
        }
        return res;
    }
    public static int[] getMaxWIndow(int[] arr,int w)
    {
        if (arr==null||arr.length<w)
            return null;
        int[] res=new int[arr.length-w+1];
        int index=0;
        LinkedList<Integer> qmax=new LinkedList<>();
        for (int i=0;i<arr.length;i++)
        {
            while ((!qmax.isEmpty())&&arr[qmax.peekLast()]<=arr[i])
                qmax.pollLast();
            qmax.addLast(i);
            if (qmax.peekFirst()==i-w)
                qmax.pollFirst();
            if (i>=w-1)
                res[index++]=qmax.peekFirst();
        }
        return res;
    }
}
