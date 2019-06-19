/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/19 22:15
 * Prototype.java
 */

public interface Prototype {
}

class ConcretePrototype implements Prototype {

    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public ConcretePrototype clone() {
        Prototype prototype = new ConcretePrototype();
        ((ConcretePrototype) prototype).setAttr(this.attr);
        return (ConcretePrototype) prototype;
    }
}
