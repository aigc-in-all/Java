package designpatterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:16:06
 * @version V1.0
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    // 清空库存
    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
