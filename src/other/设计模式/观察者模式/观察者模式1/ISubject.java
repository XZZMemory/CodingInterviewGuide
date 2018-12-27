package other.设计模式.观察者模式.观察者模式1;

public interface ISubject {
    void attach(IObserver observer);
    void detach(IObserver observer);
    void inform();
}
