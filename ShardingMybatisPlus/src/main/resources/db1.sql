/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 01/09/2022 11:34:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for o_repayment_plan_202201
-- ----------------------------
DROP TABLE IF EXISTS `o_repayment_plan_202201`;
CREATE TABLE `o_repayment_plan_202201`  (
  `plan_id` bigint(0) UNSIGNED NOT NULL COMMENT '主键',
  `order_id` bigint(0) UNSIGNED NOT NULL COMMENT '内部订单id',
  `channel_id` int(0) UNSIGNED NOT NULL COMMENT '渠道id',
  `order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道订单号',
  `nper` tinyint(0) NULL DEFAULT NULL COMMENT '期数',
  `due_principal_fee` int(0) NULL DEFAULT 0 COMMENT '应还本金金额(单位分)',
  `due_interest_fee` int(0) NULL DEFAULT NULL COMMENT '应还利息(服务费)金额(单位分)',
  `due_penalty_fee` int(0) NULL DEFAULT 0 COMMENT '应还罚息(违约金)金额(单位分)',
  `each_repayment_fee` int(0) NULL DEFAULT NULL COMMENT '每期应还总金额（单位分，本金+利息+罚息）',
  `due_date` datetime(0) NULL DEFAULT NULL COMMENT '应还日期+23:59:59',
  `repay_status` enum('repaying','finish','cancel','not_enough') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'repaying' COMMENT '计划状态\n待还 repaying\n已还 finish\n取消 cancel\nnot_enough 还款不足',
  `flow_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款流水号',
  `flow_time` datetime(0) NULL DEFAULT NULL COMMENT '还款时间',
  `repayed_principal_fee` int(0) NULL DEFAULT NULL COMMENT '实还本金，分',
  `repayed_interest_fee` int(0) NULL DEFAULT NULL COMMENT '实还利息(服务费)，单位:分',
  `repayed_penalty_fee` int(0) NULL DEFAULT NULL COMMENT '实还罚息(违约金)，单位:分',
  `repayed_service_fee` int(0) NULL DEFAULT NULL COMMENT '实还结清手续费，单位:分',
  `repayed_current_fee` int(0) NULL DEFAULT NULL COMMENT '实还总金额，单位:分  本金+利息+罚息+结清手续费',
  `repayed_avoid` enum('n','y') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'n' COMMENT '还款免除 \r\n1 是 y\r\n0 否 n',
  `reduce_penalty_fee` int(0) NULL DEFAULT NULL COMMENT '减免罚息(违约金)，单位:分',
  `reduce_service_fee` int(0) NULL DEFAULT NULL COMMENT '减免结清手续费，单位:分',
  `is_part_repayed` enum('y','n') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'n' COMMENT '是否部份还款\r\ny 是\r\nn 否',
  `repayed_type` enum('normal','overdue','settle','prepay') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款类型：\n\r\n普通还款，normal\r\n\n逾期还款，overdue\n\r\n逾期结清,   settle\r\n\n提前结清,   prepay\r\n异常结清   unusual\r\n ',
  `history_over_days` int(0) NULL DEFAULT 0 COMMENT '历史逾期天数，不归0',
  `is_over` tinyint(1) NULL DEFAULT NULL COMMENT '当前是否逾期1是 0否',
  `over_days` int(0) NULL DEFAULT NULL COMMENT '当前逾期天数',
  `sharding` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分表依赖列，订单放款yyyyMM',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`plan_id`) USING BTREE,
  UNIQUE INDEX `orp_202206_index`(`order_id`, `nper`) USING BTREE,
  INDEX `orp_202206_order_no_per_index`(`order_no`, `nper`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '还款计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of o_repayment_plan_202201
-- ----------------------------

-- ----------------------------
-- Table structure for o_repayment_plan_202202
-- ----------------------------
DROP TABLE IF EXISTS `o_repayment_plan_202202`;
CREATE TABLE `o_repayment_plan_202202`  (
  `plan_id` bigint(0) UNSIGNED NOT NULL COMMENT '主键',
  `order_id` bigint(0) UNSIGNED NOT NULL COMMENT '内部订单id',
  `channel_id` int(0) UNSIGNED NOT NULL COMMENT '渠道id',
  `order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道订单号',
  `nper` tinyint(0) NULL DEFAULT NULL COMMENT '期数',
  `due_principal_fee` int(0) NULL DEFAULT 0 COMMENT '应还本金金额(单位分)',
  `due_interest_fee` int(0) NULL DEFAULT NULL COMMENT '应还利息(服务费)金额(单位分)',
  `due_penalty_fee` int(0) NULL DEFAULT 0 COMMENT '应还罚息(违约金)金额(单位分)',
  `each_repayment_fee` int(0) NULL DEFAULT NULL COMMENT '每期应还总金额（单位分，本金+利息+罚息）',
  `due_date` datetime(0) NULL DEFAULT NULL COMMENT '应还日期+23:59:59',
  `repay_status` enum('repaying','finish','cancel','not_enough') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'repaying' COMMENT '计划状态\n待还 repaying\n已还 finish\n取消 cancel\nnot_enough 还款不足',
  `flow_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款流水号',
  `flow_time` datetime(0) NULL DEFAULT NULL COMMENT '还款时间',
  `repayed_principal_fee` int(0) NULL DEFAULT NULL COMMENT '实还本金，分',
  `repayed_interest_fee` int(0) NULL DEFAULT NULL COMMENT '实还利息(服务费)，单位:分',
  `repayed_penalty_fee` int(0) NULL DEFAULT NULL COMMENT '实还罚息(违约金)，单位:分',
  `repayed_service_fee` int(0) NULL DEFAULT NULL COMMENT '实还结清手续费，单位:分',
  `repayed_current_fee` int(0) NULL DEFAULT NULL COMMENT '实还总金额，单位:分  本金+利息+罚息+结清手续费',
  `repayed_avoid` enum('n','y') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'n' COMMENT '还款免除 \r\n1 是 y\r\n0 否 n',
  `reduce_penalty_fee` int(0) NULL DEFAULT NULL COMMENT '减免罚息(违约金)，单位:分',
  `reduce_service_fee` int(0) NULL DEFAULT NULL COMMENT '减免结清手续费，单位:分',
  `is_part_repayed` enum('y','n') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'n' COMMENT '是否部份还款\r\ny 是\r\nn 否',
  `repayed_type` enum('normal','overdue','settle','prepay') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款类型：\n\r\n普通还款，normal\r\n\n逾期还款，overdue\n\r\n逾期结清,   settle\r\n\n提前结清,   prepay\r\n异常结清   unusual\r\n ',
  `history_over_days` int(0) NULL DEFAULT 0 COMMENT '历史逾期天数，不归0',
  `is_over` tinyint(1) NULL DEFAULT NULL COMMENT '当前是否逾期1是 0否',
  `over_days` int(0) NULL DEFAULT NULL COMMENT '当前逾期天数',
  `sharding` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分表依赖列，订单放款yyyyMM',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`plan_id`) USING BTREE,
  UNIQUE INDEX `orp_202206_index`(`order_id`, `nper`) USING BTREE,
  INDEX `orp_202206_order_no_per_index`(`order_no`, `nper`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '还款计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of o_repayment_plan_202202
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` int(0) NOT NULL,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_status` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, '大啊', 1, 11112);

-- ----------------------------
-- Table structure for t_order0
-- ----------------------------
DROP TABLE IF EXISTS `t_order0`;
CREATE TABLE `t_order0`  (
  `order_id` int(0) NOT NULL,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_status` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order0
-- ----------------------------
INSERT INTO `t_order0` VALUES (0, '大啊', 1, 11112);
INSERT INTO `t_order0` VALUES (1112, '大啊', 1, 11112);

-- ----------------------------
-- Table structure for t_order1
-- ----------------------------
DROP TABLE IF EXISTS `t_order1`;
CREATE TABLE `t_order1`  (
  `order_id` int(0) NOT NULL,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_status` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order1
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202200
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202200`;
CREATE TABLE `t_order_202200`  (
  `order_id` int(0) NOT NULL,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_status` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_202200
-- ----------------------------
INSERT INTO `t_order_202200` VALUES (0, '大啊', 1, 11112);
INSERT INTO `t_order_202200` VALUES (1112, '大啊', 1, 11112);

-- ----------------------------
-- Table structure for t_order_202201
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202201`;
CREATE TABLE `t_order_202201`  (
  `order_id` int(0) NOT NULL,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_status` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_202201
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
