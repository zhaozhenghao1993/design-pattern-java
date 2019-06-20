/**
 * 🙃
 * 🙃 恶魔角色建造器：具体建造者
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/20 21:59
 * DevilBuilder.java
 */

public class DevilBuilder extends ActorBuilder {

    public void buildType() {
        actor.setType("恶魔");
    }

    public void buildSex() {
        actor.setSex("妖");
    }

    public void buildFace() {
        actor.setFace("丑陋");
    }

    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }

    // 覆盖钩子方法
    @Override
    public boolean isBareheaded() {
        return true;
    }
}
