/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hpugs

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-08 12:53:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` tinyint(4) DEFAULT '1',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'abc', '18300602558', null, null, '123456', '2017-12-07 12:05:24', null, '1', null);
INSERT INTO `user` VALUES ('2', 'abc1', '15311737293', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('3', 'abc1', '15311737293', null, null, '123456', null, null, '2', null);
INSERT INTO `user` VALUES ('4', 'abc2', '15311737292', null, null, '123456', null, null, '2', null);
INSERT INTO `user` VALUES ('5', 'abc123', '15311734292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('6', 'abc12', '15311734292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('7', 'abc5', '15311534292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('8', 'abc6', '15311544292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('9', 'hpugs', '15311534292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('10', 'manyiaby', '15311534292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('11', 'manyiaby1', '15311534292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('12', 'manyiaby2', '15311534292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('13', 'mysql', '15311534292', null, null, '123456', null, null, '1', null);
INSERT INTO `user` VALUES ('14', 'hpugs', null, '18300602558', null, '123456', '2017-12-07 12:05:56', null, '1', null);
INSERT INTO `user` VALUES ('15', 'hpugs0', null, '18300602550', null, '123456', '2017-12-07 12:09:35', null, '1', null);
INSERT INTO `user` VALUES ('16', 'hpugs1', null, '18300602551', null, '123456', '2017-12-07 12:09:35', null, '1', null);
INSERT INTO `user` VALUES ('17', 'hpugs2', null, '18300602552', null, '123456', '2017-12-07 12:09:35', null, '1', null);
INSERT INTO `user` VALUES ('18', 'hpugs3', null, '18300602553', null, '123456', '2017-12-07 12:09:35', null, '1', null);
INSERT INTO `user` VALUES ('19', 'hpugs4', null, '18300602554', null, '123456', '2017-12-07 12:09:35', null, '2', null);
INSERT INTO `user` VALUES ('20', 'hpugs5', null, '18300602555', null, '123456', '2017-12-07 00:00:00', null, '2', null);
INSERT INTO `user` VALUES ('21', 'hpugs6', null, '18300602556', null, '123456', '2017-12-07 12:09:35', null, '1', null);
INSERT INTO `user` VALUES ('22', 'hpugs7', null, '18300602557', null, '123456', '2017-12-07 12:09:35', null, '1', null);
