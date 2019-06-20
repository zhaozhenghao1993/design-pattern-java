/**
 * 🙃
 * 🙃 游戏角色创建控制器：指挥者 Director
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/20 22:04
 * ActorController.java
 */

public class ActorController {

    public Actor construct(ActorBuilder ab) {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();

        // 通过钩子方法来控制产品的构建
        if (!ab.isBareheaded()) {
            ab.buildHairstyle();
        }

        actor = ab.createActor();
        return actor;
    }
}
