package designpatterns.builder;

/**
 * 鸡肉汉堡
 *
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:34:11
 * @version V1.0
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
