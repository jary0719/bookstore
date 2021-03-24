/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 24/03/2021 23:16:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_author
-- ----------------------------
DROP TABLE IF EXISTS `book_author`;
CREATE TABLE `book_author`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book_author
-- ----------------------------
INSERT INTO `book_author` VALUES (1, '吴承恩');
INSERT INTO `book_author` VALUES (2, '士大夫');
INSERT INTO `book_author` VALUES (3, '作者1');
INSERT INTO `book_author` VALUES (4, '作者2');
INSERT INTO `book_author` VALUES (5, '作者3');

-- ----------------------------
-- Table structure for book_press
-- ----------------------------
DROP TABLE IF EXISTS `book_press`;
CREATE TABLE `book_press`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `press` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book_press
-- ----------------------------
INSERT INTO `book_press` VALUES (1, '出版社1');
INSERT INTO `book_press` VALUES (2, '出版社2');
INSERT INTO `book_press` VALUES (3, '出版社3');

-- ----------------------------
-- Table structure for book_type
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES (1, '文学');
INSERT INTO `book_type` VALUES (2, '类别1');
INSERT INTO `book_type` VALUES (3, '类别2');
INSERT INTO `book_type` VALUES (4, '类别3');

-- ----------------------------
-- Table structure for bs_book
-- ----------------------------
DROP TABLE IF EXISTS `bs_book`;
CREATE TABLE `bs_book`  (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `bt_id` int(11) NULL DEFAULT NULL,
  `bp_id` int(11) NULL DEFAULT NULL,
  `ba_id` int(11) NULL DEFAULT NULL,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float NULL DEFAULT NULL,
  `stock` int(11) NULL DEFAULT NULL,
  `counter` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`b_id`) USING BTREE,
  INDEX `bt_id`(`bt_id`) USING BTREE,
  INDEX `bp_id`(`bp_id`) USING BTREE,
  INDEX `ba_id`(`ba_id`) USING BTREE,
  CONSTRAINT `bs_book_ibfk_1` FOREIGN KEY (`bt_id`) REFERENCES `book_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bs_book_ibfk_2` FOREIGN KEY (`bp_id`) REFERENCES `book_press` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bs_book_ibfk_3` FOREIGN KEY (`ba_id`) REFERENCES `book_author` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bs_book
-- ----------------------------
INSERT INTO `bs_book` VALUES (12, 1, 3, 1, '西游记', 45, 4235, NULL, '内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览', NULL);
INSERT INTO `bs_book` VALUES (13, 1, 3, 3, '水浒传', 45, 4235, NULL, '内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览', NULL);
INSERT INTO `bs_book` VALUES (14, 1, 2, 3, '水浒传', 45, 4235, NULL, '内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览', NULL);
INSERT INTO `bs_book` VALUES (15, 1, 1, 3, '水浒传', 45, 4235, NULL, '内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览', NULL);
INSERT INTO `bs_book` VALUES (16, 1, 1, 4, '红楼梦', 45, 4235, NULL, '内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览', NULL);
INSERT INTO `bs_book` VALUES (18, 1, 2, 4, '红楼梦', 45, 4235, NULL, '内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览内容预览', NULL);
INSERT INTO `bs_book` VALUES (37, 3, 2, 5, '书1', 54, 235, NULL, '内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容', NULL);
INSERT INTO `bs_book` VALUES (38, 2, 2, 4, '三国演义', 45, 6456, NULL, '内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容', NULL);
INSERT INTO `bs_book` VALUES (41, 1, 1, 3, '挂号费', 34, 545, NULL, '', NULL);
INSERT INTO `bs_book` VALUES (42, 4, 1, 5, 'dfg', 45, 324, NULL, '', NULL);
INSERT INTO `bs_book` VALUES (46, 3, 2, 4, 'dg', 34, 234, NULL, '', NULL);
INSERT INTO `bs_book` VALUES (47, 3, 1, 3, 'dsfg', 23, 234, NULL, '', NULL);
INSERT INTO `bs_book` VALUES (53, 3, 2, 3, 'dsf', 34, 235, NULL, '', NULL);
INSERT INTO `bs_book` VALUES (54, 3, 2, 3, 'dsf12', 34, 235, NULL, '', NULL);
INSERT INTO `bs_book` VALUES (55, 3, 1, 3, 'qwe', 34, 234, NULL, '', NULL);
INSERT INTO `bs_book` VALUES (57, 2, 1, 1, 'aaksgjdhas', 32, 432, NULL, '243', NULL);
INSERT INTO `bs_book` VALUES (58, 2, 1, 1, 'aaksgjdha', 32, 432, NULL, '243', NULL);

-- ----------------------------
-- Table structure for bs_order
-- ----------------------------
DROP TABLE IF EXISTS `bs_order`;
CREATE TABLE `bs_order`  (
  `user_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_number` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `order_time` datetime NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`order_number`) USING BTREE,
  INDEX `FK_Relationship_8`(`user_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`user_id`) REFERENCES `bs_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bs_order
-- ----------------------------
INSERT INTO `bs_order` VALUES ('2005201025_1d7b35366f7', 'sdggh4531246454132', '2020-05-13 16:47:03', 1);
INSERT INTO `bs_order` VALUES ('2005201025_1d7b35366f7', 'sdggh4531246454133', '2020-05-20 16:47:45', 1);
INSERT INTO `bs_order` VALUES ('2005201024_c7a61610b0b', 'WSSDGWPT20200606143806', '2020-06-06 14:38:06', 0);
INSERT INTO `bs_order` VALUES ('2005201024_c7a61610b0b', 'WSSDGWPT20200606150610', '2020-06-06 15:06:10', -1);
INSERT INTO `bs_order` VALUES ('2005201024_c7a61610b0b', 'WSSDGWPT20200606160934', '2020-06-06 16:09:34', 0);

-- ----------------------------
-- Table structure for bs_role
-- ----------------------------
DROP TABLE IF EXISTS `bs_role`;
CREATE TABLE `bs_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `display_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bs_role
-- ----------------------------
INSERT INTO `bs_role` VALUES (1, 'ADMIN', '超级管理员');
INSERT INTO `bs_role` VALUES (2, 'CLERK', '店员');
INSERT INTO `bs_role` VALUES (3, 'CUSTOMER', '顾客');

-- ----------------------------
-- Table structure for bs_user
-- ----------------------------
DROP TABLE IF EXISTS `bs_user`;
CREATE TABLE `bs_user`  (
  `user_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `last_login_time` datetime NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bs_user
