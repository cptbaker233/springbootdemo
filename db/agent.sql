/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql8.0.13
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : agent

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 17/07/2020 17:35:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent`  (
  `work_id` int(10) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`work_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of agent
-- ----------------------------
INSERT INTO `agent` VALUES (1000001, '张三');
INSERT INTO `agent` VALUES (1000002, '李四');
INSERT INTO `agent` VALUES (1000003, '王五');
INSERT INTO `agent` VALUES (1000004, '老六');
INSERT INTO `agent` VALUES (1000005, '七七');
INSERT INTO `agent` VALUES (1000006, '老八');
INSERT INTO `agent` VALUES (1000007, '小九');

SET FOREIGN_KEY_CHECKS = 1;
