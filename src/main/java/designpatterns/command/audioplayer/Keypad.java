package designpatterns.command.audioplayer;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年7月30日 下午7:28:22
 * @version V1.0
 */
// 请求者角色，由键盘类扮演
public class Keypad {
    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    public void play() {
        playCommand.execute();
    }

    public void rewind() {
        rewindCommand.execute();
    }

    public void stop() {
        stopCommand.execute();
    }
}
