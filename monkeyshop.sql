/*
 Navicat Premium Data Transfer

 Source Server         : monkey
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : monkeyshop

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 19/12/2019 01:00:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for monkey_cart
-- ----------------------------
DROP TABLE IF EXISTS `monkey_cart`;
CREATE TABLE `monkey_cart`  (
  `CART_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CART_P_FILENAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CART_P_NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CART_P_PRICE` decimal(10, 2) NOT NULL,
  `CART_QUANTITY` int(11) NULL DEFAULT NULL,
  `CART_P_STOCK` int(11) NULL DEFAULT NULL,
  `CART_P_ID` int(11) NULL DEFAULT NULL,
  `CART_U_ID` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CART_VALID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`CART_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monkey_cart
-- ----------------------------
INSERT INTO `monkey_cart` VALUES (1, 'mhxx.jpg', '怪物猎人XX', 200.00, 1, 499, 3, 'admin', 1);
INSERT INTO `monkey_cart` VALUES (3, 'witcher3.jpg', '巫师3:狂猎', 127.00, 1, 200, 2, 'cc2', 1);

-- ----------------------------
-- Table structure for monkey_category
-- ----------------------------
DROP TABLE IF EXISTS `monkey_category`;
CREATE TABLE `monkey_category`  (
  `CATE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CATE_PARENT_ID` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`CATE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monkey_category
-- ----------------------------
INSERT INTO `monkey_category` VALUES (1, 'ns游戏', 0);
INSERT INTO `monkey_category` VALUES (2, 'ns中文', 0);
INSERT INTO `monkey_category` VALUES (3, 'ns日区', 0);
INSERT INTO `monkey_category` VALUES (4, 'ns美区', 0);
INSERT INTO `monkey_category` VALUES (5, '动作角色扮演', 1);
INSERT INTO `monkey_category` VALUES (6, '角色扮演', 1);
INSERT INTO `monkey_category` VALUES (7, '动作冒险', 1);
INSERT INTO `monkey_category` VALUES (8, '动作', 2);
INSERT INTO `monkey_category` VALUES (9, '可爱', 2);
INSERT INTO `monkey_category` VALUES (10, '绅士', 3);
INSERT INTO `monkey_category` VALUES (11, '策略', 3);
INSERT INTO `monkey_category` VALUES (12, '射击', 4);
INSERT INTO `monkey_category` VALUES (13, '音乐', 4);

-- ----------------------------
-- Table structure for monkey_product
-- ----------------------------
DROP TABLE IF EXISTS `monkey_product`;
CREATE TABLE `monkey_product`  (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10, 2) NOT NULL,
  `PRODUCT_STOCK` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_FID` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_CID` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_FILENAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monkey_product
-- ----------------------------
INSERT INTO `monkey_product` VALUES (1, '黑暗之魂重制版', '宫崎老贼的阴谋', 225.00, 500, 1, 5, 'ds.jpg');
INSERT INTO `monkey_product` VALUES (2, '巫师3:狂猎', '来一局昆特牌吧?', 127.00, 200, 1, 5, 'witcher3.jpg');
INSERT INTO `monkey_product` VALUES (3, '怪物猎人XX', '不想写了', 200.00, 499, 1, 5, 'mhxx.jpg');
INSERT INTO `monkey_product` VALUES (4, '奶刃2', '我本来不想买的,但是他实在是太大了', 399.00, 666, 1, 5, 'nr2.jpg');
INSERT INTO `monkey_product` VALUES (5, '宝可梦 剑', '苍响', 349.00, 999, 1, 6, 'bkmj.jpg');
INSERT INTO `monkey_product` VALUES (6, '宝可梦 盾', '藏然玛特', 349.00, 599, 1, 6, 'bkmd.jpg');
INSERT INTO `monkey_product` VALUES (7, '八方旅人', '一方五十', 400.00, 326, 1, 6, 'bflr.jpg');
INSERT INTO `monkey_product` VALUES (8, '超级马里奥:奥德赛', '不想写了', 300.00, 300, 1, 6, 'mmo.jpg');
INSERT INTO `monkey_product` VALUES (9, '塞尔达传说:旷野之息', '不用多说了吧', 350.00, 800, 1, 7, 'kyzx.jpg');
INSERT INTO `monkey_product` VALUES (10, '勇者斗恶龙11s', '不想写了', 300.00, 300, 1, 5, 'dq11s.jpg');
INSERT INTO `monkey_product` VALUES (11, '马造2', '不想写了', 320.00, 300, 1, 7, 'mm2.jpg');
INSERT INTO `monkey_product` VALUES (12, '猎天使魔女2', '贝姐你懂的', 280.00, 200, 2, 8, 'lts2.jpg');
INSERT INTO `monkey_product` VALUES (13, '死亡细胞', '不想写了', 200.00, 300, 2, 8, 'swxb.jpg');
INSERT INTO `monkey_product` VALUES (14, '新超级马里奥兄弟U', '不想写了', 330.00, 300, 1, 5, 'nmu.jpg');
INSERT INTO `monkey_product` VALUES (15, '宝可梦去皮', '不想写了', 250.00, 300, 2, 9, 'lsg.png');
INSERT INTO `monkey_product` VALUES (16, '宝可梦去伊', '不想写了', 250.00, 300, 2, 9, 'lsy.png');
INSERT INTO `monkey_product` VALUES (17, '星之卡比', '不想写了', 299.00, 299, 2, 9, 'skb.png');
INSERT INTO `monkey_product` VALUES (18, '妖怪手表4', '我没玩过', 380.00, 800, 2, 9, 'ygsb4.jpg');
INSERT INTO `monkey_product` VALUES (19, '耀西的手工世界', '不想写了', 360.00, 360, 2, 9, 'yx.jpg');
INSERT INTO `monkey_product` VALUES (20, '忍纾压 闪乱神乐', '我本来不想买的,但是他实在是太大了', 366.00, 300, 3, 10, 'slsl.jpg');
INSERT INTO `monkey_product` VALUES (21, '奶排3', '我本来不想买的,但是他实在是太大了', 360.00, 300, 3, 10, 'np3.jpg');
INSERT INTO `monkey_product` VALUES (22, '我的世界', '随便分下类', 125.00, 500, 3, 11, 'mc.jpg');
INSERT INTO `monkey_product` VALUES (23, '火焰纹章:风花雪月', '不想写了', 389.00, 400, 3, 11, 'hywz.jpg');
INSERT INTO `monkey_product` VALUES (24, '刀剑神域:夺命凶弹', '不想写了', 300.00, 300, 4, 12, 'djsy.jpg');
INSERT INTO `monkey_product` VALUES (25, '魂斗罗', '不想写了', 200.00, 200, 4, 12, 'hdl.jpg');
INSERT INTO `monkey_product` VALUES (26, '神界:原罪2', '神作(没找到ns的图)', 325.00, 300, 1, 6, 'dos2.jpg');
INSERT INTO `monkey_product` VALUES (27, '太鼓达人', '不想写了', 300.00, 300, 4, 13, 'tgdr.jpg');
INSERT INTO `monkey_product` VALUES (28, '舞力全开2020', '不想写了', 200.00, 300, 4, 13, 'wlqk.jpg');
INSERT INTO `monkey_product` VALUES (29, '音乐世界', '不想写了', 300.00, 666, 4, 13, 'yysj.jpg');
INSERT INTO `monkey_product` VALUES (30, '塞尔达传说:织梦岛', '感动', 279.00, 600, 1, 7, 'zmd.jpg');

-- ----------------------------
-- Table structure for monkey_user
-- ----------------------------
DROP TABLE IF EXISTS `monkey_user`;
CREATE TABLE `monkey_user`  (
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_BIRTHDAY` datetime(0) NULL DEFAULT NULL,
  `USER_IDENTITY_CODE` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_EMAIL` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_STATUS` decimal(6, 0) NOT NULL,
  `USER_UPDATETIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monkey_user
-- ----------------------------
INSERT INTO `monkey_user` VALUES ('admin', 'abc00', '123', 'T', '1998-08-09 00:00:00', NULL, '经济回暖', '18539956336', 'sss', 2, '2019-12-09 09:44:41');
INSERT INTO `monkey_user` VALUES ('admin4', '123', '123', 'T', '1998-04-02 00:00:00', NULL, '1026523571@qq.com', '18539956336', '方提供', 1, '2019-12-14 17:37:01');
INSERT INTO `monkey_user` VALUES ('cc2', 'WANGWU', '123', 'T', '2019-12-10 00:00:00', NULL, '1026523571@qq.com', '18539956336', '北京市', 1, '2019-12-19 00:13:36');
INSERT INTO `monkey_user` VALUES ('sds', '123', '123', 'T', '1998-04-02 00:00:00', NULL, '1026523571@qq.com', '18539956336', 'sss', 1, '2019-12-14 17:33:44');

SET FOREIGN_KEY_CHECKS = 1;
