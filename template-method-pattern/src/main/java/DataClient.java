/**
 * 🙃
 * 🙃 模板方法模式中，在父类中提供了一个定义算法框架的模板方法，
 * 还提供了一系列抽象方法、具体方法和钩子方法，其中钩子方法的引入使得子类可以控制父类的行为。
 * 最简单的钩子方法就是空方法
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/07/05 22:46
 * DataClient.java
 */

abstract class DataViewer {
    // 抽象方法：获取数据
    public abstract void getData();

    // 具体方法：转换数据
    public void convertData() {
        System.out.println("将数据转换为XML格式。");
    }

    // 抽象方法：显示数据
    public abstract void displayData();

    // 钩子方法：判断是否为XML格式的数据
    public boolean isNotXMLData() {
        return true;
    }

    public void process() {
        getData();
        // 如果不是XML格式的数据则进行数据转换
        if (isNotXMLData()) {
            convertData();
        }
        displayData();
    }
}

// 具体子类
class XMLDataViewer extends DataViewer {

    public void getData() {
        System.out.println("从XML文件中获取数据。");
    }

    public void displayData() {
        System.out.println("以柱状图显示数据。");
    }

    @Override
    public boolean isNotXMLData() {
        return false;
    }
}

public class DataClient {
    public static void main(String[] args) {
        DataViewer data = new XMLDataViewer();
        data.process();
    }
}
