# 工厂方法模式

[工厂三兄弟之工厂方法模式（一）：日志记录器的设计](https://blog.csdn.net/lovelion/article/details/9306457)

[工厂三兄弟之工厂方法模式（二）：工厂方法模式概述](https://blog.csdn.net/lovelion/article/details/9306745)

[工厂三兄弟之工厂方法模式（三）：日志记录器的工厂方法模式解决方案，反射与配置文件](https://blog.csdn.net/lovelion/article/details/9307137)

[工厂三兄弟之工厂方法模式（四）：重载的工厂方法，工厂方法的隐藏，工厂方法模式总结](https://blog.csdn.net/lovelion/article/details/9307561)

```aidl
    工厂方法模式(Factory Method Pattern)：定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。
工厂方法模式又简称为工厂模式(Factory Pattern)，又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式(Polymorphic Factory Pattern)。
工厂方法模式是一种类创建型模式。
    工厂方法模式提供一个抽象工厂接口来声明抽象工厂方法，而由其子类来具体实现工厂方法，创建具体的产品对象。
    
    在工厂方法模式结构图中包含如下几个角色：
    
       ● Product（抽象产品）：它是定义产品的接口，是工厂方法模式所创建对象的超类型，也就是产品对象的公共父类。

       ● ConcreteProduct（具体产品）：它实现了抽象产品接口，某种类型的具体产品由专门的具体工厂创建，具体工厂和具体产品之间一一对应。

       ● Factory（抽象工厂）：在抽象工厂类中，声明了工厂方法(Factory Method)，用于返回一个产品。抽象工厂是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。

       ● ConcreteFactory（具体工厂）：它是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户端调用，返回一个具体产品类的实例。

       与简单工厂模式相比，工厂方法模式最重要的区别是引入了抽象工厂角色，抽象工厂可以是接口，也可以是抽象类或者具体类
```