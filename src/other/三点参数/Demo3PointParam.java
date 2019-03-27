package other.三点参数;

public class Demo3PointParam {
    private void test(String... strings) {
        if (strings != null) {
            for (int i = 0; i < strings.length; i++) {
                System.out.println(String.format("三点函数test的strings数据的第 %s 个参数是：%s ", String.valueOf(i), strings[i]));
            }
        } else {
            System.out.println("数据不存在");
        }
    }

    private void test2() {
        System.out.println("执行无参函数test2");
    }

    private String test2(int... ints) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("三点函数test2的数据是：");
        if (ints != null) {
            for (int i = 0; i < ints.length; i++) {
                stringBuffer.append(String.valueOf(ints[i]));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Demo3PointParam demo = new Demo3PointParam();
        demo.test();//可以使用，但不会输出任何数据
        demo.test(null);//数据不存在
        demo.test(new String[]{"111", "222", "333"});
        demo.test("a", "b");
        demo.test2();
        System.out.println(demo.test2(null));
        System.out.println(demo.test2(22));
        System.out.println(demo.test2(33, 44, 55));
    }
}
