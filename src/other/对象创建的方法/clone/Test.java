package other.对象创建的方法.clone;

public class Test {
    public static void main(String[] args)
    {
        Obj a=new Obj();
        Obj b= (Obj) a.clone();
        b.chanegBirth();
        System.out.println(a.getBirth());
        System.out.println(b.getBirth());
    }
}
