package other.集合.arraylist和linkedlist尾部插入元素效率对比;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 查看，向Arraylist和Linkedlist中尾部加数据时，他们的效率
 * 顺序存取，ArrayList 比较快；随机存取，LinkedList比较快。
 */
public class ArraylistLinkedlistDemo {
    public static void main(String[] args)
    {

        for (int times = 10; times <10000000 ; times*=10) {
            List<Integer> linkedList=new LinkedList<>();
            List<Integer> arrayList =new ArrayList<>();
            System.out.println("插入"+times+"个数据时");
            Long startTimeLink=System.currentTimeMillis();
            for (int i = 0; i < times; i++) {
                linkedList.add(Integer.valueOf(i));
            }
            System.out.println("LinkList运行时间："+String.valueOf(System.currentTimeMillis()-startTimeLink)+"ms");
            Long startTime2=System.currentTimeMillis();
            for (int i = 0; i < times; i++) {
                arrayList.add(Integer.valueOf(i));
            }
            System.out.println("ArrayList运行时间："+String.valueOf(System.currentTimeMillis()-startTime2)+"ms");
        }
        for (int times = 10000000; times <2100000000 ; times+=10000000) {
            List<Integer> linkedList=new LinkedList<>();
            List<Integer> arrayList =new ArrayList<>();
            System.out.println("插入"+times+"个数据时");
            Long startTimeLink=System.currentTimeMillis();
            for (int i = 0; i < times; i++) {
                linkedList.add(Integer.valueOf(i));
            }
            System.out.println("LinkList运行时间："+String.valueOf(System.currentTimeMillis()-startTimeLink)+"ms");
            Long startTime2=System.currentTimeMillis();
            for (int i = 0; i < times; i++) {
                arrayList.add(Integer.valueOf(i));
            }
            System.out.println("ArrayList运行时间："+String.valueOf(System.currentTimeMillis()-startTime2)+"ms");
        }

    }
}
