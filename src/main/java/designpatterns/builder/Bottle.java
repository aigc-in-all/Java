package designpatterns.builder;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:30:55
 * @version V1.0
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }

}
