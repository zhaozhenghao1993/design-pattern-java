# 抽象工厂模式

[工厂三兄弟之抽象工厂模式（一）：界面皮肤库的初始设计](https://blog.csdn.net/lovelion/article/details/9319181)

[工厂三兄弟之抽象工厂模式（二）：产品等级结构与产品族](https://blog.csdn.net/lovelion/article/details/9319323)

[工厂三兄弟之抽象工厂模式（三）：抽象工厂模式概述](https://blog.csdn.net/lovelion/article/details/9319423)

[工厂三兄弟之抽象工厂模式（四）：界面皮肤库的抽象工厂模式解决方案](https://blog.csdn.net/lovelion/article/details/9319481)

[工厂三兄弟之抽象工厂模式（五）：“开闭原则”的倾斜性，抽象工厂模式总结](https://blog.csdn.net/lovelion/article/details/9319571)

```aidl
     抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。
抽象工厂模式又称为Kit模式，它是一种对象创建型模式。

     在抽象工厂模式结构图中包含如下几个角色：
    
       ● AbstractFactory（抽象工厂）：它声明了一组用于创建一族产品的方法，每一个方法对应一种产品。

       ● ConcreteFactory（具体工厂）：它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。

       ● AbstractProduct（抽象产品）：它为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法。

       ● ConcreteProduct（具体产品）：它定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。

       在抽象工厂中声明了多个工厂方法，用于创建不同类型的产品，抽象工厂可以是接口，也可以是抽象类或者具体类
```