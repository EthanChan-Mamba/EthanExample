package com.ethanChan.state;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DispenseState.java
 * @Description 发放奖品状态
 * @createTime 2022-05-13 14:42
 */
public class DispenseState extends State {

    // 初始化传入活动时用，扣除积分后改变状态
    RaffleActivity raffleActivity;

    public DispenseState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    // 发放奖品
    @Override
    public void dispensePrize() {
        if (raffleActivity.getCount() > 0 ) {
            System.out.println("恭喜中奖了");
            raffleActivity.setState(raffleActivity.getNoRaffleState());
        } else {
            System.out.println("奖品已送完");
            // 改变状态为奖品发送完毕，后面就不抽奖了
            raffleActivity.setState(raffleActivity.getDispenseOutState());
            System.out.println("抽奖活动已结束");
        }

    }
}
