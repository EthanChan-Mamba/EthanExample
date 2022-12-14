package com.ethanChan.responsibilitychain;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DepartmentApprover.java
 * @Description TODO
 * @createTime 2022-05-29 13:45
 */
public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() >= 30000) {
            System.out.println("请求编号" + purchaseRequest.getId() + "被" + this.name + "处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
