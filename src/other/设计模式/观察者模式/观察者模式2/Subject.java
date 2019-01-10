package other.设计模式.观察者模式.观察者模式2;

/**
 * created by memory
 * on 2018/12/27 下午10:53
 */

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers= new ArrayList<Observer>();
    private int state;
    public void attach(Observer observer){
        observers.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}