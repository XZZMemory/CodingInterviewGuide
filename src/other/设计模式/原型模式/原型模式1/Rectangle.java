package other.设计模式.原型模式.原型模式1;

/**
 * created by memory
 * on 2018/12/27 下午7:42
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}