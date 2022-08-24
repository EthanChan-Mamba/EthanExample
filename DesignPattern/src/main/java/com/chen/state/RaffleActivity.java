package com.chen.state;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RaffleActivity.java
 * @Description 抽奖活动
 * @createTime 2022-05-13 14:32
 */
public class RaffleActivity {
    // state表示活动状态，变化
    State state = null;

    // 奖品数量
    int count = 0;

    CanRaffleState canRaffleState = new CanRaffleState(this);
    DispenseOutState dispenseOutState = new DispenseOutState(this);
    DispenseState dispenseState = new DispenseState(this);
    NoRaffleState noRaffleState = new NoRaffleState(this);

    //构造器
    //1.初始化当前的状态为 noRaffleState（即不能抽奖的状态）
    //2.初始化奖品的数量
    public RaffleActivity( int count) {
        this.state = getNoRaffleState();
        this.count = count;
    }
    //扣分，调用当前状态的 deductMoney
    public void debuctMoney() {
        state.deductMoney();
    }
    //抽奖
    public void raffle() {
        // ∥如果当前的状态是抽奖成功
        if (state.raffle()) {
            // 领取奖品
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // 每领取一次, count--
    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CanRaffleState getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(CanRaffleState canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public DispenseOutState getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(DispenseOutState dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public NoRaffleState getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(NoRaffleState noRaffleState) {
        this.noRaffleState = noRaffleState;
    }
}
