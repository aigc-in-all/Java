package designpatterns.businessdelegate;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:47:03
 * @version V1.0
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {

        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
