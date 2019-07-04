/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/07/04 21:57
 * Client.java
 */
// 折扣类：抽象策略类
interface Discount {
    double calculate(double price);
}

// 学生票折扣类：具体策略类
class StudentDiscount implements Discount {

    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}

// 儿童票折扣类：具体策略类
class ChildrenDiscount implements Discount {

    public double calculate(double price) {
        System.out.println("儿童票：");
        return price - 10;
    }
}

// VIP会员票折扣类：具体策略类
class VIPDiscount implements Discount {

    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}

// 电影票类：环境类
class MovieTicket {

    private double price;
    private Discount discount; // 维持一个对抽象折扣类的引用

    // 注入一个折扣类对象
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        // 调用折扣类的折扣价计算方法
        return discount.calculate(price);
    }
}

public class Client {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        Discount discount;
        discount = new StudentDiscount(); //读取配置文件并反射生成具体折扣对象
        mt.setDiscount(discount); //注入折扣对象

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);

        Discount discount1;
        discount1 = new VIPDiscount(); //读取配置文件并反射生成具体折扣对象
        mt.setDiscount(discount1); //注入折扣对象

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}
