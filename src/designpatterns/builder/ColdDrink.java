package designpatterns.builder;

/**
 * 冷饮
 *
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:32:17
 * @version V1.0
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
