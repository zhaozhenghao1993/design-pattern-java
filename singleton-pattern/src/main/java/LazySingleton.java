/**
 * 🙃
 * 🙃 懒汉式单例类与线程锁定
 * 🙃 懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自行实例化，这种技术又称为延迟加载(Lazy Load)技术，
 *    即需要的时候再加载实例，为了避免多个线程同时调用getInstance()方法，我们可以使用关键字synchronized
 *
 *    双重检查锁定(Double-Check Locking)
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/18 21:27
 * LazySingleton.java
 */

public class LazySingleton {

    private volatile static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        // 第一重判断
        if (lazySingleton == null) {
            // 锁定代码块
            synchronized (LazySingleton.class) {
                // 第二重判断
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}

/*
*
*  需要注意的是，如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
*  被volatile修饰的成员变量可以确保多个线程都能够正确处理，且该代码只能在JDK 1.5及以上版本中才能正确执行。
*  由于volatile关键字会屏蔽Java虚拟机所做的一些代码优化，可能会导致系统运行效率降低，因此即使使用双重检查锁定来实现单例模式也不是一种完美的实现方式。
*
* */
