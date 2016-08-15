package designpatterns.strategy;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:57:56
 * @version V1.0
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
