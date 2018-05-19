/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : sign

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-18 19:21:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `department_name` varchar(255) NOT NULL COMMENT '部门名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会议id',
  `meeting_name` varchar(255) NOT NULL COMMENT '会议名称',
  `meeting_content` varchar(255) NOT NULL COMMENT '会议内容',
  `meeting_status` int(11) NOT NULL DEFAULT '1' COMMENT '会议状态（1按时开始 -1取消会议）',
  `meeting_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '参会部门id(0 为全体部门）',
  `meeting_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '会议时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `task_name` varchar(255) NOT NULL COMMENT '任务名称',
  `task_department_id` int(11) NOT NULL COMMENT '任务所属部门id(0为所有部门）',
  `task_charge_id` int(11) NOT NULL COMMENT '负责人id',
  `task_content` varchar(255) NOT NULL COMMENT '任务内容',
  `task_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '任务状态（1正在生效，0已停止，-1已废除）',
  `task_cycle` int(11) NOT NULL COMMENT '任务周期（单位/小时）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_account` varchar(255) NOT NULL COMMENT '用户账号',
  `user_pwd` varchar(255) NOT NULL COMMENT '用户密码',
  `user_name` varchar(255) NOT NULL COMMENT '用户姓名',
  `employee_number` varchar(255) NOT NULL DEFAULT '' COMMENT '用户工号',
  `user_gender` tinyint(4) NOT NULL COMMENT '用户性别（0为女，1为男）',
  `user_birthday` datetime NOT NULL COMMENT '用户生日',
  `user_phone` varchar(255) NOT NULL COMMENT '用户手机号',
  `user_email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `user_status` int(10) NOT NULL DEFAULT '0' COMMENT '用户状态（-1已注销  0注册未审核  1训练中  2训练完成  9管理员  10超级管理员）',
  `user_department_id` int(10) NOT NULL DEFAULT '0' COMMENT '用户所在部门id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_meeting
-- ----------------------------
DROP TABLE IF EXISTS `user_meeting`;
CREATE TABLE `user_meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `meeting_id` int(11) NOT NULL COMMENT '会议id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '查看状态(0未查看 1已查看 -1已作废)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_task
-- ----------------------------
DROP TABLE IF EXISTS `user_task`;
CREATE TABLE `user_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `task_id` int(11) NOT NULL COMMENT '任务id',
  `status` int(11) NOT NULL COMMENT '任务完成状态（1进行中 2已递交 3已完成）',
  `message_waiting` varchar(255) NOT NULL DEFAULT '' COMMENT '对管理员的留言',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始任务时间',
  `dead_line` datetime DEFAULT NULL COMMENT '应完成的最后时间',
  `commit_time` datetime DEFAULT NULL COMMENT '递交时间',
  `end_time` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
