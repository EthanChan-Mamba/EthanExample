package com.ethanChan.state;

import java.util.Random;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DispenseState.java
 * @Description 可以抽奖状态
 * @createTime 2022-05-13 14:42
 */
public class CanRaffleState extends State {

    // 初始化传入活动时用，扣除积分后改变状态
    RaffleActivity raffleActivity;

    public CanRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    // 已经扣除了积分，不能再扣
    @Override
    public void deductMoney() {
        System.out.println("已经扣取了积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，稍等");
        Random random = new Random();
        int num = random.nextInt(10);
        // 10%中奖机会
        if (num == 0) {
            // 改变活动状态为发放奖品
            raffleActivity.setState(raffleActivity.getDispenseState());
            return true;
        } else {
            System.out.println("很遗憾没有中奖");
            // 改变活动状态为不能抽奖
            raffleActivity.setState(raffleActivity.getNoRaffleState());
            return false;
        }
    }

    // 不能发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("没中奖");
    }
}
