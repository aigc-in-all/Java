package designpatterns.observer;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月2日 上午11:11:52
 * @version V1.0
 */
public abstract class Observer {

    protected Subject subject;
    protected abstract void update();
}
