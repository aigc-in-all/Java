package designpatterns.builder;

/**
 * Item两个实现类：Burger(汉堡包)和ColdDrink(冷饮)
 * Burger有两个子类：CheckenBurger(鸡肉汉堡)和VegBurger(蔬菜汉堡)
 * ColdDrink有两个子类：Coke(可口可乐)和Pepsi(百事可乐)
 *
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:28:39
 * @version V1.0
 */
public interface Item {
    public String name(); // 名字

    /**
     * @return 打包方式 Bottle:瓶子 Wrapper:纸包装
     */
    public Packing packing();

    public float price(); // 价格
}
