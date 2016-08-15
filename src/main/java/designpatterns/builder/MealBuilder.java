package designpatterns.builder;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午12:38:47
 * @version V1.0
 */
public class MealBuilder {

    /**
     * 蔬果餐（蔬菜汉堡+可口可乐）
     *
     * @return
     */
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    /**
     * 非蔬果餐（鸡肉汉堡+百事可乐）
     *
     * @return
     */
    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
