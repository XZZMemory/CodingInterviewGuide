package other.排序算法;

public class 直接插入排序 {
    public int[]  sort(int[] data)
    {
        if (data==null||data.length==0)
            return null;
        for (int i = 1; i <data.length ; i++) {
            if (data[i]<data[i-1])//如果已经比有序的大了，说明是顺序的，不需要调整
            {
                int temp=data[i];
                for (int j = i-1; j >=0 ; j--) {

                    if (data[j]>data[i])
                        data[j+1]=data[j];
                    else
                    {
                        data[j+1]=temp;
                    }

                }

            }
        }
        return data;

    }
}
