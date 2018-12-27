package other.排序算法;
//升序
public class 冒泡排序 {
    public static void main(String[] args)
    {
        int[] data={1,3,9,5,4,2};
        bubbleSort(data);
    }
    public static void bubbleSort(int[] data)
    {
        for (int i = 0; i <data.length ; i++) {
            for (int j = 1; j <data.length-i ; j++) {

                if (more(data,j-1,j))
                {
                    exch(data,j-1,j);
                }

            }

        }
    }
    public static void exch(int[] data,int i,int j)
    {
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }

    public static boolean more(int[] data,int i,int j)
    {
        return data[i]>data[j];
    }
}
