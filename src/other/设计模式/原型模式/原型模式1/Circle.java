package other.设计模式.原型模式.原型模式1;

/**
 * created by memory
 * on 2018/12/27 下午7:43
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
