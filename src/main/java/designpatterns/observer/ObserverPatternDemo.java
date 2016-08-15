package designpatterns.observer;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月2日 上午11:17:02
 * @version V1.0
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
