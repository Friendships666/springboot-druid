/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : spring_test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-03-08 10:12:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('1', '张三', '23423');
INSERT INTO `base_user` VALUES ('2', '里斯', '54755');
INSERT INTO `base_user` VALUES ('3', '李四', '678564');
INSERT INTO `base_user` VALUES ('4', '笑话', '456123');
INSERT INTO `base_user` VALUES ('5', '笑话', '456123');
INSERT INTO `base_user` VALUES ('6', 'xiaoming', '4895uwieuwi');
INSERT INTO `base_user` VALUES ('9', 'xiaoming22', '4895uwieuwi222');
