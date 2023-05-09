package com.ethanChan.springbooteasyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ethanChan.springbooteasyexcel.entity.Member;

/**
 * @ClassName MemberExcelListener.java
 * @Description 基于监听导入实现
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-09 18:05
 */
public class MemberExcelListener extends AnalysisEventListener<Member> {

    @Override
    public void invoke(Member member, AnalysisContext analysisContext) {
        // do something
        System.out.println("读取Member=" + member);
        // do something
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // do something
        System.out.println("读取Excel完毕");
        // do something
    }
}
