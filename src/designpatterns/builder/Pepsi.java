package designpatterns.builder;

/**
 * 百事可乐
 *
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:35:21
 * @version V1.0
 */
public class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }

}
