package designpatterns.builder;

/**
 * 可口可乐
 *
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:34:52
 * @version V1.0
 */
public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }

}
