package ShallowClone;

/**
 * 🙃
 * 🙃 浅克隆
 * 🙃
 *
 * 在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；如果原型对象的成员变量是引用类型，
 * 则将引用对象的地址复制一份给克隆对象，也就是说原型对象和克隆对象的成员变量指向相同的内存地址。
 * 简单来说，在浅克隆中，当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制
 *
 * 在Java语言中，通过覆盖Object类的clone()方法可以实现浅克隆。为了让大家更好地理解浅克隆和深克隆的区别，
 * 我们首先使用浅克隆来实现工作周报和附件类的复制
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/19 22:29
 * WeeklyLog.java
 */

public class WeeklyLog implements Cloneable {
    private String name;

    private String date;

    private String content;

    private Attachment attachment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    @Override
    public WeeklyLog clone() {

        Object object = null;
        try {
            object = super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }
}

class Attachment {
    private String name; //附件名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("下载附件，文件名为" + name);
    }
}

class Client {
    public static void main(String[] args) {
        WeeklyLog log_previous, log_new;
        log_previous = new WeeklyLog();
        Attachment attachment = new Attachment(); //创建附件对象
        attachment.setName("A附件");
        log_previous.setAttachment(attachment); //将附件添加到周报中
        log_new = log_previous.clone(); //调用克隆方法创建克隆对象
        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));

        System.out.println(log_previous.getAttachment().getName());

        attachment.setName("B附件");

        System.out.println(log_previous.getAttachment().getName());

        System.out.println(log_new.getAttachment().getName());
    }
}

