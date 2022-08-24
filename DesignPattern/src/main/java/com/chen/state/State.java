package com.chen.state;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName State.java
 * @Description 状态抽象类
 * @createTime 2022-05-13 14:29
 */
public abstract class State {
    // 扣除积分-50
    public abstract void deductMoney();

    // 是否抽中奖品
    public abstract boolean raffle();

    // 发放奖品
    public abstract void dispensePrize();
}
