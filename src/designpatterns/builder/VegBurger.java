package designpatterns.builder;

/**
 * 蔬菜汉堡
 *
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:33:09
 * @version V1.0
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
