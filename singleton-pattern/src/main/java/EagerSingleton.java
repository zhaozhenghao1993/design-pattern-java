/**
 * 🙃
 * 🙃 饿汉模式 由于在定义静态变量的时候实例化单例类，因此在类加载的时候就已经创建了单例对象
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/18 21:24
 * EagerSingleton.java
 */

public class EagerSingleton {

    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
