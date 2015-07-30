package designpatterns.state;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:46:09
 * @version V1.0
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
