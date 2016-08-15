package designpatterns.command;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:14:59
 * @version V1.0
 */
public class BuyStock implements Order {

    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }

}
