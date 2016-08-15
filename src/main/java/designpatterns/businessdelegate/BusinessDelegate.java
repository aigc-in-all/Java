package designpatterns.businessdelegate;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:47:26
 * @version V1.0
 */
public class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
