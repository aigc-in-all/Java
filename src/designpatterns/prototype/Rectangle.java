package designpatterns.prototype;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午1:33:27
 * @version V1.0
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    protected void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
