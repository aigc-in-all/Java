package designpatterns.prototype;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月20日 下午1:31:10
 * @version V1.0
 */
public abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    protected abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
