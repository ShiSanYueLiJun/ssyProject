/*
Navicat MySQL Data Transfer

Source Server         : ssy
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : ssy_project

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2022-01-06 23:34:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '物流id',
  `uid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户id',
  `pid` bigint(36) DEFAULT NULL COMMENT '产品id',
  `is_valid` int(11) DEFAULT NULL COMMENT '逻辑字段0:无效，1:有效',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1476034205269553154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='物流';

-- ----------------------------
-- Records of logistics
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `pid` bigint(36) DEFAULT NULL COMMENT '产品id',
  `uid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户id',
  `is_valid` int(11) DEFAULT NULL COMMENT '逻辑字段0:无效，1:有效',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=932 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1', '1', null, null);

-- ----------------------------
-- Table structure for points
-- ----------------------------
DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '积分id',
  `uid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户id',
  `point` int(11) DEFAULT NULL COMMENT '积分',
  `is_valid` int(11) DEFAULT NULL COMMENT '逻辑字段0:无效，1:有效',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1476034205269553154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='积分';

-- ----------------------------
-- Records of points
-- ----------------------------

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `product_name` varchar(500) DEFAULT NULL COMMENT '产品名',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `is_valid` int(11) DEFAULT NULL COMMENT '逻辑字段0:无效，1:有效',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1476034205269553154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品';

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '烤鱼', '2', '95', '1', null, null);
