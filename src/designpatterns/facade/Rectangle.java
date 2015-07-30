package designpatterns.facade;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:01:38
 * @version V1.0
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }

}
