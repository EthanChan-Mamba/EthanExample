package com.ethanChan.state;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName NoRaffleState.java
 * @Description 不能抽奖奖状态
 * @createTime 2022-05-13 14:34
 */
public class NoRaffleState extends State {

    // 初始化传入活动时用，扣除积分后改变状态
    RaffleActivity raffleActivity;

    public NoRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    // 当前状态可以扣积分
    // ，扣除后，将状态设置成可以抽奖状态
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分，可以开始抽奖");
        raffleActivity.setState(raffleActivity.getCanRaffleState());
    }

    // 当前状态不能抽奖
    @Override
    public boolean raffle() {
        System.out.println("扣了分才可以抽奖");
        return false;
    }

    // 当前状态不能发奖品
    @Override
    public void dispensePrize() {
        System.out.println("不能发奖品");
    }
}
