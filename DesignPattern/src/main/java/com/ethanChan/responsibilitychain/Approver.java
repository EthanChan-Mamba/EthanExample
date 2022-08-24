package com.ethanChan.responsibilitychain;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Approver.java
 * @Description TODO
 * @createTime 2022-05-29 13:41
 */
public abstract class Approver {
    // 下一个处理者
    Approver approver;
    // 名字
    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
