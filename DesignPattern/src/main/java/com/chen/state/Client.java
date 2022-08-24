package com.chen.state;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-13 16:09
 */
public class Client {
    public static void main(String[] args) {
        RaffleActivity raffleActivity = new RaffleActivity(1);

        for (int i = 0; i < 30; i++) {
            System.out.println("第" + (i + 1) + "次抽奖");
            // 参加抽奖，点击扣除积分
            raffleActivity.debuctMoney();

            // 第二步抽奖
            raffleActivity.raffle();
        }
    }
}
