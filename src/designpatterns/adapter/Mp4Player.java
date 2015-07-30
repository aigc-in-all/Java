package designpatterns.adapter;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:30:20
 * @version V1.0
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }

}
