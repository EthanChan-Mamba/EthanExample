package com.chen.memento.game;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName GameRole.java
 * @Description TODO
 * @createTime 2022-05-22 20:35
 */
public class GameRole {
    // 攻击力
    private int vit;
    // 防御力
    private int def;

    // 根据当前状态得到Memento
    public Memento createMemento() {
        return new Memento(vit, def);
    }

    public void recoverGameRoleFromMemento(Memento memento) {
        this.def = memento.getDef();
        this.vit = memento.getVit();
    }

    // 当前状态
    public void display() {
        System.out.println(this.def + ";" + this.vit);
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
