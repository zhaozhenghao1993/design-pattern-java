/**
 * 🙃
 * 🙃 在命令模式中，我们可以通过调用一个命令对象的execute()方法来实现对请求的处理，
 *      如果需要撤销(Undo)请求，可通过在命令类中增加一个逆向操作来实现。
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/25 22:15
 * Undo.java
 */
// 加法类：请求接收者
class Adder {

    private int num = 0; // 定义初始值为0

    public int add(int value) {
        num += value;
        return num;
    }
}

// 抽象命令类
abstract class AbstractCommand {
    public abstract int execute(int value); // 声明命令执行方法execute()
    public abstract int undo(); // 声明撤销方法undo()
}

// 具体命令类
class ConcreteCommand extends AbstractCommand {

    private Adder adder = new Adder();
    private int value;

    // 实现抽象命令类中声明的execute()方法，调用加法类的加法操作
    public int execute(int value) {
        this.value = value;
        return adder.add(value);
    }

    // 实现抽象命令类中声明的undo()方法，通过加一个相反数来实现加法的逆向操作
    public int undo() {
        return adder.add(-value);
    }
}

// 计算器界面类：请求发送者
class CalculatorForm {
    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    // 调用命令对象的execute()方法执行运算
    public void compute(int value) {
        int i = command.execute(value);
        System.out.println("执行运算，运算结果为：" + i);
    }

    //调用命令对象的undo()方法执行撤销
    public void undo() {
        int i = command.undo();
        System.out.println("执行撤销，运算结果为：" + i);
    }
}


public class Undo {

    public static void main(String[] args) {
        CalculatorForm form = new CalculatorForm();
        AbstractCommand command;
        command = new ConcreteCommand();
        form.setCommand(command);

        form.compute(10);
        form.compute(5);
        form.compute(10);
        form.undo();
        form.undo(); // 只支持一次撤销
    }
}

/**
 *      需要注意的是在本实例中只能实现一步撤销操作，因为没有保存命令对象的历史状态，
 * 可以通过引入一个命令集合或其他方式来存储每一次操作时命令的状态，从而实现多次撤销操作。
 * 除了Undo操作外，还可以采用类似的方式实现恢复(Redo)操作，即恢复所撤销的操作（或称为二次撤销）。
 */
