package designpatterns.facade;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:02:03
 * @version V1.0
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }

}
