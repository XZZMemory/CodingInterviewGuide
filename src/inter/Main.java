package inter;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String args[]) {
        System.out.println("fff"+null);
        Main a=new Main();
        int[] data={5,4,78,23,34,67,1};
        a.quickSort(data,0,data.length-1);
        System.out.println(data);
    }
    public void quickSort(int[] data,int start,int end)
    {
        if (data==null||data.length==0||start<0||end>=data.length)
            return  ;
        int middle=sort(data,start,end );
        if (middle==-1)
            return;
        sort(data,start,middle-1);
        sort(data,middle+1,end);

    }
    public int  sort(int[] data,int start,int end)
    {
        if (data==null||data.length==0||start<0||end>=data.length)
            return -1 ;
        int currentData=data[start];
        while (start<end)
        {
            while (data[end]>=currentData&&start<end)
                end--;
            if (start<end)
            {
                data[start]=data[end];
                start++;
            }
            while (data[start]<currentData&&start<end)
                start++;
            if (start<end)
            {
                data[end]=data[start];
                end--;
            }
        }
        data[start]=currentData;
        return start;
    }
}
