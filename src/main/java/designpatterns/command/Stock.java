package designpatterns.command;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:12:47
 * @version V1.0
 */
// 库存
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    // 购买
    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    // 销售
    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}
