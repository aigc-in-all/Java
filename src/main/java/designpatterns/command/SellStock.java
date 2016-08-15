package designpatterns.command;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:15:38
 * @version V1.0
 */
public class SellStock implements Order {

    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }

}
