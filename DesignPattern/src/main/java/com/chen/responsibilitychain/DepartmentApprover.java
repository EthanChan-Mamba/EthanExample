package com.chen.responsibilitychain;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DepartmentApprover.java
 * @Description TODO
 * @createTime 2022-05-29 13:45
 */
public class DepartmentApprover extends Approver {
    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println("请求编号" + purchaseRequest.getId() + "被" + this.name + "处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
