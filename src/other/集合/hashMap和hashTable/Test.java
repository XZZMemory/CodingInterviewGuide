package other.集合.hashMap和hashTable;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args)
    {
        Map<Integer,Integer> map=new HashMap<>();
        System.out.println(Float.isNaN(1));
        Coder coder1=new Coder(1,2);
        Coder coder2=new Coder(1,2);
        System.out.println("equals:"+coder1.equals(coder2));
        System.out.println("==:"+(coder1==coder2));

    }
}
