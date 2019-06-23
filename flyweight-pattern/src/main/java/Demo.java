/**
 * 🙃
 * 🙃  JDK类库中的String类使用了享元模式，我们通过如下代码来加以说明：
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/23 20:03
 * Demo.java
 */

public class Demo {
    public static void main(String[] args) {
        String  str1 = "abcd";
        String  str2 = "abcd";
        String  str3 = "ab" + "cd";
        String  str4 = "ab";
        str4  += "cd";

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        str2 += "e";
        System.out.println(str1 == str2);
    }
}
