package designpatterns.proxy;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:09:05
 * @version V1.0
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
     }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
         }
         realImage.display();
    }

}
