/*
Navicat MySQL Data Transfer

Source Server         : 220.168.26.90
Source Server Version : 50626
Source Host           : 220.168.26.90:3306
Source Database       : jbg_test

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-08-10 08:52:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `jbg_demo`
-- ----------------------------
DROP TABLE IF EXISTS `jbg_demo`;
CREATE TABLE `jbg_demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `min` int(11) DEFAULT NULL,
  `max` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `demo_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of jbg_demo
-- ----------------------------
INSERT INTO `jbg_demo` VALUES ('23', '测试', '测试', '1', '1', '0', '2018-04-12 00:00:00', null);

-- ----------------------------
-- Table structure for `jbg_resource`
-- ----------------------------
DROP TABLE IF EXISTS `jbg_resource`;
CREATE TABLE `jbg_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) DEFAULT NULL,
  `name` varchar(16) DEFAULT NULL,
  `res_desc` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `match_type` varchar(16) DEFAULT NULL,
  `http_method` varchar(16) DEFAULT NULL,
  `authority` varchar(40) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `sort` int(11) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL,
  `create_by` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_client_id_authority` (`client_id`,`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of jbg_resource
-- ----------------------------
INSERT INTO `jbg_resource` VALUES ('1', null, '系统管理', '', '', null, '', 'system_menu_group', '0', 'menu_group', '1', '1', null, '2018-03-23 17:32:23.408', null, '2018-05-04 17:13:23.853');
INSERT INTO `jbg_resource` VALUES ('2', null, '用户管理', '', '/admin/user.html', null, '', 'user_menu', '1', 'menu', '0', '1', null, '2018-03-23 17:32:49.298', null, '2018-03-24 01:59:25.718');
INSERT INTO `jbg_resource` VALUES ('3', null, '角色管理', '', '/admin/role.html', null, '', 'role_menu', '1', 'menu', '1', '1', null, '2018-03-24 01:59:41.793', null, null);
INSERT INTO `jbg_resource` VALUES ('58', null, '用户查询接口', '', '/admin/user', null, 'GET', 'user_api', '2', 'api', '0', '1', null, '2018-04-12 11:05:25.924', null, null);
INSERT INTO `jbg_resource` VALUES ('59', null, '用户添加页面', '', '/admin/user_add.html', null, '', 'user_add_page', '2', 'page', '0', '1', null, '2018-04-12 11:06:00.337', null, null);
INSERT INTO `jbg_resource` VALUES ('60', null, '用户编辑页面', '', '/admin/user_edit.html', null, '', 'user_edit_page', '2', 'page', '0', '1', null, '2018-04-12 11:06:40.606', null, null);
INSERT INTO `jbg_resource` VALUES ('61', null, '用户添加接口', '', '/admin/user', null, 'POST', 'user_add_api', '2', 'api', '0', '1', null, '2018-04-12 11:07:09.339', null, null);
INSERT INTO `jbg_resource` VALUES ('62', null, '用户修改接口', '', '/admin/user', null, 'PUT', 'user_edit_api', '2', 'api', '0', '1', null, '2018-04-12 11:07:32.874', null, null);
INSERT INTO `jbg_resource` VALUES ('63', null, '角色管理页面', '', '/admin/role.html', null, '', 'role_page', '3', 'page', '1', '1', null, '2018-04-12 11:08:22.409', null, null);
INSERT INTO `jbg_resource` VALUES ('64', null, '角色创建接口', '', '/admin/role', null, 'POST', 'role_add_api', '3', 'api', '0', '1', null, '2018-04-12 11:09:40.680', null, null);
INSERT INTO `jbg_resource` VALUES ('65', null, '角色修改接口', '', '/admin/role', null, 'PUT', 'role_update_api', '3', 'api', '0', '1', null, '2018-04-12 11:10:06.530', null, null);
INSERT INTO `jbg_resource` VALUES ('66', null, '角色删除接口', '', '/admin/role', null, 'DELETE', 'role_del_api', '3', 'api', '0', '1', null, '2018-04-12 11:17:13.585', null, null);
INSERT INTO `jbg_resource` VALUES ('67', null, '资源管理', '', '/admin/resource.html', null, '', 'resource_menu', '1', 'menu', '2', '1', null, '2018-04-12 11:45:46.880', null, '2018-05-04 17:14:16.652');
INSERT INTO `jbg_resource` VALUES ('70', null, '资源管理页面', '', '/admin/resource.html', null, '', 'resource_page', '67', 'page', '2', '1', null, '2018-05-04 17:04:22.156', null, '2018-05-04 17:04:30.409');
INSERT INTO `jbg_resource` VALUES ('71', null, '资源创建接口', '', '/admin/resource', null, 'POST', 'resource_add_api', '67', 'api', '2', '1', null, '2018-05-04 17:05:06.600', null, '2018-05-04 17:06:09.438');
INSERT INTO `jbg_resource` VALUES ('72', null, '资源修改接口', '', '/admin/resource', null, 'PUT', 'resource_update_api', '67', 'api', '2', '1', null, '2018-05-04 17:05:42.627', null, null);
INSERT INTO `jbg_resource` VALUES ('73', null, '资源删除接口', '', '/admin/resource', null, 'DELETE', 'resource_del_api', '67', 'api', '2', '1', null, '2018-05-04 17:06:03.067', null, null);
INSERT INTO `jbg_resource` VALUES ('74', null, '用户查询页面', '', '/admin/user.html', null, '', 'user_page', '2', 'page', '0', '1', null, '2018-05-04 17:14:59.643', null, null);

-- ----------------------------
-- Table structure for `jbg_role`
-- ----------------------------
DROP TABLE IF EXISTS `jbg_role`;
CREATE TABLE `jbg_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `client_id` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_by` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_id_client_id` (`id`,`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of jbg_role
-- ----------------------------
INSERT INTO `jbg_role` VALUES ('1', '系统管理员', null, null, '1', null, '2018-03-24 01:30:11.361', null, '2018-05-04 17:15:20.895');
INSERT INTO `jbg_role` VALUES ('2', 'Demo角色', null, null, '1', null, '2018-03-24 02:13:04.145', null, '2018-05-04 17:10:00.137');
INSERT INTO `jbg_role` VALUES ('3', '测试', null, null, '1', null, '2018-04-12 09:39:08.494', null, '2018-05-04 17:10:06.134');

-- ----------------------------
-- Table structure for `jbg_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `jbg_role_resource`;
CREATE TABLE `jbg_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `status` varchar(8) DEFAULT NULL,
  `create_by` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_role_id_resource_id` (`role_id`,`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1129 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of jbg_role_resource
-- ----------------------------
INSERT INTO `jbg_role_resource` VALUES ('1045', '1', '1', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1046', '1', '2', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1048', '1', '58', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1049', '1', '59', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1050', '1', '60', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1051', '1', '61', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1052', '1', '62', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1053', '1', '3', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1054', '1', '64', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1055', '1', '65', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1056', '1', '66', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1057', '1', '63', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1059', '1', '67', '0', null, '2018-05-04 17:00:10.721', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1060', '1', '1', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1061', '1', '2', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1062', '1', '58', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1063', '1', '59', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1064', '1', '60', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1065', '1', '61', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1066', '1', '62', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1067', '1', '3', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1068', '1', '64', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1069', '1', '65', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1070', '1', '66', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1071', '1', '63', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1072', '1', '67', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1073', '1', '70', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1074', '1', '71', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1075', '1', '72', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1076', '1', '73', '0', null, '2018-05-04 17:09:37.565', null, '2018-05-04 17:15:21.018');
INSERT INTO `jbg_role_resource` VALUES ('1111', '1', '1', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1112', '1', '2', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1113', '1', '58', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1114', '1', '59', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1115', '1', '60', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1116', '1', '61', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1117', '1', '62', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1118', '1', '74', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1119', '1', '3', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1120', '1', '64', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1121', '1', '65', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1122', '1', '66', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1123', '1', '63', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1124', '1', '67', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1125', '1', '70', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1126', '1', '71', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1127', '1', '72', '1', null, '2018-05-04 17:15:21.235', null, null);
INSERT INTO `jbg_role_resource` VALUES ('1128', '1', '73', '1', null, '2018-05-04 17:15:21.235', null, null);

-- ----------------------------
-- Table structure for `jbg_user`
-- ----------------------------
DROP TABLE IF EXISTS `jbg_user`;
CREATE TABLE `jbg_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `real_name` varchar(16) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `expire_time` datetime DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL,
  `create_by` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of jbg_user
-- ----------------------------
INSERT INTO `jbg_user` VALUES ('17', 'admin', '21232f297a57a5a743894a0e4a801fc3', '系统管理员', '男', null, '1', null, '2018-03-08 11:24:24.839', null, '2018-04-20 10:03:51.854');

-- ----------------------------
-- Table structure for `jbg_user_resource`
-- ----------------------------
DROP TABLE IF EXISTS `jbg_user_resource`;
CREATE TABLE `jbg_user_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `resource_id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_by` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id_resource_id` (`user_id`,`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of jbg_user_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `jbg_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `jbg_user_role`;
CREATE TABLE `jbg_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_by` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id_role_id` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of jbg_user_role
-- ----------------------------
INSERT INTO `jbg_user_role` VALUES ('3', '17', null, '2', '1', null, '2018-03-24 02:15:24.783', null, null);
INSERT INTO `jbg_user_role` VALUES ('4', '17', null, '1', '1', null, '2018-03-27 15:41:20.243', null, null);

