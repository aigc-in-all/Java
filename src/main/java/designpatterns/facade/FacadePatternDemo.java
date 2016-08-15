package designpatterns.facade;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:03:16
 * @version V1.0
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
