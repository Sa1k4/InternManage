/*
 Navicat Premium Data Transfer

 Source Server         : Saika
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : intern

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 05/12/2022 22:22:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adm_id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名字',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adm_id`) USING BTREE,
  UNIQUE INDEX `nameOnly`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `cpmy_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `company_legal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `company_licence` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0是没删，1删了',
  PRIMARY KEY (`cpmy_id`) USING BTREE,
  UNIQUE INDEX `company_name`(`company_name`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for evaluate_c
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_c`;
CREATE TABLE `evaluate_c`  (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `stu_id` int(12) NOT NULL COMMENT '学生id',
  `com_id` int(11) NOT NULL COMMENT '企业id',
  `eva_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `eva_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`eva_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for evaluate_t
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_t`;
CREATE TABLE `evaluate_t`  (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评假id',
  `stu_id` int(12) NOT NULL COMMENT '学生id',
  `t_id` int(12) NOT NULL COMMENT '教师',
  `eva_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `eva_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`eva_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for pro_stu
-- ----------------------------
DROP TABLE IF EXISTS `pro_stu`;
CREATE TABLE `pro_stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `apply_com` int(11) NOT NULL DEFAULT 0 COMMENT '岗位申请是否通过，0申请中，1通过，2不通过，默认0',
  `del` int(11) NOT NULL DEFAULT 0 COMMENT '0默认，1离职',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `salary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '薪水',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '介绍岗位信息，包括公司联系方式和地址',
  `apply_num` int(11) NOT NULL DEFAULT 0 COMMENT '人数',
  `com_id` int(11) NOT NULL COMMENT '企业id',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '岗位状态 0未审核，1开启，2关闭，3未通过审核',
  `del` tinyint(1) NOT NULL DEFAULT 0 COMMENT '默认0，删除后是显示1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_leave
-- ----------------------------
DROP TABLE IF EXISTS `stu_leave`;
CREATE TABLE `stu_leave`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apply` int(255) NULL DEFAULT 0 COMMENT '0申请，1同意，2不同意,默认0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_plan
-- ----------------------------
DROP TABLE IF EXISTS `stu_plan`;
CREATE TABLE `stu_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_repo
-- ----------------------------
DROP TABLE IF EXISTS `stu_repo`;
CREATE TABLE `stu_repo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_t
-- ----------------------------
DROP TABLE IF EXISTS `stu_t`;
CREATE TABLE `stu_t`  (
  `id` int(11) NOT NULL,
  `stu_id` int(12) NOT NULL,
  `t_id` int(12) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for stu_week
-- ----------------------------
DROP TABLE IF EXISTS `stu_week`;
CREATE TABLE `stu_week`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` date NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(12) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `specialty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `classname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `academy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `del` tinyint(1) NULL DEFAULT 0,
  `vitae` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历',
  `apply` tinyint(255) NULL DEFAULT 0 COMMENT '实习申请，0未申请/未通过，1已申请，2通过',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int(12) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `academy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
