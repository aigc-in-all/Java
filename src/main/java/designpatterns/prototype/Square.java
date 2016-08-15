package designpatterns.prototype;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午1:33:27
 * @version V1.0
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    protected void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
