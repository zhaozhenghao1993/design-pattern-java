package DeepClone;

import java.io.*;

/**
 * 🙃
 * 🙃 深克隆
 * 🙃
 *
 * 在深克隆中，无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，深克隆将原型对象的所有引用对象也复制一份给克隆对象。
 * 简单来说，在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制
 *
 * 在Java语言中，如果需要实现深克隆，可以通过序列化(Serialization)等方式来实现。序列化就是将对象写到流的过程，
 * 写到流中的对象是原有对象的一个拷贝，而原对象仍然存在于内存中。通过序列化实现的拷贝不仅可以复制对象本身，
 * 而且可以复制其引用的成员对象，因此通过序列化将对象写到一个流中，再从流里将其读出来，可以实现深克隆。
 * 需要注意的是能够实现序列化的对象其类必须实现Serializable接口，否则无法实现序列化操作。
 * 下面我们使用深克隆技术来实现工作周报和附件对象的复制，由于要将附件对象和工作周报对象都写入流中，因此两个类均需要实现Serializable接口
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/19 22:29
 * WeeklyLog.java
 */

public class WeeklyLog implements Serializable {

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

    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {
        // 输出一段流，将对象写入流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 将上面的流输入，并转化为对象，将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog)ois.readObject();
    }
}

class Attachment implements Serializable {
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
        WeeklyLog log_previous, log_new = null;
        log_previous = new WeeklyLog();
        Attachment attachment = new Attachment(); //创建附件对象
        attachment.setName("A附件");
        log_previous.setAttachment(attachment); //将附件添加到周报中
        try {
            log_new = log_previous.deepClone(); //调用克隆方法创建克隆对象
        } catch (Exception e) {
            System.err.println("克隆失败");
        }
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

