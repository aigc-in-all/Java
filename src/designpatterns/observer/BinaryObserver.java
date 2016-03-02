package designpatterns.observer;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月2日 上午11:14:19
 * @version V1.0
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }

}
