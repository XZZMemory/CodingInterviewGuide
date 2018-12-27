package other.设计模式.原型模式.原型模式1;

/**
 * created by memory
 * on 2018/12/27 下午7:42
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
