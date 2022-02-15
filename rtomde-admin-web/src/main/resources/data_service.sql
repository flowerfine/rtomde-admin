SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) NOT NULL COMMENT '部门名称',
  `code` varchar(64) NOT NULL COMMENT '部门标识',
  `organization_id` bigint NOT NULL COMMENT '组织id',
  `parent_id` bigint DEFAULT NULL COMMENT '上级部门id',
  `avatar` varchar(256) NOT NULL DEFAULT '' COMMENT '头像',
  `desc` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标识。0: 未删除, 1: 已删除',
  `creator` varchar(255) NOT NULL DEFAULT 'system' COMMENT '创建人 ',
  `updater` varchar(255) NOT NULL DEFAULT 'system' COMMENT '修改者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB COMMENT='部门表';

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) NOT NULL COMMENT '组织名称',
  `avatar` varchar(256) NOT NULL DEFAULT '' COMMENT '头像',
  `desc` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标识。0: 未删除, 1: 已删除',
  `creator` varchar(255) NOT NULL DEFAULT 'system' COMMENT '创建人 ',
  `updater` varchar(255) NOT NULL DEFAULT 'system' COMMENT '修改者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB COMMENT='组织表';

-- ----------------------------
-- Table structure for sys_relation_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation_user_dept`;
CREATE TABLE `sys_relation_user_dept` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `dept_id` bigint NOT NULL COMMENT '部门id',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标识。0: 未删除, 1: 已删除',
  `creator` varchar(255) NOT NULL DEFAULT 'system' COMMENT '创建人 ',
  `updater` varchar(255) NOT NULL DEFAULT 'system' COMMENT '修改者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB COMMENT='用户-部门表';

-- ----------------------------
-- Table structure for sys_relation_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation_user_role`;
CREATE TABLE `sys_relation_user_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标识。0: 未删除, 1: 已删除',
  `creator` varchar(255) NOT NULL DEFAULT 'system' COMMENT '创建人 ',
  `updater` varchar(255) NOT NULL DEFAULT 'system' COMMENT '修改者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB COMMENT='用户-角色关联表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `code` varchar(64) NOT NULL COMMENT '角色标识',
  `organization_id` bigint NOT NULL COMMENT '组织id',
  `avatar` varchar(256) NOT NULL DEFAULT '' COMMENT '头像',
  `desc` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',
  `type` tinyint NOT NULL DEFAULT '2' COMMENT '角色类型: 0:超级管理员, 1:系统管理员, 2:普通角色',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标识。0: 未删除, 1: 已删除',
  `creator` varchar(255) NOT NULL DEFAULT 'system' COMMENT '创建人 ',
  `updater` varchar(255) NOT NULL DEFAULT 'system' COMMENT '修改者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(64) NOT NULL DEFAULT '' COMMENT '昵称',
  `avatar` varchar(256) NOT NULL DEFAULT '' COMMENT '头像',
  `email` varchar(255) NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone` varchar(18) NOT NULL DEFAULT '' COMMENT '手机号码',
  `desc` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',
  `password_expire_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '密码过期时间',
  `user_expire_time` datetime COMMENT '用户过期时间',
  `enabled` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '启用标识。0:未启用, 1:已启用',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标识。0: 未删除, 1: 已删除',
  `creator` varchar(255) NOT NULL DEFAULT 'system' COMMENT '创建人 ',
  `updater` varchar(255) NOT NULL DEFAULT 'system' COMMENT '修改者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`) USING BTREE,
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user`(`username`, `password`, `nickname`, `avatar`, `email`, `phone`, `desc`, `password_expire_time`, `user_expire_time`, `enabled`, `creator`, `updater`, `comments`) VALUES ('wangqi', '123', '王奇', '', '', '', '', '2022-02-08 12:57:42', NULL, 1, 'system', 'system', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
