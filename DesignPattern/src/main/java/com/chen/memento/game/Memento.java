package com.chen.memento.game;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Memento.java
 * @Description TODO
 * @createTime 2022-05-22 20:31
 */
public class Memento {
    // 攻击力
    private int vit;
    // 防御力
    private int def;

    public Memento(int vit, int def) {
        this.vit = vit;
        this.def = def;
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
