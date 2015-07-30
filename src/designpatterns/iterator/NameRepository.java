package designpatterns.iterator;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:22:49
 * @version V1.0
 */
public class NameRepository implements Container {

    public String names[] = { "Robert", "John", "Julie", "Lora" };

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }

    }

}
