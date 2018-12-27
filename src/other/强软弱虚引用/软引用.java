package other.强软弱虚引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class 软引用 {
    public static void main(String[] args) {
        A a = new A(5);
        fun(a);
        A aa=new A(5);
        A aaa=new A(4);

        System.out.println(a==aa);// 输出结果为6
        System.out.println(a.equals(aa));
        System.out.println(a);
        System.out.println(aaa);
        System.out.println(aaa.hashCode());

        ReferenceQueue<A> referenceQueue=new ReferenceQueue<>();
        PhantomReference<A>phantomReference=new PhantomReference<>(new A(9),referenceQueue);

        WeakReference<A> reference=new WeakReference<>(new A(7));
        System.out.println(reference.get());
        System.gc();
        System.out.println(reference.get());

    }


    private static void fun(A a) {
        a.a += 1;
    }

    static class A {
        public int a;

        public A(int a) {
            this.a = a;
        }
    }
}