-- ----------------------------
INSERT INTO `bs_user` VALUES ('2005201005_2206fd31711', 'admin', '$2a$05$YCZ0ntw6jsqevJ6Jj5AD9OlSno.uISvDIKzKZgk.6AsA3RdFiiQgK', NULL, NULL, NULL, NULL, '2021-03-09 21:24:30', 0);
INSERT INTO `bs_user` VALUES ('2005201024_c7a61610b0b', 'customer', '$2a$05$TMvjqXxxTMnqvCfqbPyu3uKHMfMXhUyjXRX.KoyCILGH2cnmdmHRq', '顾客', '13412341234', '', NULL, '2021-03-09 21:25:03', 0);
INSERT INTO `bs_user` VALUES ('2005201025_1d7b35366f7', 'clerk', '$2a$05$T0IE4.Y.qpx1Wk3CJVGDi.jrPZhlAGU0cJS21QMIaMglpY5xZZUwC', '店员', '13412341234', '', NULL, '2020-05-30 15:20:54', 0);
INSERT INTO `bs_user` VALUES ('2005251247_3744ddad2c9', 'qwe', '$2a$05$DrqOGhZ3.fFPDh.HoLRFhOcuwxpSWUPxhCFGlDp7yOvoO6tRJOGE2', 'Aila Kemble', '13412341234', 'akemble2@ovh.net', '2020-05-25 12:47:12', NULL, 0);
INSERT INTO `bs_user` VALUES ('2005251247_40869bda449', '123', '$2a$05$dn4Bo5P057078OytdZzefucMi6YUzx1/Q0bAs5bRneVu5hmF8R9y2', '123', '13412341234', 'akemble2@ovh.net', '2020-05-25 12:47:35', NULL, -1);
INSERT INTO `bs_user` VALUES ('2005251252_94dcdfd7627', 'zxc', '$2a$05$n63mGaBPV8iuuOh3P3VkneKLNBKc7cZLNFducX9WuUA7RRhelMCzW', 'Aila Kemble', '13412341234', 'akemble2@ovh.net', '2020-05-25 12:52:03', NULL, -1);
INSERT INTO `bs_user` VALUES ('2005251300_195dda818fe', 'ewq', '$2a$05$oBra9uhoX.KyDrWM3HGx1ebeK4NSaeAwyldIboEigAn.IEj7/xdfm', NULL, '13412341234', 'akemble2@ovh.net', '2020-05-25 13:00:24', NULL, NULL);
INSERT INTO `bs_user` VALUES ('2005251306_4428642e507', 'dsa', '$2a$05$BHFo5i1DyT7ELMzr/DPWrOHSotYtC9/ggHHZ03B8T/Zx0BlH3Vm5u', NULL, '13412341234', 'dsa@123.com', '2020-05-25 13:06:33', '2020-05-25 13:06:39', 0);
INSERT INTO `bs_user` VALUES ('2005261513_0eca649539c', 'qwe3', '', 'qwe', '13412341234', 'akemble2@ovh.net', '2020-05-26 15:13:04', NULL, 0);
INSERT INTO `bs_user` VALUES ('2005301447_c4bf0c600a0', 'qwe1', '$2a$05$9RcQM8uQNDswIf6Eutb/hOruK6SaptTMevZ9Nr51ZhJPehRS7j0RW', 'qwe', '13412341234', 'akemble2@ovh.net', '2020-05-30 14:47:09', NULL, -1);
INSERT INTO `bs_user` VALUES ('2006061654_04cc8c63db9', '213', '$2a$05$DWNfZl/U8tvZ5oNA/zezI.p9s/YBrOPPxxoKEfwlaFBE2FbemCYyi', '123', '13412341234', 'akemble2@ovh.net', '2020-06-06 16:54:28', NULL, -1);

