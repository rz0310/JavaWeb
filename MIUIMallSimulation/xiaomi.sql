/*
Navicat MySQL Data Transfer

Source Server         : databaseFirst
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : xiaomi

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-03-10 12:08:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `bill_id` varchar(100) NOT NULL,
  `bill_status` varchar(20) NOT NULL,
  `bill_money` decimal(10,2) NOT NULL,
  `bill_date` varchar(50) NOT NULL,
  `bill_goodsName` varchar(255) DEFAULT NULL,
  `bill_goodsPrice` decimal(10,2) DEFAULT NULL,
  `bill_goodsNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1705205643098724', '未付款', '11235.00', '2019-3-1', '小米6', '2499.00', '2');

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `carts_id` int(11) NOT NULL AUTO_INCREMENT,
  `carts_name` varchar(255) NOT NULL,
  `carts_num` int(11) NOT NULL,
  `carts_version` varchar(255) NOT NULL,
  `carts_color` varchar(10) NOT NULL,
  `carts_price` decimal(10,2) NOT NULL,
  `carts_img` varchar(255) NOT NULL,
  PRIMARY KEY (`carts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carts
-- ----------------------------
INSERT INTO `carts` VALUES ('8', '小米13', '1', '64G内存/8G运行内存', '蓝色', '2499.00', 'image/xm6_80.png');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gk_23` (`goods_name`),
  CONSTRAINT `gk_23` FOREIGN KEY (`goods_name`) REFERENCES `goods` (`goods_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '小米6 硅胶保护套', '狼牙', '东西很好，发货很快，五星好评');
INSERT INTO `evaluate` VALUES ('2', '小米6 硅胶保护套', 'mimi', '这个东西超级适合小米6');
INSERT INTO `evaluate` VALUES ('3', '小米手机4C', '小仙女', '适合本仙女');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) NOT NULL,
  `goods_img` varchar(255) DEFAULT NULL,
  `goods_price` decimal(10,2) NOT NULL,
  `goods_num` int(11) NOT NULL,
  `goods_desc` varchar(255) DEFAULT NULL,
  `goods_version` varchar(255) DEFAULT NULL,
  `goods_color` varchar(10) DEFAULT NULL,
  `goods_type` int(11) DEFAULT NULL,
  `goods_paid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_id`),
  KEY `goods_type` (`goods_type`),
  KEY `goods_name` (`goods_name`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`goods_type`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('3', '小米9', 'image/xm6_80.png', '2499.00', '134', '青春开学季', '64G内存/8G运行内存', '蓝色', '1', '12344');
INSERT INTO `goods` VALUES ('4', '小米Note 3', 'image/hm4-80.jpg', '2499.00', '134', '青春开学季', '64G内存/8G运行内存', '蓝色', '1', '12344');
INSERT INTO `goods` VALUES ('5', '小米7 Note 3', 'image/hmn4x80.png', '2499.00', '134', '青春开学季', '64G内存/8G运行内存', '蓝色', '1', '12344');
INSERT INTO `goods` VALUES ('6', '电话卡', 'image/mimobile.jpg', '30.00', '8483', '实惠电话卡', '联通4G', '无', '2', '33221');
INSERT INTO `goods` VALUES ('7', '小米8 屏幕指纹版', 'image/xm6_80.png', '2499.00', '134', '青春开学季', '64G内存/8G运行内存', '蓝色', '3', '12344');
INSERT INTO `goods` VALUES ('8', '小米13', 'image/xm6_80.png', '2499.00', '134', '青春开学季', '64G内存/8G运行内存', '蓝色', '4', '12344');
INSERT INTO `goods` VALUES ('9', '红米6', 'image/xm6_80.png', '4322.00', '3234', '青春开学季', '64 / 8', '红色', '1', '44322');
INSERT INTO `goods` VALUES ('10', '小米手环3', 'image/小米手环3.png', '2342.00', '3242', '智能刷卡', '红色款', '红色', '5', '23423');
INSERT INTO `goods` VALUES ('11', '小米6 硅胶保护套', 'image/peijian2.jpg', '16.00', '5434', '小米6原配，柔软舒适', '橡胶款', '黑色', '6', '23432');
INSERT INTO `goods` VALUES ('12', '小米手机4C', 'image/hm4-80.jpg', '43.00', '4543', '情报可用', '高配置', '白色', '1', '345434');
INSERT INTO `goods` VALUES ('13', '红米note4X 钢化膜', 'image/peijian4.jpg', '17.00', '2345', null, '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('14', '小米支架式自拍杆', 'image/peijian5.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('15', '小米指环支架', 'image/peijian6.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('16', '米家随身电风扇', 'image/peijian7.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('17', '红米4X高透软胶保护套', 'image/peijian8.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('18', '红米6', 'image/xm6_80.png', '4322.00', '3234', '青春开学季', '64 /12', '红色', '1', '44322');
INSERT INTO `goods` VALUES ('19', '小米9', 'image/xm6_80.png', '2499.00', '134', '青春开学季', '64G内存/4G运行内存', '蓝色', '1', '12344');
INSERT INTO `goods` VALUES ('20', '小米Note 3', 'image/hm4-80.jpg', '2499.00', '134', '青春开学季', '64G内存/4G运行内存', '蓝色', '1', '12344');
INSERT INTO `goods` VALUES ('21', '小米7 Note 3', 'image/hmn4x80.png', '2499.00', '134', '青春开学季', '64G内存/4G运行内存', '蓝色', '1', '12344');
INSERT INTO `goods` VALUES ('22', '小米8 屏幕指纹版', 'image/xm6_80.png', '2499.00', '134', '青春开学季', '64G内存/8G运行内存', '蓝色', '3', '12344');
INSERT INTO `goods` VALUES ('23', '小米13', 'image/xm6_80.png', '2499.00', '134', '青春开学季', '64G内存/8G运行内存', '蓝色', '4', '12344');
INSERT INTO `goods` VALUES ('24', '小米手环3', 'image/小米手环3.png', '2342.00', '3242', '智能刷卡', '红色款', '红色', '5', '23423');
INSERT INTO `goods` VALUES ('25', '小米6 硅胶保护套', 'image/peijian2.jpg', '16.00', '5434', '小米6原配，柔软舒适', '橡胶款', '黑色', '6', '23432');
INSERT INTO `goods` VALUES ('26', '小米手机4C', 'image/hm4-80.jpg', '43.00', '4543', '情报可用', '高配置', '白色', '1', '345434');
INSERT INTO `goods` VALUES ('27', '红米note4X 钢化膜', 'image/peijian4.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('28', '小米支架式自拍杆', 'image/peijian5.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('29', '小米指环支架', 'image/peijian6.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('30', '米家随身电风扇', 'image/peijian7.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');
INSERT INTO `goods` VALUES ('31', '红米4X高透软胶保护套', 'image/peijian8.jpg', '17.00', '2345', '', '高配置', '白色', '6', '432423');

-- ----------------------------
-- Table structure for idlegoods
-- ----------------------------
DROP TABLE IF EXISTS `idlegoods`;
CREATE TABLE `idlegoods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idle_name` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `img` (`idle_name`),
  CONSTRAINT `img` FOREIGN KEY (`idle_name`) REFERENCES `goods` (`goods_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idlegoods
-- ----------------------------
INSERT INTO `idlegoods` VALUES ('1', '小米Note 3', 'image/pinpai1.png', '3月9日-21日享花呗12期分期免息');
INSERT INTO `idlegoods` VALUES ('2', '小米7 Note 3', 'image/pinpai2.png', '3月9日-21日享花呗12期分期免息');
INSERT INTO `idlegoods` VALUES ('3', '小米8 屏幕指纹版', 'image/pinpai3.png', '3月9日-21日享花呗12期分期免息');
INSERT INTO `idlegoods` VALUES ('4', '红米6', 'image/pinpai4.png', '3月9日-21日享花呗12期分期免息');
INSERT INTO `idlegoods` VALUES ('5', '小米13', 'image/pinpai5.png', '3月9日-21日享花呗12期分期免息');

-- ----------------------------
-- Table structure for indexdown
-- ----------------------------
DROP TABLE IF EXISTS `indexdown`;
CREATE TABLE `indexdown` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  CONSTRAINT `name` FOREIGN KEY (`name`) REFERENCES `goods` (`goods_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indexdown
-- ----------------------------
INSERT INTO `indexdown` VALUES ('1', 'image/红米6首页下.jpg', '红米6');
INSERT INTO `indexdown` VALUES ('2', 'image/小米手环3.jpg', '小米手环3');
INSERT INTO `indexdown` VALUES ('3', 'image/小米8首页下.jpg', '小米8 屏幕指纹版');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL,
  `manager_username` varchar(255) NOT NULL,
  `manager_password` varchar(255) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for parts
-- ----------------------------
DROP TABLE IF EXISTS `parts`;
CREATE TABLE `parts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `evluateNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gk_3` (`name`),
  CONSTRAINT `gk_3` FOREIGN KEY (`name`) REFERENCES `goods` (`goods_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parts
-- ----------------------------
INSERT INTO `parts` VALUES ('1', '小米6 硅胶保护套', 'image/peijian2.jpg', '新品', '2');
INSERT INTO `parts` VALUES ('2', '小米手机4C', 'image/peijian3.jpg', '享6折', '1');
INSERT INTO `parts` VALUES ('3', '米家随身电风扇', 'image/peijian3.jpg', '居家必备', '1');
INSERT INTO `parts` VALUES ('4', '小米指环支架', 'image/peijian3.jpg', null, '1');
INSERT INTO `parts` VALUES ('5', '红米note4X 钢化膜', 'image/peijian3.jpg', null, '1');
INSERT INTO `parts` VALUES ('6', '小米支架式自拍杆', 'image/peijian3.jpg', null, '0');
INSERT INTO `parts` VALUES ('9', '红米4X高透软胶保护套', 'image/peijian3.jpg', '新品', '0');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '手机');
INSERT INTO `type` VALUES ('2', '电话卡');
INSERT INTO `type` VALUES ('3', '笔记本');
INSERT INTO `type` VALUES ('4', '平板');
INSERT INTO `type` VALUES ('5', '科技产品');
INSERT INTO `type` VALUES ('6', '配件');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userName` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `sign` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('101', '111', '13572282359', '这就是签名', '陕西省西安市西安工程大学');
INSERT INTO `users` VALUES ('user002', '12345678', '13572282359', '这就是签名', '陕西省西安市西安工程大学');
INSERT INTO `users` VALUES ('user003', '12345678', '13572282359', '这就是签名', '陕西省西安市西安工程大学');
INSERT INTO `users` VALUES ('user004', '12345678', '13572282359', '这就是签名', '陕西省西安市西安工程大学');
INSERT INTO `users` VALUES ('user005', '12345678', '13572282359', '这就是签名', '陕西省西安市西安工程大学');
INSERT INTO `users` VALUES ('user006', '12345678', '13572282359', '这就是签名', '陕西省西安市西安工程大学');
INSERT INTO `users` VALUES ('user007', '12345678', '13572282359', '这就是签名', '陕西省西安市西安工程大学');
INSERT INTO `users` VALUES ('啊啊', '111', '12435678765', 'null', 'null');
