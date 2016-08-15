package designpatterns.command.audioplayer;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:24:42
 * @version V1.0
 */
// 接收者角色，由录音机类扮演
public class AudioPlayer {

    public void play() {
        System.out.println("播放...");
    }

    public void rewind() {
        System.out.println("倒带...");
    }

    public void stop() {
        System.out.println("停止...");
    }

}