-- ----------------------------
-- Table structure for fk_book_img
-- ----------------------------
DROP TABLE IF EXISTS `fk_book_img`;
CREATE TABLE `fk_book_img`  (
  `book_id` int(11) NOT NULL DEFAULT 0,
  `img_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`book_id`, `img_id`) USING BTREE,
  INDEX `FK_fk_book_img2`(`img_id`) USING BTREE,
  CONSTRAINT `FK_fk_book_img` FOREIGN KEY (`book_id`) REFERENCES `bs_book` (`b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_fk_book_img2` FOREIGN KEY (`img_id`) REFERENCES `upload_image` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fk_book_img
-- ----------------------------
INSERT INTO `fk_book_img` VALUES (12, 13);
INSERT INTO `fk_book_img` VALUES (13, 14);
INSERT INTO `fk_book_img` VALUES (14, 15);
INSERT INTO `fk_book_img` VALUES (15, 16);
INSERT INTO `fk_book_img` VALUES (16, 17);
INSERT INTO `fk_book_img` VALUES (16, 18);
INSERT INTO `fk_book_img` VALUES (18, 19);
INSERT INTO `fk_book_img` VALUES (18, 20);
INSERT INTO `fk_book_img` VALUES (37, 36);
INSERT INTO `fk_book_img` VALUES (38, 37);
INSERT INTO `fk_book_img` VALUES (41, 40);
INSERT INTO `fk_book_img` VALUES (42, 41);
INSERT INTO `fk_book_img` VALUES (46, 45);
INSERT INTO `fk_book_img` VALUES (47, 46);
INSERT INTO `fk_book_img` VALUES (53, 52);
INSERT INTO `fk_book_img` VALUES (54, 53);
INSERT INTO `fk_book_img` VALUES (55, 54);
INSERT INTO `fk_book_img` VALUES (57, 55);
INSERT INTO `fk_book_img` VALUES (58, 56);

-- ----------------------------
-- Table structure for fk_order_book
-- ----------------------------
DROP TABLE IF EXISTS `fk_order_book`;
CREATE TABLE `fk_order_book`  (
  `order_number` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `book_id` int(11) NOT NULL DEFAULT 0,
  `quant` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`order_number`, `book_id`) USING BTREE,
  INDEX `FK_fk_order_book2`(`book_id`) USING BTREE,
  CONSTRAINT `FK_fk_order_book1` FOREIGN KEY (`order_number`) REFERENCES `bs_order` (`order_number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_fk_order_book2` FOREIGN KEY (`book_id`) REFERENCES `bs_book` (`b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fk_order_book
-- ----------------------------
INSERT INTO `fk_order_book` VALUES ('sdggh4531246454132', 18, 1);
INSERT INTO `fk_order_book` VALUES ('sdggh4531246454132', 37, 1);
INSERT INTO `fk_order_book` VALUES ('sdggh4531246454133', 38, 1);
INSERT INTO `fk_order_book` VALUES ('WSSDGWPT20200606143806', 15, 1);
INSERT INTO `fk_order_book` VALUES ('WSSDGWPT20200606150610', 41, 1);
INSERT INTO `fk_order_book` VALUES ('WSSDGWPT20200606160934', 15, 2);
INSERT INTO `fk_order_book` VALUES ('WSSDGWPT20200606160934', 42, 1);

-- ----------------------------
-- Table structure for fk_user_role
-- ----------------------------
DROP TABLE IF EXISTS `fk_user_role`;
CREATE TABLE `fk_user_role`  (
  `user_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FK_fk_user_role2`(`role_id`) USING BTREE,
  CONSTRAINT `FK_fk_user_role1` FOREIGN KEY (`user_id`) REFERENCES `bs_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_fk_user_role2` FOREIGN KEY (`role_id`) REFERENCES `bs_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fk_user_role
-- ----------------------------
INSERT INTO `fk_user_role` VALUES ('2005201005_2206fd31711', 1);
INSERT INTO `fk_user_role` VALUES ('2005201025_1d7b35366f7', 2);
INSERT INTO `fk_user_role` VALUES ('2005251247_3744ddad2c9', 2);
INSERT INTO `fk_user_role` VALUES ('2005201024_c7a61610b0b', 3);
INSERT INTO `fk_user_role` VALUES ('2005251247_3744ddad2c9', 3);
INSERT INTO `fk_user_role` VALUES ('2005251247_40869bda449', 3);
INSERT INTO `fk_user_role` VALUES ('2005251252_94dcdfd7627', 3);
INSERT INTO `fk_user_role` VALUES ('2005251300_195dda818fe', 3);
INSERT INTO `fk_user_role` VALUES ('2005251306_4428642e507', 3);
INSERT INTO `fk_user_role` VALUES ('2005261513_0eca649539c', 3);
INSERT INTO `fk_user_role` VALUES ('2005301447_c4bf0c600a0', 3);
INSERT INTO `fk_user_role` VALUES ('2006061654_04cc8c63db9', 3);

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `FK_fk_cart_book`(`book_id`) USING BTREE,
  INDEX `FK_fk_user_cart`(`user_id`) USING BTREE,
  CONSTRAINT `FK_fk_cart_book` FOREIGN KEY (`book_id`) REFERENCES `bs_book` (`b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_fk_user_cart` FOREIGN KEY (`user_id`) REFERENCES `bs_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------

-- ----------------------------
-- Table structure for upload_image
-- ----------------------------
DROP TABLE IF EXISTS `upload_image`;
CREATE TABLE `upload_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `original_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `save_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_size` bigint(20) NULL DEFAULT NULL,
  `file_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of upload_image
-- ----------------------------
INSERT INTO `upload_image` VALUES (11, '西游记.jpg', '20200522091159.jpg', 16996, 'image/jpeg', '2020-05-22 09:35:05', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (13, '西游记.jpg', '20200522091350.jpg', 16996, 'image/jpeg', '2020-05-22 09:35:17', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (14, '水浒传.jpg', '20200522091434.jpg', 25973, 'image/jpeg', '2020-05-22 09:35:20', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (15, '水浒传.jpg', '20200522091437.jpg', 25973, 'image/jpeg', '2020-05-22 09:35:22', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (16, '水浒传.jpg', '20200522091441.jpg', 25973, 'image/jpeg', '2020-05-22 09:35:25', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (17, '红楼梦.jpg', '20200522091501.jpg', 15885, 'image/jpeg', '2020-05-22 09:35:27', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (18, '红楼梦1.jpg', '20200522091501.jpg', 39006, 'image/jpeg', '2020-05-22 09:35:30', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (19, '红楼梦.jpg', '20200522091504.jpg', 15885, 'image/jpeg', '2020-05-22 09:35:33', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (20, '红楼梦1.jpg', '20200522091504.jpg', 39006, 'image/jpeg', '2020-05-22 09:35:36', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (21, '红楼梦.jpg', '20200522091509.jpg', 15885, 'image/jpeg', '2020-05-22 09:35:38', '\\upload-image\\');
INSERT INTO `upload_image` VALUES (23, 'Java核心技术 卷Ⅰ.jpg', '20200522181939.jpg', 38426, 'image/jpeg', '2020-05-22 18:19:39', '/upload-image/');
INSERT INTO `upload_image` VALUES (24, 'Java核心技术 卷Ⅱ.jpg', '20200522181943.jpg', 38885, 'image/jpeg', '2020-05-22 18:19:43', '/upload-image/');
INSERT INTO `upload_image` VALUES (25, '56ef4a73Na00d39cb.jpg', '20200522183408.jpg', 31908, 'image/jpeg', '2020-05-22 18:34:08', '/upload-image/');
INSERT INTO `upload_image` VALUES (26, '2.jpg', '20200522194256.jpg', 96024, 'image/jpeg', '2020-05-22 19:42:56', '/upload-image/');
INSERT INTO `upload_image` VALUES (27, '3.jpg', '20200522194256.jpg', 108565, 'image/jpeg', '2020-05-22 19:42:56', '/upload-image/');
INSERT INTO `upload_image` VALUES (34, 'Java编程思想.jpg', '20200522201029.jpg', 8746, 'image/jpeg', '2020-05-22 20:10:29', '/upload-image/');
INSERT INTO `upload_image` VALUES (35, 'Java编程思想.jpg', '20200522201359.jpg', 8746, 'image/jpeg', '2020-05-22 20:13:59', '/upload-image/');
INSERT INTO `upload_image` VALUES (36, '华胥引.jpg', '20200523225151.jpg', 16834, 'image/jpeg', '2020-05-23 22:51:51', '/upload-image/');
INSERT INTO `upload_image` VALUES (37, '三国演义.jpg', '20200525121517.jpg', 59532, 'image/jpeg', '2020-05-25 12:15:17', '/upload-image/');
INSERT INTO `upload_image` VALUES (40, '童书-学会管理自己.jpg', '20200525125539.jpg', 5941, 'image/jpeg', '2020-05-25 12:55:39', '/upload-image/');
INSERT INTO `upload_image` VALUES (41, '聊斋志异.jpg', '20200525130753.jpg', 61651, 'image/jpeg', '2020-05-25 13:07:53', '/upload-image/');
INSERT INTO `upload_image` VALUES (45, '聊斋志异.jpg', '20200525140108.jpg', 61651, 'image/jpeg', '2020-05-25 14:01:08', '/upload-image/');
INSERT INTO `upload_image` VALUES (46, '儒林外传.jpg', '20200606161055.jpg', 24996, 'image/jpeg', '2020-06-06 16:10:55', '/upload-image/');
INSERT INTO `upload_image` VALUES (52, 'MySQL数据库应用.jpg', '20200606162912.jpg', 13321, 'image/jpeg', '2020-06-06 16:29:12', '/upload-image/');
INSERT INTO `upload_image` VALUES (53, 'MySQL数据库应用.jpg', '20200606163053.jpg', 13321, 'image/jpeg', '2020-06-06 16:30:53', '/upload-image/');
INSERT INTO `upload_image` VALUES (54, 'Java核心技术 卷Ⅱ.jpg', '20200606165534.jpg', 38885, 'image/jpeg', '2020-06-06 16:55:34', '/upload-image/');
INSERT INTO `upload_image` VALUES (55, 'Java从入门到放弃.jpg', '20200606165939.jpg', 46759, 'image/jpeg', '2020-06-06 16:59:39', '/upload-image/');
INSERT INTO `upload_image` VALUES (56, 'Java从入门到放弃.jpg', '20200606165949.jpg', 46759, 'image/jpeg', '2020-06-06 16:59:49', '/upload-image/');

SET FOREIGN_KEY_CHECKS = 1;
