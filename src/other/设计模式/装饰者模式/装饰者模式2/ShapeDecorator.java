package other.设计模式.装饰者模式.装饰者模式2;

/**
 * created by memory
 * on 2018/12/27 下午6:45
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
