package other.排序算法;

/**
 * created by memory
 * on 2018/12/25 下午2:32
 */
public class Main {
    public static void main(String[] args)
    {
        int[] data={2,4,7,2,1};
        System.out.println("before");
        ShellSort shellSort=new ShellSort();
        shellSort.sort(data);
        System.out.println("after");
        System.out.println(data);
    }
}
