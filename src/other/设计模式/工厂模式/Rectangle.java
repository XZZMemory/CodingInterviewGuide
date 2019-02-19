package other.设计模式.工厂模式;

/**
 * created by memory
 * on 2019/1/24 上午1:21
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(this.getClass()+"Inside Rectangle::draw() method.");
    }
}
