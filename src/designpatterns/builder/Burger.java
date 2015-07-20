package designpatterns.builder;

/**
 * 汉堡包
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:31:26
 * @version V1.0
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
