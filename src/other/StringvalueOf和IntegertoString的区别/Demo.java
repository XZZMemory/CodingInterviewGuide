package other.StringvalueOf和IntegertoString的区别;

public class Demo {
    public static void main(String[] args) {
        int a = 12;
        String str = String.valueOf(12);
        String c = Integer.toString(12);
        StringBuffer test=new StringBuffer("123");
        System.out.println("1  "+String.format("like %s","str"));
        System.out.println("11  "+String.format("like %%s","str"));
        System.out.println("2  "+String.format("like %%%s","str"));
        System.out.println("3  "+String.format("like %s%%","str"));
        System.out.println("4  "+String.format("like %%s%%", "str"));
        System.out.println("5  "+String.format("like %%%s%%", "str"));
        System.out.println(String.format("like %s%s","str", "%"));


    }
}
