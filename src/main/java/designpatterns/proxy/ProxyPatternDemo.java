package designpatterns.proxy;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:09:39
 * @version V1.0
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // image will be loaded from disk
        image.display();
        System.out.println("");

        // image will not be loaded from disk
        image.display();
    }
}
