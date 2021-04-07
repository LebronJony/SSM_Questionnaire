/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : survey

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2081 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for tb_answer_opt
-- ----------------------------
DROP TABLE IF EXISTS `tb_answer_opt`;
CREATE TABLE `tb_answer_opt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `opt_id` int(11) NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1radio|2checkbox',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `voter` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_2`(`opt_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for tb_answer_txt
-- ----------------------------
DROP TABLE IF EXISTS `tb_answer_txt`;
CREATE TABLE `tb_answer_txt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `result` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `voter` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(1) NULL DEFAULT NULL COMMENT '1radio|2checkbox|3text|4textarea',
  `required` int(1) NULL DEFAULT NULL COMMENT '0非必填1必填',
  `check_style` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'text;number;date',
  `order_style` int(1) NULL DEFAULT NULL COMMENT '0顺序1随机',
  `show_style` int(1) NULL DEFAULT NULL COMMENT '1;2;3;4',
  `test` int(1) NULL DEFAULT NULL COMMENT '0不测评1测评',
  `score` int(3) NULL DEFAULT NULL,
  `orderby` int(11) NULL DEFAULT NULL,
  `creator` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `survey_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_1`(`survey_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for tb_question_opt
-- ----------------------------
DROP TABLE IF EXISTS `tb_question_opt`;
CREATE TABLE `tb_question_opt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1radio|2checkbox',
  `opt` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderby` int(11) NULL DEFAULT NULL,
  `answer` int(1) NULL DEFAULT NULL COMMENT '默认为NULL；1答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for tb_survey
-- ----------------------------
DROP TABLE IF EXISTS `tb_survey`;
CREATE TABLE `tb_survey`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bounds` int(1) NULL DEFAULT NULL COMMENT '0:不限制;1:限制',
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `rules` int(1) NULL DEFAULT NULL COMMENT '0公开;1密码',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建、执行中、结束',
  `logo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bgimg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `anon` int(1) NULL DEFAULT NULL COMMENT '0匿名；1不匿名',
  `creator` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
