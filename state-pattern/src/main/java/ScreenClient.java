/**
 * 🙃
 * 🙃 用户单击“放大镜”按钮之后屏幕将放大一倍，再点击一次“放大镜”按钮屏幕再放大一倍，
 * 第三次点击该按钮后屏幕将还原到默认大小。
 * 🙃  可以考虑使用状态模式来设计该屏幕放大镜工具，
 * 我们定义三个屏幕状态类NormalState、LargerState和LargestState来对应屏幕的三种状态，
 * 分别是正常状态、二倍放大状态和四倍放大状态，屏幕类Screen充当环境类
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/07/01 22:15
 * ScreenClient.java
 */

// 屏幕类
class Screen {

    // 枚举所有的状态，currentState表示当前状态
    private ScreenState currentState, normalState, largerState, largestState;

    public Screen() {
        this.normalState = new NormalScreenState(); //创建正常状态对象
        this.largerState = new LargerScreenState(); //创建二倍放大状态对象
        this.largestState = new LargerScreenState(); //创建四倍放大状态对象
        this.currentState = normalState; //设置初始状态
        this.currentState.display();
    }

    public void setState(ScreenState state) {
        this.currentState = state;
    }

    //单击事件处理方法，封转了对状态类中业务方法的调用和状态的转换
    public void onClick() {
        if (this.currentState == normalState) {
            this.setState(largerState);
            this.currentState.display();
        }
        else if (this.currentState == largerState) {
            this.setState(largestState);
            this.currentState.display();
        }
        else if (this.currentState == largestState) {
            this.setState(normalState);
            this.currentState.display();
        }
    }
}

//抽象状态类
abstract class ScreenState {
    public abstract void display();
}

//正常状态类
class NormalScreenState extends ScreenState{
    public void display() {
        System.out.println("正常大小！");
    }
}

//二倍状态类
class LargerScreenState extends ScreenState{
    public void display() {
        System.out.println("二倍大小！");
    }
}

//四倍状态类
class LargestScreenState extends ScreenState {
    public void display() {
        System.out.println("四倍大小！");
    }
}

public class ScreenClient {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.onClick();
        screen.onClick();
        screen.onClick();
    }
}
