package com.chen.state;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DispenseState.java
 * @Description 奖品发放完毕
 * @createTime 2022-05-13 14:42
 */
public class DispenseOutState extends State {

    // 初始化传入活动时用，扣除积分后改变状态
    RaffleActivity raffleActivity;

    public DispenseOutState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品送完了");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品送完了");
        return false;
    }

    // 发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("奖品送完了");
    }
}
