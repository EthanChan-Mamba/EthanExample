package com.ethanChan.shardingMybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
// TODO: 需要分表

/**
 * 还款计划表(分表)
 */
@Data
@ToString
@Accessors(chain = true)
@TableName("o_repayment_plan")
public class RepaymentPlan implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "plan_id", type = IdType.INPUT)
    private Long planId;
    /**
     * 内部订单id
     */
    @TableField("order_id")
    private Long orderId;
    /**
     * 渠道id
     */
    @TableField("channel_id")
    private Integer channelId;
    /**
     * 渠道订单号
     */
    @TableField("order_no")
    private String orderNo;
    /**
     * 期数
     */
    @TableField("nper")
    private Integer nper;
    /**
     * 应还本金金额(单位分)
     */
    @TableField("due_principal_fee")
    private Integer duePrincipalFee;
    /**
     * 应还利息(服务费)金额(单位分)
     */
    @TableField("due_interest_fee")
    private Integer dueInterestFee;
    /**
     * 应还罚息(违约金)金额(单位分)
     */
    @TableField("due_penalty_fee")
    private Integer duePenaltyFee;
    /**
     * 每期应还总金额（单位分，本金+利息+罚息）
     */
    @TableField("each_repayment_fee")
    private Integer eachRepaymentFee;
    /**
     * 应还日期+23:59:59
     */
    @TableField("due_date")
    private Date dueDate;
    /**
     * 计划状态待还 repaying
     * 已还 finish
     * 取消 cancel
     * 还款不足 not_enough
     */
    @TableField("repay_status")
    private String repayStatus;
    /**
     * 还款流水号
     */
    @TableField("flow_no")
    private String flowNo;
    /**
     * 还款时间
     */
    @TableField("flow_time")
    private Date flowTime;
    /**
     * 实还本金，分
     */
    @TableField("repayed_principal_fee")
    private Integer repayedPrincipalFee;
    /**
     * 实还利息(服务费)，单位:分
     */
    @TableField("repayed_interest_fee")
    private Integer repayedInterestFee;
    /**
     * 实还罚息(违约金)，单位:分
     */
    @TableField("repayed_penalty_fee")
    private Integer repayedPenaltyFee;
    /**
     * 实还结清手续费，单位:分
     */
    @TableField("repayed_service_fee")
    private Integer repayedServiceFee;
    /**
     * 实还总金额，单位:分  本金+利息+罚息+结清手续费
     */
    @TableField("repayed_current_fee")
    private Integer repayedCurrentFee;
    /**
     * 还款免除 1 是 y0 否 n
     */
    @TableField("repayed_avoid")
    private String repayedAvoid;
    /**
     * 减免罚息(违约金)，单位:分
     */
    @TableField("reduce_penalty_fee")
    private Integer reducePenaltyFee;
    /**
     * 减免结清手续费，单位:分
     */
    @TableField("reduce_service_fee")
    private Integer reduceServiceFee;
    /**
     * 是否部份还款y 是n 否
     */
    @TableField("is_part_repayed")
    private String isPartRepayed;
    /**
     * 还款类型：普通还款，normal逾期还款，overdue逾期结清,   settle提前结清,   prepay异常结清   unusual
     */
    @TableField("repayed_type")
    private String repayedType;
    /**
     * 历史逾期天数，不归0
     */
    @TableField("history_over_days")
    private Integer historyOverDays;
    /**
     * 当前是否逾期1是 0否
     */
    @TableField("is_over")
    private Integer isOver;
    /**
     * 当前逾期天数
     */
    @TableField("over_days")
    private Integer overDays;
    /**
     * 分表依赖列，订单放款yyyyMM
     */
    @TableField("sharding")
    private String sharding;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 计划状态待还 repaying已还 finish取消 cancelnot_enough 还款不足
     */
    public enum RepayStatus {
        REPAYING("repaying"),
        FINISH("finish"),
        CANCEL("cancel"),
        NOT_ENOUGH("not_enough");

        private String val;

        RepayStatus(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    /**
     * 还款免除 1 是 y0 否 n
     */
    public enum RepayedAvoid {
        N("n"),
        Y("y");

        private String val;

        RepayedAvoid(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    /**
     * 是否部份还款y 是n 否
     */
    public enum IsPartRepayed {
        Y("y"),
        N("n");

        private String val;

        IsPartRepayed(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    /**
     * 还款类型：普通还款，normal逾期还款，overdue逾期结清,   settle提前结清,   prepay异常结清   unusual
     */
    public enum RepayedType {
        NORMAL("normal"),
        OVERDUE("overdue"),
        SETTLE("settle"),
        PREPAY("prepay");

        private String val;

        RepayedType(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

}
