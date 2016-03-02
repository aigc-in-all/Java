package designpatterns.observer;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月2日 上午11:14:19
 * @version V1.0
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }

}
