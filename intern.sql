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

 Date: 29/11/2022 15:59:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adm_id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名字',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adm_id`) USING BTREE,
  UNIQUE INDEX `nameOnly`(`name`) USING BTREE
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
  PRIMARY KEY (`cpmy_id`) USING BTREE,
  UNIQUE INDEX `company_name`(`company_name`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for evaluate_c
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_c`;
CREATE TABLE `evaluate_c`  (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评假id',
  `stu_id` int(11) NOT NULL COMMENT '学生id',
  `com_id` int(11) NOT NULL COMMENT '企业id',
  `eva_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `eva_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`eva_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for evaluate_t
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_t`;
CREATE TABLE `evaluate_t`  (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评假id',
  `stu_id` int(11) NOT NULL COMMENT '学生id',
  `t_id` int(11) NOT NULL COMMENT '教师',
  `eva_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `eva_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`eva_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for pro_stu
-- ----------------------------
DROP TABLE IF EXISTS `pro_stu`;
CREATE TABLE `pro_stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `apply_com` int(11) NOT NULL DEFAULT 0 COMMENT '岗位申请是否通过，0未审批，1通过，2不通过，默认0',
  `apply_stu` int(11) NOT NULL DEFAULT 0 COMMENT '学生是否确定岗位，0未确定，1确定，默认0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '介绍岗位信息，包括公司联系方式和地址',
  `apply_num` int(11) NOT NULL DEFAULT 0,
  `com_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_leave
-- ----------------------------
DROP TABLE IF EXISTS `stu_leave`;
CREATE TABLE `stu_leave`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
-- Table structure for stu_week
-- ----------------------------
DROP TABLE IF EXISTS `stu_week`;
CREATE TABLE `stu_week`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
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
  `stu_id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `specialty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `classname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `academy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for teacther
-- ----------------------------
DROP TABLE IF EXISTS `teacther`;
CREATE TABLE `teacther`  (
  `t_id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `academy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
