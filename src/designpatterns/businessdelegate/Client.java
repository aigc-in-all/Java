package designpatterns.businessdelegate;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:47:54
 * @version V1.0
 */
public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    public void doTask() {
        businessService.doTask();
    }
}
