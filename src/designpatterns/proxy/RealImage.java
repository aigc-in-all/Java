package designpatterns.proxy;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:08:11
 * @version V1.0
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
     }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
     }

}
