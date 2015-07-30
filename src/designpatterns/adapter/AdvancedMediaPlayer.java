package designpatterns.adapter;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:30:01
 * @version V1.0
 */
public interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}
