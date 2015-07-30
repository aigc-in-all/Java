package designpatterns.adapter;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午8:30:20
 * @version V1.0
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
      //do nothing
    }

}
