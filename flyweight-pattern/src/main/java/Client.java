import java.util.HashMap;
import java.util.Map;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/23 19:37
 * Client.java
 */

// 为其棋子类：抽象享元类
abstract class IgoChessman {
    public abstract String getColor();

    public void display(Coordinates coordinates) {
        System.out.println("棋子颜色：" + this.getColor()
                + "，棋子位置：" + coordinates.getX()
                + "，" + coordinates.getY());
    }
}

//黑色棋子类：具体享元类
class BlackIgoChessman extends IgoChessman {

    public String getColor() {
        return "黑色";
    }
}

//白色棋子类：具体享元类
class WhiteIgoChessman extends IgoChessman {

    public String getColor() {
        return "白色";
    }
}

//坐标类：外部状态类
class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

// 围棋棋子工厂类：享元工厂类，使用单例模式进行设计
class IgoChessmanFactory {

    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Map<String, Object> map; //使用hashmap来存储享元对象，充当享元池

    private IgoChessmanFactory() {
        map = new HashMap();
        IgoChessman black,white;
        black = new BlackIgoChessman();
        map.put("b",black);
        white = new WhiteIgoChessman();
        map.put("w",white);
    }

    //返回享元工厂类的唯一实例
    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    //通过key来获取存储在hashmap中的享元对象
    public static IgoChessman getIgoChessman(String color) {
        return (IgoChessman)map.get(color);
    }
}

public class Client {
    public static void main(String[] args) {
        IgoChessman black1,black2,black3,white1,white2;
        IgoChessmanFactory factory;

        //获取享元工厂对象
        factory = IgoChessmanFactory.getInstance();

        //通过享元工厂获取三颗黑子
        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");
        System.out.println("判断两颗黑子是否相同：" + (black1==black2));

        //通过享元工厂获取两颗白子
        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同：" + (white1==white2));

        //显示棋子
        black1.display(new Coordinates(1,2));
        black2.display(new Coordinates(3,4));
        black3.display(new Coordinates(1,3));
        white1.display(new Coordinates(2,5));
        white2.display(new Coordinates(2,4));
    }
}
