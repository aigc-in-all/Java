package designpatterns.businessdelegate;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:48:16
 * @version V1.0
 */
public class BusinessDelegatePatternDemo {
    public static void main(String[] args) {

        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}
