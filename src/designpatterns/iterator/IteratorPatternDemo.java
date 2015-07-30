package designpatterns.iterator;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:24:19
 * @version V1.0
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        Iterator it = namesRepository.getIterator();
        while (it.hasNext()) {
            String name = (String) it.next();
            System.out.println("Name : " + name);
        }
    }
}
