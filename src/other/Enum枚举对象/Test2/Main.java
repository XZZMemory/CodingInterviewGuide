package other.Enum枚举对象.Test2;

/**
 * 在现实社会中，有些类的实例对象是固定的。例如季节，只有春夏秋冬。
 * 如果你创建了一个season类，你当然有义务维护这个类的实例对象只能是春（SPRING）、夏（SUMMER）、秋（AUTUMN）、冬（WINTER）这四个。
 * 这个时候就体现出枚举类的作用了，java中枚举类型就是针对这样的场景需求所设计的。
 */
public class Main {
    public static void main(String[] args) {
        //直接初始化

        SeasonEnum season1 =SeasonEnum.SPRING;
        //调用SeasonEnum枚举类的getChinese()方法获取SPRING的中文值
        System.out.println(season1.getChinese());

    }
}