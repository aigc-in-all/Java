package designpatterns.businessdelegate;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:46:11
 * @version V1.0
 */
public class EJBService implements BusinessService{

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }

}
