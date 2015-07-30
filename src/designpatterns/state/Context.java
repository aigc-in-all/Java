package designpatterns.state;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:45:48
 * @version V1.0
 */
public class Context {
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
