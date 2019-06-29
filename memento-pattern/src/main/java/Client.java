import java.util.ArrayList;
import java.util.List;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/29 21:55
 * Client.java
 */

// 象棋棋子类：原发器
class Chessman {
    private String label;
    private int x;
    private int y;

    public Chessman(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // 保存状态
    public ChessmanMemento save() {
        return new ChessmanMemento(this.label, this.x, this.y);
    }

    //恢复状态
    public void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }
}


// 象棋棋子备忘录类：备忘录
class ChessmanMemento {
    private String label;
    private int x;
    private int y;

    public ChessmanMemento(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLabel() {
        return (this.label);
    }

    public int getX() {
        return (this.x);
    }

    public int getY() {
        return (this.y);
    }
}

class MementoCaretaker {
    //定义一个集合来存储多个备忘录
    private List<ChessmanMemento> mementolist = new ArrayList();

    public ChessmanMemento getMemento(int i) {
        return mementolist.get(i);
    }

    public void setMemento(ChessmanMemento memento) {
        mementolist.add(memento);
    }
}

public class Client {

    private static int index = -1; //定义一个索引来记录当前状态所在位置

    private static MementoCaretaker mementoCaretaker = new MementoCaretaker();

    public static void main(String[] args) {
        /* MementoCaretaker mementoCaretaker = new MementoCaretaker();
        Chessman chessman = new Chessman("车",1,1);
        display(chessman);
        mementoCaretaker.setMemento(chessman.save()); // 保存状态
        chessman.setY(4);
        display(chessman);
        mementoCaretaker.setMemento(chessman.save()); // 保存状态
        display(chessman);
        chessman.setY(5);
        display(chessman);
        System.out.println("******悔棋******");
        chessman.restore(mementoCaretaker.getMemento()); //恢复状态
        display(chessman); */

        Chessman chess = new Chessman("车",1,1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);
        undo(chess,index);
        undo(chess,index);
        redo(chess,index);
        redo(chess,index);
    }

    /*public static void display(Chessman chessman) {
        System.out.println("棋子" + chessman.getLabel() + "当前位置为："
                + "第" + chessman.getX() + "行"
                + "第" + chessman.getY() + "列。");
    }*/

    // 下棋
    public static void play(Chessman chessman) {
        mementoCaretaker.setMemento(chessman.save()); // 保存备忘录
        index ++;
        System.out.println("棋子" + chessman.getLabel() + "当前位置为："
                + "第" + chessman.getX() + "行"
                + "第" + chessman.getY() + "列。");
    }

    // 悔棋
    public static void undo(Chessman chess,int i) {
        System.out.println("******悔棋******");
        index --;
        chess.restore(mementoCaretaker.getMemento(i-1)); //撤销到上一个备忘录
        System.out.println("棋子" + chess.getLabel() + "当前位置为："
                + "第" + chess.getX() + "行"
                + "第" + chess.getY() + "列。");
    }

    // 撤销悔棋
    public static void redo(Chessman chess,int i) {
        System.out.println("******撤销悔棋******");
        index ++;
        chess.restore(mementoCaretaker.getMemento(i+1)); //恢复到下一个备忘录
        System.out.println("棋子" + chess.getLabel() + "当前位置为："
                + "第" + chess.getX() + "行"
                + "第" + chess.getY() + "列。");
    }
}
