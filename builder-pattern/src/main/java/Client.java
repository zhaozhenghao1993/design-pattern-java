/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/20 22:07
 * Client.java
 */

public class Client {

    public static void main(String[] args) {
        // 针对抽象建造者编程
        ActorBuilder ab = new AngelBuilder();

        ActorController ac = new ActorController();
        Actor actor;
        // 通过指挥者创建完整的建造者对象
        actor = ac.construct(ab);

        String type = actor.getType();
        System.out.println(type + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getCostume());
        System.out.println("发型：" + actor.getHairstyle());
    }
}
