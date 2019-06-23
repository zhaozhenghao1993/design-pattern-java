/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/23 16:27
 * Program.java
 */

class SubSystemA {
    public void methodA() {
        // 业务实现代码
        System.out.println("method A");
    }
}

class SubSystemB {
    public void methodB() {
        // 业务实现代码
        System.out.println("method B");
    }
}

class SubSystemC {
    public void methodC() {
        // 业务实现代码
        System.out.println("method C");
    }
}

// 在引入外观类之后，与子系统业务类之间的交互统一由外观类来完成，在外观类中通常存在如下代码
class Facade {
    private SubSystemA obj1 = new SubSystemA();
    private SubSystemB obj2 = new SubSystemB();
    private SubSystemC obj3 = new SubSystemC();

    public void method() {
        obj1.methodA();
        obj2.methodB();
        obj3.methodC();
    }
}

// 由于在外观类中维持了对子系统对象的引用，
// 客户端可以通过外观类来间接调用子系统对象的业务方法，
// 而无须与子系统对象直接交互。引入外观类后，
// 客户端代码变得非常简单，典型代码如下：
public class Program {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
