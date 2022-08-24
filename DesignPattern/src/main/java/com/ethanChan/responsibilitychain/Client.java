package com.ethanChan.responsibilitychain;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-29 13:49
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);

        // 创建相关审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("陈副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("佟校长");

        // 需要将各个审批级别的下一个设置好，构成环状
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        // 处理请求
        departmentApprover.processRequest(purchaseRequest);
    }
}
