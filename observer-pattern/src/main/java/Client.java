import java.util.ArrayList;
import java.util.List;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/30 17:03
 * Client.java
 */

// 抽象观察类
interface Observer {
    String getName();
    void setName(String name);
    void help(); // 声明支援盟友方法
    void beAttacked(AllyControlCenter acc); // 声明遭受攻击方法
}

// 战队成员类：具体观察者类
class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name= name;
    }

    // 支援盟友方法的实现
    public void help() {
        System.out.println("坚持住，" + this.name + "来救你！");
    }

    // 遭受攻击方法的实现，当遭受攻击时将调用战队控制中心类的通知方法notifyObserver()来通知盟友
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name + "被攻击！");
        acc.notifyObserver(name);
    }
}

// 战队控制中心类：目标类
abstract class AllyControlCenter {
    protected String allyName; // 战队名称
    protected List<Observer> players = new ArrayList<Observer>(); // 定义一个集合用于存储战队成员

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    // 注册方法
    public void join(Observer obs) {
        System.out.println(obs.getName() + "加入" + this.allyName + "战队！");
        players.add(obs);
    }

    //注销方法
    public void quit(Observer obs) {
        System.out.println(obs.getName() + "退出" + this.allyName + "战队！");
        players.remove(obs);
    }

    //声明抽象通知方法
    public abstract void notifyObserver(String name);
}

class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "战队组建成功！");
        System.out.println("----------------------------");
        this.allyName = allyName;
    }

    public void notifyObserver(String name) {
        System.out.println(this.allyName + "战队紧急通知，盟友" + name + "遭受敌人攻击！");
        //遍历观察者集合，调用每一个盟友（自己除外）的支援方法
        for(Object obs : players) {
            if (!((Observer)obs).getName().equalsIgnoreCase(name)) {
                ((Observer)obs).help();
            }
        }
    }
}


public class Client {
    public static void main(String[] args) {
        //定义观察目标对象
        AllyControlCenter acc;
        acc = new ConcreteAllyControlCenter("金庸群侠");

        //定义四个观察者对象
        Observer player1,player2,player3,player4;

        player1 = new Player("杨过");
        acc.join(player1);

        player2 = new Player("令狐冲");
        acc.join(player2);

        player3 = new Player("张无忌");
        acc.join(player3);

        player4 = new Player("段誉");
        acc.join(player4);

        // 某成员遭受攻击
        player1.beAttacked(acc);
    }
}
