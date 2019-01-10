package other.设计模式.单例模式.DCL;

import other.设计模式.单例模式.SingleObject;

/**
 * created by memory
 * on 2018/12/28 下午3:10
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        Singleton object = Singleton.getSingleton();

        //显示消息
    }
}
