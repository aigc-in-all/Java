package designpatterns.strategy;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:56:54
 * @version V1.0
 */
public class OperationSubstract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

}
