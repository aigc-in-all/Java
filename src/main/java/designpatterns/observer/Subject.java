package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月2日 上午11:11:39
 * @version V1.0
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public int getState() {
        return state;
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
