package other.设计模式.观察者模式;

import java.util.Vector;

public class ConcreteSubject implements ISubject{
    Vector<IObserver> observers=new Vector<>();
    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {
       // Event event=new Event();
        for (IObserver ob:observers)
        {
            //ob.update(event);//通知观察者
        }

    }
}
