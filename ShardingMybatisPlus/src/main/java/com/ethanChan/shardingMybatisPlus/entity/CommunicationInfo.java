package com.ethanChan.shardingMybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 通讯信息秘钥表
 */
@Data
@ToString
@Accessors(chain = true)
@TableName("b_communication_info")
public class CommunicationInfo implements Serializable {

    /**
     * 主键
     */
    @TableId("info_id")
    private Integer infoId;
    /**
     * 账号
     */
    @TableField("info_account")
    private String infoAccount;
    /**
     * 名称
     */
    @TableField("info_name")
    private String infoName;
    /**
     * 系统请求号
     */
    @TableField("request_no")
    private String requestNo;
    /**
     * 对称秘钥
     */
    @TableField("deskey")
    private String deskey;
    /**
     * 公钥
     */
    @TableField("public_key")
    private String publicKey;
    /**
     * 私钥
     */
    @TableField("private_key")
    private String privateKey;
    /**
     * 通讯域名
     */
    @TableField("url")
    private String url;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}
