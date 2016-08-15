package designpatterns.state;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:44:46
 * @version V1.0
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Stop State";
     }

}
