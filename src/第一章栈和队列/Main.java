package 第一章栈和队列;


import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int[] arr={1,2,4,3};
        printArray(arr);
        System.out.println(getNum(arr, 1));
    }

    //for other.other.强软弱虚引用.强软弱虚引用
    public static int[] getRandomArray(int len){
        if (len < 0) {
            return null;
        }

        int[] arr=new int[len];
        for (int i=0;i<len;i++){
            arr[i]= (int) (Math.random()*10);
        }
        return arr;
    }

    //for other.other.强软弱虚引用.强软弱虚引用
    public static void printArray(int[] arr){
        if (arr != null) {
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static int getNum(int[] arr,int num){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin=new LinkedList<Integer>();
        LinkedList<Integer> qmax=new LinkedList<Integer>();
        int i=0;
        int j=0;
        int res=0;

        while (i < arr.length) {
            while (j < arr.length) {
                //采用双端队列位置最小值
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                //维持最大值
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            //如果最大值是i位置上的，此时左指针向右划，i位置过期，i++，当然如果最大值或最小值
            //还是i位置上的值，则抛弃。
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            //计算以i开头到j位置上的子数组数量，就是j-i
            res += j - i;
            i++;
        }
        return res;
    }
}