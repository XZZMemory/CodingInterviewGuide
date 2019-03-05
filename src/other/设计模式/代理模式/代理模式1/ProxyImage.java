package other.设计模式.代理模式.代理模式1;

import java.util.Collections;

/**
 * created by memory
 * on 2018/12/28 下午3:15
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
