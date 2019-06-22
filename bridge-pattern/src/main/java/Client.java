/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/22 20:13
 * Client.java
 */

//像素矩阵类：辅助类，各种格式的文件最终都被转化为像素矩阵，不同的操作系统提供不同的方式显示像素矩阵
class Matrix {
    //此处代码省略
}

// 抽象图像类： 抽象类
abstract class Image {
    protected ImageImpl impl;

    public void setImpl(ImageImpl impl) {
        this.impl = impl;
    }

    public abstract void parseFile(String fileName);
}

// 抽象操作系统实现类：实现类接口
interface ImageImpl {
    void doPaint(Matrix m);  //显示像素矩阵m
}

//Windows操作系统实现类：具体实现类
class WindowsImpl implements ImageImpl {
    public void doPaint(Matrix m) {
        //调用Windows系统的绘制函数绘制像素矩阵
        System.out.print("在Windows操作系统中显示图像：");
    }
}

//Linux操作系统实现类：具体实现类
class LinuxImpl implements ImageImpl {
    public void doPaint(Matrix m) {
        //调用Linux系统的绘制函数绘制像素矩阵
        System.out.print("在Linux操作系统中显示图像：");
    }
}

//Unix操作系统实现类：具体实现类
class UnixImpl implements ImageImpl {
    public void doPaint(Matrix m) {
        //调用Unix系统的绘制函数绘制像素矩阵
        System.out.print("在Unix操作系统中显示图像：");
    }
}


//JPG格式图像：扩充抽象类
class JPGImage extends Image {

    public void parseFile(String fileName) {
        //模拟解析JPG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为JPG。");
    }
}

//PNG格式图像：扩充抽象类
class PNGImage extends Image {
    public void parseFile(String fileName) {
        //模拟解析PNG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为PNG。");
    }
}

//BMP格式图像：扩充抽象类
class BMPImage extends Image {
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为BMP。");
    }
}

//GIF格式图像：扩充抽象类
class GIFImage extends Image {
    public void parseFile(String fileName) {
        //模拟解析GIF文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为GIF。");
    }
}

public class Client {

    public static void main(String[] args) {
        Image image;
        ImageImpl impl;
        image = new JPGImage();
        impl = new WindowsImpl();
        image.setImpl(impl);
        image.parseFile("小龙女");
    }
}
