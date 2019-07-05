/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/07/05 22:29
 * Client.java
 */

// Account：账户类，充当抽象类。
abstract class Account {

    // 基本方法——具体方法
    public boolean validate(String account, String password) {
        System.out.println("账号：" + account);
        System.out.println("密码：" + password);

        if ("张无忌".equals(account) && "123456".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // 基本方法——抽象方法
    public abstract void calculateInterest();

    //基本方法——具体方法
    public void display() {
        System.out.println("显示利息！");
    }

    //模板方法
    public void handle(String account, String password) {
        if (!validate(account,password)) {
            System.out.println("账户或密码错误！");
            return;
        }
        calculateInterest();
        display();
    }
}

// CurrentAccount：活期账户类，充当具体子类。
class CurrentAccount extends Account {

    // 覆盖父类的抽象基本方法
    public void calculateInterest() {
        System.out.println("按活期利率计算利息！");
    }
}

// SavingAccount：定期账户类，充当具体子类。
class SavingAccount extends Account {

    // 覆盖父类的抽象基本方法
    public void calculateInterest() {
        System.out.println("按定期利率计算利息！");
    }
}

public class Client {
    public static void main(String[] args) {
        Account account = new SavingAccount();
        account.handle("张无忌", "123456");
    }
}
