package other.排序算法;

/**
 * 原理：分治+递归
 * 复杂度：O(nlgn) - O(n^2) - O(1)[平均 - 最好 - 最坏
 * 栈空间：0(lgn) - O(n)
 */
public class QuickSort {
    public static void main(String[] args)
    {
        int[] data={2,3,7,4,1};
        sort(data);
    }
    public static void sort(int[] data)
    {
        sort(data,0,data.length-1);
    }
    public static void sort(int[] data,int low,int high)
    {
        if (low>high)
            return;
        int middle=partion(data,low,high);
        sort(data,low,middle-1);
        sort(data,middle+1,high);

    }
    public static int partion(int[] data,int low,int high)
    {
        int currentData=data[low];
        while (low<high)
        {
            while(low<high&&data[high]>currentData)
                high--;
            if (low<high) {
                data[low] = data[high];
            }
            while (low<high&&data[low]<currentData)
                low++;
            if (low<high)
            {
                data[high]=data[low];
            }
        }
        data[low]=currentData;
        return low;
    }
}
