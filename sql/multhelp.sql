/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.23 : Database - multhelp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`multhelp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `multhelp`;

/*Table structure for table `gen_table` */

DROP TABLE IF EXISTS `gen_table`;

CREATE TABLE `gen_table` (
  `table_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) COLLATE utf8mb4_general_ci DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) COLLATE utf8mb4_general_ci DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='代码生成业务表';

/*Data for the table `gen_table` */

insert  into `gen_table`(`table_id`,`table_name`,`table_comment`,`sub_table_name`,`sub_table_fk_name`,`class_name`,`tpl_category`,`package_name`,`module_name`,`business_name`,`function_name`,`function_author`,`gen_type`,`gen_path`,`options`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'multhelp_account','aa',NULL,NULL,'MulthelpAccount','crud','com.ruoyi.system','system','account','a','ruoyi','0','/','{\"parentMenuId\":2000}','admin','2021-05-26 16:16:43','','2021-05-26 16:18:41',NULL),
(2,'multhelp_chat','c',NULL,NULL,'MulthelpChat','crud','com.ruoyi.system','system','chat','c','ruoyi','0','/','{\"parentMenuId\":2000}','admin','2021-05-26 16:16:43','','2021-05-26 16:20:05',NULL),
(3,'multhelp_chatandcontent','c',NULL,NULL,'MulthelpChatandcontent','crud','com.ruoyi.system','system','chatandcontent','cc','ruoyi','0','/','{\"parentMenuId\":2000}','admin','2021-05-26 16:16:43','','2021-05-26 16:20:21',NULL),
(4,'multhelp_content','cc',NULL,NULL,'MulthelpContent','crud','com.ruoyi.system','system','content','cc','ruoyi','0','/','{\"parentMenuId\":2000}','admin','2021-05-26 16:16:43','','2021-05-26 16:20:31',NULL),
(5,'multhelp_login','c',NULL,NULL,'MulthelpLogin','crud','com.ruoyi.system','system','login','cc','ruoyi','0','/','{\"parentMenuId\":2000}','admin','2021-05-26 16:16:43','','2021-05-26 16:20:43',NULL),
(6,'multhelp_message','c',NULL,NULL,'MulthelpMessage','crud','com.ruoyi.system','system','message','c','ruoyi','0','/','{\"parentMenuId\":2000}','admin','2021-05-26 16:16:43','','2021-05-26 16:20:52',NULL),
(7,'multhelp_post','s',NULL,NULL,'MulthelpPost','crud','com.ruoyi.system','system','post','s','ruoyi','0','/','{\"parentMenuId\":2000}','admin','2021-05-26 16:16:43','','2021-05-26 16:21:03',NULL);

/*Table structure for table `gen_table_column` */

DROP TABLE IF EXISTS `gen_table_column`;

CREATE TABLE `gen_table_column` (
  `column_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) COLLATE utf8mb4_general_ci DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '字典类型',
  `sort` int DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='代码生成业务表字段';

/*Data for the table `gen_table_column` */

insert  into `gen_table_column`(`column_id`,`table_id`,`column_name`,`column_comment`,`column_type`,`java_type`,`java_field`,`is_pk`,`is_increment`,`is_required`,`is_insert`,`is_edit`,`is_list`,`is_query`,`query_type`,`html_type`,`dict_type`,`sort`,`create_by`,`create_time`,`update_by`,`update_time`) values 
(1,'1','openid','微信给的账户id','varchar(128)','String','openid','1','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(2,'1','nickname','昵称','varchar(50)','String','nickname','0','0',NULL,'1','1','1','1','LIKE','input','',2,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(3,'1','avatarurl','头像地址','varchar(255)','String','avatarurl','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(4,'1','gender','性别','tinyint','Long','gender','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(5,'1','language','语言','varchar(50)','String','language','0','0',NULL,'1','1','1','1','EQ','input','',5,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(6,'1','city','城市','varchar(50)','String','city','0','0',NULL,'1','1','1','1','EQ','input','',6,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(7,'1','province','省份','varchar(50)','String','province','0','0',NULL,'1','1','1','1','EQ','input','',7,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(8,'1','country','国家','varchar(50)','String','country','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2021-05-26 16:16:43','','2021-05-26 16:18:41'),
(9,'2','chatid','聊天id','bigint(20) unsigned zerofill','Long','chatid','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:05'),
(10,'2','initiator_openid','发起者','varchar(128)','String','initiatorOpenid','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:05'),
(11,'2','invitee_openid','受邀者','varchar(128)','String','inviteeOpenid','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:05'),
(12,'2','create_time','创建时间','timestamp','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',4,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:05'),
(13,'3','chatid','聊天id','bigint','Long','chatid','0','0',NULL,'1','1','1','1','EQ','input','',1,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:21'),
(14,'3','contentid','聊天内容id','bigint','Long','contentid','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:21'),
(15,'4','contentid','内容id','bigint(20) unsigned zerofill','Long','contentid','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:31'),
(16,'4','send_openid','发送者id','varchar(128)','String','sendOpenid','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:31'),
(17,'4','receive_openid','接收者id','varchar(128)','String','receiveOpenid','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:31'),
(18,'4','sender','发送人','varchar(128)','String','sender','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:31'),
(19,'4','content','内容','varchar(128)','String','content','0','0',NULL,'1','1','1','1','EQ','editor','',5,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:31'),
(20,'4','is_read','已读','tinyint(1)','Integer','isRead','0','0',NULL,'1','1','1','1','EQ','input','',6,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:31'),
(21,'4','create_time','创建时间','timestamp','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',7,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:31'),
(22,'5','session_3rd','服务器给的临时验证','varchar(255)','String','session3rd','1','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:43'),
(23,'5','openid','微信给的id','varchar(255)','String','openid','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:43'),
(24,'5','session_key','微信给的会话key','varchar(255)','String','sessionKey','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:43'),
(25,'5','create_time','创建时间','timestamp','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',4,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:43'),
(26,'6','chatid','聊天id','bigint','Long','chatid','0','0',NULL,'1','1','1','1','EQ','input','',1,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:52'),
(27,'6','last_contentid','最近的聊天内容id','bigint','Long','lastContentid','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-26 16:16:43','','2021-05-26 16:20:52'),
(28,'7','postid','发布帮助id','bigint(10) unsigned zerofill','Integer','postid','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(29,'7','publish_openid','发布人id','varchar(255)','String','publishOpenid','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(30,'7','receive_openid','帮助人id','varchar(255)','String','receiveOpenid','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(31,'7','tittle','标题','varchar(255)','String','tittle','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(32,'7','detail','详情','tinytext','String','detail','0','0',NULL,'1','1','1','1','EQ','textarea','',5,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(33,'7','category','类别','varchar(50)','String','category','0','0',NULL,'1','1','1','1','EQ','input','',6,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(34,'7','address','地址','varchar(255)','String','address','0','0',NULL,'1','1','1','1','EQ','input','',7,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(35,'7','price','价格','varchar(50)','String','price','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(36,'7','phone','电话','varchar(50)','String','phone','0','0',NULL,'1','1','1','1','EQ','input','',9,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(37,'7','create_time','创建时间','timestamp','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',10,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(38,'7','need_time','需要时间','timestamp','Date','needTime','0','0',NULL,'1','1','1','1','EQ','datetime','',11,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(39,'7','end_time','被帮助时间','timestamp','Date','endTime','0','0',NULL,'1','1','1','1','EQ','datetime','',12,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03'),
(40,'7','is_value','是否已经被绑住','tinyint(1)','Integer','isValue','0','0',NULL,'1','1','1','1','EQ','input','',13,'admin','2021-05-26 16:16:43','','2021-05-26 16:21:03');

/*Table structure for table `multhelp_account` */

DROP TABLE IF EXISTS `multhelp_account`;

CREATE TABLE `multhelp_account` (
  `openid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信给的账户id',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '昵称',
  `avatarurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '头像地址',
  `gender` tinyint DEFAULT '0' COMMENT '性别',
  `language` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '语言',
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '城市',
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '省份',
  `country` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `multhelp_account` */

/*Table structure for table `multhelp_chat` */

DROP TABLE IF EXISTS `multhelp_chat`;

CREATE TABLE `multhelp_chat` (
  `chatid` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '聊天id',
  `initiator_openid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发起者',
  `invitee_openid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '受邀者',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`chatid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `multhelp_chat` */

/*Table structure for table `multhelp_chatandcontent` */

DROP TABLE IF EXISTS `multhelp_chatandcontent`;

CREATE TABLE `multhelp_chatandcontent` (
  `chatid` bigint DEFAULT NULL COMMENT '聊天id',
  `contentid` bigint DEFAULT NULL COMMENT '聊天内容id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `multhelp_chatandcontent` */

/*Table structure for table `multhelp_content` */

DROP TABLE IF EXISTS `multhelp_content`;

CREATE TABLE `multhelp_content` (
  `contentid` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '内容id',
  `send_openid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发送者id',
  `receive_openid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接收者id',
  `sender` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发送人',
  `content` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `is_read` tinyint(1) DEFAULT '0' COMMENT '已读',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`contentid`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

/*Data for the table `multhelp_content` */

/*Table structure for table `multhelp_login` */

DROP TABLE IF EXISTS `multhelp_login`;

CREATE TABLE `multhelp_login` (
  `session_3rd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '服务器给的临时验证',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '微信给的id',
  `session_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '微信给的会话key',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`session_3rd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `multhelp_login` */

/*Table structure for table `multhelp_message` */

DROP TABLE IF EXISTS `multhelp_message`;

CREATE TABLE `multhelp_message` (
  `chatid` bigint DEFAULT NULL COMMENT '聊天id',
  `last_contentid` bigint DEFAULT NULL COMMENT '最近的聊天内容id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `multhelp_message` */

/*Table structure for table `multhelp_post` */

DROP TABLE IF EXISTS `multhelp_post`;

CREATE TABLE `multhelp_post` (
  `postid` bigint(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '发布帮助id',
  `publish_openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '发布人id',
  `receive_openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '帮助人id',
  `tittle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '标题',
  `detail` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '详情',
  `category` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '类别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '地址',
  `price` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '价格',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '电话',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `need_time` timestamp NULL DEFAULT NULL COMMENT '需要时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '被帮助时间',
  `is_value` tinyint(1) DEFAULT '1' COMMENT '是否已经被绑住',
  PRIMARY KEY (`postid`),
  FULLTEXT KEY `ft_index` (`tittle`,`detail`,`address`) /*!50100 WITH PARSER `ngram` */ 
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `multhelp_post` */

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `calendar_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `cron_expression` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `time_zone_id` varchar(80) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`cron_expression`,`time_zone_id`) values 
('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT','0/10 * * * * ?','GMT+08:00'),
('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT','0/15 * * * * ?','GMT+08:00'),
('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT','0/20 * * * * ?','GMT+08:00');

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `entry_id` varchar(95) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `instance_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `fired_time` bigint NOT NULL,
  `sched_time` bigint NOT NULL,
  `priority` int NOT NULL,
  `state` varchar(16) COLLATE utf8mb4_general_ci NOT NULL,
  `job_name` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `job_group` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_nonconcurrent` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `requests_recovery` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_fired_triggers` */

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `job_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `job_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(250) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `job_class_name` varchar(250) COLLATE utf8mb4_general_ci NOT NULL,
  `is_durable` varchar(1) COLLATE utf8mb4_general_ci NOT NULL,
  `is_nonconcurrent` varchar(1) COLLATE utf8mb4_general_ci NOT NULL,
  `is_update_data` varchar(1) COLLATE utf8mb4_general_ci NOT NULL,
  `requests_recovery` varchar(1) COLLATE utf8mb4_general_ci NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`sched_name`,`job_name`,`job_group`,`description`,`job_class_name`,`is_durable`,`is_nonconcurrent`,`is_update_data`,`requests_recovery`,`job_data`) values 
('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT',NULL,'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.ruoyi.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0y���xpt\0\0pppt\01t\00/10 * * * * ?t\0ryTask.ryNoParamst\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（无参）t\03t\01x\0'),
('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT',NULL,'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.ruoyi.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0y���xpt\0\0pppt\01t\00/15 * * * * ?t\0ryTask.ryParams(\'ry\')t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（有参）t\03t\01x\0'),
('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT',NULL,'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.ruoyi.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0y���xpt\0\0pppt\01t\00/20 * * * * ?t\08ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（多参）t\03t\01x\0');

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `lock_name` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`sched_name`,`lock_name`) values 
('RuoyiScheduler','STATE_ACCESS'),
('RuoyiScheduler','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `instance_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `last_checkin_time` bigint NOT NULL,
  `checkin_interval` bigint NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_scheduler_state` */

insert  into `qrtz_scheduler_state`(`sched_name`,`instance_name`,`last_checkin_time`,`checkin_interval`) values 
('RuoyiScheduler','msi1622016973818',1622017353025,15000);

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `repeat_count` bigint NOT NULL,
  `repeat_interval` bigint NOT NULL,
  `times_triggered` bigint NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `str_prop_1` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `str_prop_2` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `str_prop_3` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `int_prop_1` int DEFAULT NULL,
  `int_prop_2` int DEFAULT NULL,
  `long_prop_1` bigint DEFAULT NULL,
  `long_prop_2` bigint DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `bool_prop_2` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `job_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `job_group` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(250) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `next_fire_time` bigint DEFAULT NULL,
  `prev_fire_time` bigint DEFAULT NULL,
  `priority` int DEFAULT NULL,
  `trigger_state` varchar(16) COLLATE utf8mb4_general_ci NOT NULL,
  `trigger_type` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `start_time` bigint NOT NULL,
  `end_time` bigint DEFAULT NULL,
  `calendar_name` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `misfire_instr` smallint DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`job_name`,`job_group`,`description`,`next_fire_time`,`prev_fire_time`,`priority`,`trigger_state`,`trigger_type`,`start_time`,`end_time`,`calendar_name`,`misfire_instr`,`job_data`) values 
('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT','TASK_CLASS_NAME1','DEFAULT',NULL,1622016980000,-1,5,'PAUSED','CRON',1622016974000,0,NULL,2,''),
('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT','TASK_CLASS_NAME2','DEFAULT',NULL,1622016975000,-1,5,'PAUSED','CRON',1622016974000,0,NULL,2,''),
('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT','TASK_CLASS_NAME3','DEFAULT',NULL,1622016980000,-1,5,'PAUSED','CRON',1622016974000,0,NULL,2,'');

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `config_id` int NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) COLLATE utf8mb4_general_ci DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='参数配置表';

/*Data for the table `sys_config` */

insert  into `sys_config`(`config_id`,`config_name`,`config_key`,`config_value`,`config_type`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2021-05-26 16:00:03','',NULL,'蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),
(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2021-05-26 16:00:03','',NULL,'初始化密码 123456'),
(3,'主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2021-05-26 16:00:03','',NULL,'深色主题theme-dark，浅色主题theme-light');

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '部门名称',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`parent_id`,`ancestors`,`dept_name`,`order_num`,`leader`,`phone`,`email`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`) values 
(100,0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(101,100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(102,100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(103,101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(104,101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(105,101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(106,101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(108,102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL),
(109,102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-05-26 16:00:03','',NULL);

/*Table structure for table `sys_dict_data` */

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
  `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) COLLATE utf8mb4_general_ci DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典数据表';

/*Data for the table `sys_dict_data` */

insert  into `sys_dict_data`(`dict_code`,`dict_sort`,`dict_label`,`dict_value`,`dict_type`,`css_class`,`list_class`,`is_default`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,1,'男','0','sys_user_sex','','','Y','0','admin','2021-05-26 16:00:03','',NULL,'性别男'),
(2,2,'女','1','sys_user_sex','','','N','0','admin','2021-05-26 16:00:03','',NULL,'性别女'),
(3,3,'未知','2','sys_user_sex','','','N','0','admin','2021-05-26 16:00:03','',NULL,'性别未知'),
(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2021-05-26 16:00:03','',NULL,'显示菜单'),
(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'隐藏菜单'),
(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2021-05-26 16:00:03','',NULL,'正常状态'),
(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'停用状态'),
(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2021-05-26 16:00:03','',NULL,'正常状态'),
(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'停用状态'),
(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2021-05-26 16:00:03','',NULL,'默认分组'),
(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2021-05-26 16:00:03','',NULL,'系统分组'),
(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2021-05-26 16:00:03','',NULL,'系统默认是'),
(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'系统默认否'),
(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2021-05-26 16:00:03','',NULL,'通知'),
(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2021-05-26 16:00:03','',NULL,'公告'),
(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2021-05-26 16:00:03','',NULL,'正常状态'),
(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'关闭状态'),
(18,1,'新增','1','sys_oper_type','','info','N','0','admin','2021-05-26 16:00:03','',NULL,'新增操作'),
(19,2,'修改','2','sys_oper_type','','info','N','0','admin','2021-05-26 16:00:03','',NULL,'修改操作'),
(20,3,'删除','3','sys_oper_type','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'删除操作'),
(21,4,'授权','4','sys_oper_type','','primary','N','0','admin','2021-05-26 16:00:03','',NULL,'授权操作'),
(22,5,'导出','5','sys_oper_type','','warning','N','0','admin','2021-05-26 16:00:03','',NULL,'导出操作'),
(23,6,'导入','6','sys_oper_type','','warning','N','0','admin','2021-05-26 16:00:03','',NULL,'导入操作'),
(24,7,'强退','7','sys_oper_type','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'强退操作'),
(25,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2021-05-26 16:00:03','',NULL,'生成操作'),
(26,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'清空操作'),
(27,1,'成功','0','sys_common_status','','primary','N','0','admin','2021-05-26 16:00:03','',NULL,'正常状态'),
(28,2,'失败','1','sys_common_status','','danger','N','0','admin','2021-05-26 16:00:03','',NULL,'停用状态');

/*Table structure for table `sys_dict_type` */

DROP TABLE IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type` (
  `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '字典类型',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典类型表';

/*Data for the table `sys_dict_type` */

insert  into `sys_dict_type`(`dict_id`,`dict_name`,`dict_type`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'用户性别','sys_user_sex','0','admin','2021-05-26 16:00:03','',NULL,'用户性别列表'),
(2,'菜单状态','sys_show_hide','0','admin','2021-05-26 16:00:03','',NULL,'菜单状态列表'),
(3,'系统开关','sys_normal_disable','0','admin','2021-05-26 16:00:03','',NULL,'系统开关列表'),
(4,'任务状态','sys_job_status','0','admin','2021-05-26 16:00:03','',NULL,'任务状态列表'),
(5,'任务分组','sys_job_group','0','admin','2021-05-26 16:00:03','',NULL,'任务分组列表'),
(6,'系统是否','sys_yes_no','0','admin','2021-05-26 16:00:03','',NULL,'系统是否列表'),
(7,'通知类型','sys_notice_type','0','admin','2021-05-26 16:00:03','',NULL,'通知类型列表'),
(8,'通知状态','sys_notice_status','0','admin','2021-05-26 16:00:03','',NULL,'通知状态列表'),
(9,'操作类型','sys_oper_type','0','admin','2021-05-26 16:00:03','',NULL,'操作类型列表'),
(10,'系统状态','sys_common_status','0','admin','2021-05-26 16:00:03','',NULL,'登录状态列表');

/*Table structure for table `sys_job` */

DROP TABLE IF EXISTS `sys_job`;

CREATE TABLE `sys_job` (
  `job_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) COLLATE utf8mb4_general_ci DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='定时任务调度表';

/*Data for the table `sys_job` */

insert  into `sys_job`(`job_id`,`job_name`,`job_group`,`invoke_target`,`cron_expression`,`misfire_policy`,`concurrent`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2021-05-26 16:00:03','',NULL,''),
(2,'系统默认（有参）','DEFAULT','ryTask.ryParams(\'ry\')','0/15 * * * * ?','3','1','1','admin','2021-05-26 16:00:03','',NULL,''),
(3,'系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2021-05-26 16:00:03','',NULL,'');

/*Table structure for table `sys_job_log` */

DROP TABLE IF EXISTS `sys_job_log`;

CREATE TABLE `sys_job_log` (
  `job_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '日志信息',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='定时任务调度日志表';

/*Data for the table `sys_job_log` */

/*Table structure for table `sys_logininfor` */

DROP TABLE IF EXISTS `sys_logininfor`;

CREATE TABLE `sys_logininfor` (
  `info_id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '操作系统',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统访问记录';

/*Data for the table `sys_logininfor` */

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件路径',
  `is_frame` int DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2043 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='菜单权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_name`,`parent_id`,`order_num`,`path`,`component`,`is_frame`,`is_cache`,`menu_type`,`visible`,`status`,`perms`,`icon`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'系统管理',0,1,'system',NULL,1,0,'M','0','0','','system','admin','2021-05-26 16:00:03','',NULL,'系统管理目录'),
(2,'系统监控',0,2,'monitor',NULL,1,0,'M','0','0','','monitor','admin','2021-05-26 16:00:03','',NULL,'系统监控目录'),
(3,'系统工具',0,3,'tool',NULL,1,0,'M','0','0','','tool','admin','2021-05-26 16:00:03','',NULL,'系统工具目录'),
(4,'若依官网',0,4,'http://ruoyi.vip',NULL,0,0,'M','0','0','','guide','admin','2021-05-26 16:00:03','',NULL,'若依官网地址'),
(100,'用户管理',1,1,'user','system/user/index',1,0,'C','0','0','system:user:list','user','admin','2021-05-26 16:00:03','',NULL,'用户管理菜单'),
(101,'角色管理',1,2,'role','system/role/index',1,0,'C','0','0','system:role:list','peoples','admin','2021-05-26 16:00:03','',NULL,'角色管理菜单'),
(102,'菜单管理',1,3,'menu','system/menu/index',1,0,'C','0','0','system:menu:list','tree-table','admin','2021-05-26 16:00:03','',NULL,'菜单管理菜单'),
(103,'部门管理',1,4,'dept','system/dept/index',1,0,'C','0','0','system:dept:list','tree','admin','2021-05-26 16:00:03','',NULL,'部门管理菜单'),
(104,'岗位管理',1,5,'post','system/post/index',1,0,'C','0','0','system:post:list','post','admin','2021-05-26 16:00:03','',NULL,'岗位管理菜单'),
(105,'字典管理',1,6,'dict','system/dict/index',1,0,'C','0','0','system:dict:list','dict','admin','2021-05-26 16:00:03','',NULL,'字典管理菜单'),
(106,'参数设置',1,7,'config','system/config/index',1,0,'C','0','0','system:config:list','edit','admin','2021-05-26 16:00:03','',NULL,'参数设置菜单'),
(107,'通知公告',1,8,'notice','system/notice/index',1,0,'C','0','0','system:notice:list','message','admin','2021-05-26 16:00:03','',NULL,'通知公告菜单'),
(108,'日志管理',1,9,'log','',1,0,'M','0','0','','log','admin','2021-05-26 16:00:03','',NULL,'日志管理菜单'),
(109,'在线用户',2,1,'online','monitor/online/index',1,0,'C','0','0','monitor:online:list','online','admin','2021-05-26 16:00:03','',NULL,'在线用户菜单'),
(110,'定时任务',2,2,'job','monitor/job/index',1,0,'C','0','0','monitor:job:list','job','admin','2021-05-26 16:00:03','',NULL,'定时任务菜单'),
(111,'数据监控',2,3,'druid','monitor/druid/index',1,0,'C','0','0','monitor:druid:list','druid','admin','2021-05-26 16:00:03','',NULL,'数据监控菜单'),
(112,'服务监控',2,4,'server','monitor/server/index',1,0,'C','0','0','monitor:server:list','server','admin','2021-05-26 16:00:03','',NULL,'服务监控菜单'),
(113,'缓存监控',2,5,'cache','monitor/cache/index',1,0,'C','0','0','monitor:cache:list','redis','admin','2021-05-26 16:00:03','',NULL,'缓存监控菜单'),
(114,'表单构建',3,1,'build','tool/build/index',1,0,'C','0','0','tool:build:list','build','admin','2021-05-26 16:00:03','',NULL,'表单构建菜单'),
(115,'代码生成',3,2,'gen','tool/gen/index',1,0,'C','0','0','tool:gen:list','code','admin','2021-05-26 16:00:03','',NULL,'代码生成菜单'),
(116,'系统接口',3,3,'swagger','tool/swagger/index',1,0,'C','0','0','tool:swagger:list','swagger','admin','2021-05-26 16:00:03','',NULL,'系统接口菜单'),
(500,'操作日志',108,1,'operlog','monitor/operlog/index',1,0,'C','0','0','monitor:operlog:list','form','admin','2021-05-26 16:00:03','',NULL,'操作日志菜单'),
(501,'登录日志',108,2,'logininfor','monitor/logininfor/index',1,0,'C','0','0','monitor:logininfor:list','logininfor','admin','2021-05-26 16:00:03','',NULL,'登录日志菜单'),
(1001,'用户查询',100,1,'','',1,0,'F','0','0','system:user:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1002,'用户新增',100,2,'','',1,0,'F','0','0','system:user:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1003,'用户修改',100,3,'','',1,0,'F','0','0','system:user:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1004,'用户删除',100,4,'','',1,0,'F','0','0','system:user:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1005,'用户导出',100,5,'','',1,0,'F','0','0','system:user:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1006,'用户导入',100,6,'','',1,0,'F','0','0','system:user:import','#','admin','2021-05-26 16:00:03','',NULL,''),
(1007,'重置密码',100,7,'','',1,0,'F','0','0','system:user:resetPwd','#','admin','2021-05-26 16:00:03','',NULL,''),
(1008,'角色查询',101,1,'','',1,0,'F','0','0','system:role:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1009,'角色新增',101,2,'','',1,0,'F','0','0','system:role:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1010,'角色修改',101,3,'','',1,0,'F','0','0','system:role:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1011,'角色删除',101,4,'','',1,0,'F','0','0','system:role:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1012,'角色导出',101,5,'','',1,0,'F','0','0','system:role:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1013,'菜单查询',102,1,'','',1,0,'F','0','0','system:menu:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1014,'菜单新增',102,2,'','',1,0,'F','0','0','system:menu:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1015,'菜单修改',102,3,'','',1,0,'F','0','0','system:menu:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1016,'菜单删除',102,4,'','',1,0,'F','0','0','system:menu:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1017,'部门查询',103,1,'','',1,0,'F','0','0','system:dept:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1018,'部门新增',103,2,'','',1,0,'F','0','0','system:dept:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1019,'部门修改',103,3,'','',1,0,'F','0','0','system:dept:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1020,'部门删除',103,4,'','',1,0,'F','0','0','system:dept:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1021,'岗位查询',104,1,'','',1,0,'F','0','0','system:post:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1022,'岗位新增',104,2,'','',1,0,'F','0','0','system:post:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1023,'岗位修改',104,3,'','',1,0,'F','0','0','system:post:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1024,'岗位删除',104,4,'','',1,0,'F','0','0','system:post:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1025,'岗位导出',104,5,'','',1,0,'F','0','0','system:post:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1026,'字典查询',105,1,'#','',1,0,'F','0','0','system:dict:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1027,'字典新增',105,2,'#','',1,0,'F','0','0','system:dict:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1028,'字典修改',105,3,'#','',1,0,'F','0','0','system:dict:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1029,'字典删除',105,4,'#','',1,0,'F','0','0','system:dict:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1030,'字典导出',105,5,'#','',1,0,'F','0','0','system:dict:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1031,'参数查询',106,1,'#','',1,0,'F','0','0','system:config:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1032,'参数新增',106,2,'#','',1,0,'F','0','0','system:config:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1033,'参数修改',106,3,'#','',1,0,'F','0','0','system:config:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1034,'参数删除',106,4,'#','',1,0,'F','0','0','system:config:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1035,'参数导出',106,5,'#','',1,0,'F','0','0','system:config:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1036,'公告查询',107,1,'#','',1,0,'F','0','0','system:notice:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1037,'公告新增',107,2,'#','',1,0,'F','0','0','system:notice:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1038,'公告修改',107,3,'#','',1,0,'F','0','0','system:notice:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1039,'公告删除',107,4,'#','',1,0,'F','0','0','system:notice:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1040,'操作查询',500,1,'#','',1,0,'F','0','0','monitor:operlog:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1041,'操作删除',500,2,'#','',1,0,'F','0','0','monitor:operlog:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1042,'日志导出',500,4,'#','',1,0,'F','0','0','monitor:operlog:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1043,'登录查询',501,1,'#','',1,0,'F','0','0','monitor:logininfor:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1044,'登录删除',501,2,'#','',1,0,'F','0','0','monitor:logininfor:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1045,'日志导出',501,3,'#','',1,0,'F','0','0','monitor:logininfor:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1046,'在线查询',109,1,'#','',1,0,'F','0','0','monitor:online:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1047,'批量强退',109,2,'#','',1,0,'F','0','0','monitor:online:batchLogout','#','admin','2021-05-26 16:00:03','',NULL,''),
(1048,'单条强退',109,3,'#','',1,0,'F','0','0','monitor:online:forceLogout','#','admin','2021-05-26 16:00:03','',NULL,''),
(1049,'任务查询',110,1,'#','',1,0,'F','0','0','monitor:job:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1050,'任务新增',110,2,'#','',1,0,'F','0','0','monitor:job:add','#','admin','2021-05-26 16:00:03','',NULL,''),
(1051,'任务修改',110,3,'#','',1,0,'F','0','0','monitor:job:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1052,'任务删除',110,4,'#','',1,0,'F','0','0','monitor:job:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1053,'状态修改',110,5,'#','',1,0,'F','0','0','monitor:job:changeStatus','#','admin','2021-05-26 16:00:03','',NULL,''),
(1054,'任务导出',110,7,'#','',1,0,'F','0','0','monitor:job:export','#','admin','2021-05-26 16:00:03','',NULL,''),
(1055,'生成查询',115,1,'#','',1,0,'F','0','0','tool:gen:query','#','admin','2021-05-26 16:00:03','',NULL,''),
(1056,'生成修改',115,2,'#','',1,0,'F','0','0','tool:gen:edit','#','admin','2021-05-26 16:00:03','',NULL,''),
(1057,'生成删除',115,3,'#','',1,0,'F','0','0','tool:gen:remove','#','admin','2021-05-26 16:00:03','',NULL,''),
(1058,'导入代码',115,2,'#','',1,0,'F','0','0','tool:gen:import','#','admin','2021-05-26 16:00:03','',NULL,''),
(1059,'预览代码',115,4,'#','',1,0,'F','0','0','tool:gen:preview','#','admin','2021-05-26 16:00:03','',NULL,''),
(1060,'生成代码',115,5,'#','',1,0,'F','0','0','tool:gen:code','#','admin','2021-05-26 16:00:03','',NULL,''),
(2000,'微信互助',0,0,'multhelp',NULL,1,0,'M','0','0',NULL,'people','admin','2021-05-26 16:17:52','',NULL,''),
(2001,'用户账号',2000,1,'account','multhelp/account/index',1,0,'C','0','0','multhelp:account:list','#','admin','2021-05-26 16:21:57','',NULL,'用户账号菜单'),
(2002,'用户账号查询',2001,1,'#','',1,0,'F','0','0','multhelp:account:query','#','admin','2021-05-26 16:21:57','',NULL,''),
(2003,'用户账号新增',2001,2,'#','',1,0,'F','0','0','multhelp:account:add','#','admin','2021-05-26 16:21:57','',NULL,''),
(2004,'用户账号修改',2001,3,'#','',1,0,'F','0','0','multhelp:account:edit','#','admin','2021-05-26 16:21:57','',NULL,''),
(2005,'用户账号删除',2001,4,'#','',1,0,'F','0','0','multhelp:account:remove','#','admin','2021-05-26 16:21:57','',NULL,''),
(2006,'用户账号导出',2001,5,'#','',1,0,'F','0','0','multhelp:account:export','#','admin','2021-05-26 16:21:57','',NULL,''),
(2007,'聊天会话连接',2000,1,'chatandcontent','multhelp/chatandcontent/index',1,0,'C','0','0','multhelp:chatandcontent:list','#','admin','2021-05-26 16:22:02','',NULL,'聊天会话连接菜单'),
(2008,'聊天会话连接查询',2007,1,'#','',1,0,'F','0','0','multhelp:chatandcontent:query','#','admin','2021-05-26 16:22:02','',NULL,''),
(2009,'聊天会话连接新增',2007,2,'#','',1,0,'F','0','0','multhelp:chatandcontent:add','#','admin','2021-05-26 16:22:02','',NULL,''),
(2010,'聊天会话连接修改',2007,3,'#','',1,0,'F','0','0','multhelp:chatandcontent:edit','#','admin','2021-05-26 16:22:02','',NULL,''),
(2011,'聊天会话连接删除',2007,4,'#','',1,0,'F','0','0','multhelp:chatandcontent:remove','#','admin','2021-05-26 16:22:02','',NULL,''),
(2012,'聊天会话连接导出',2007,5,'#','',1,0,'F','0','0','multhelp:chatandcontent:export','#','admin','2021-05-26 16:22:02','',NULL,''),
(2013,'用户聊天',2000,1,'chat','multhelp/chat/index',1,0,'C','0','0','multhelp:chat:list','#','admin','2021-05-26 16:22:06','',NULL,'用户聊天菜单'),
(2014,'用户聊天查询',2013,1,'#','',1,0,'F','0','0','multhelp:chat:query','#','admin','2021-05-26 16:22:06','',NULL,''),
(2015,'用户聊天新增',2013,2,'#','',1,0,'F','0','0','multhelp:chat:add','#','admin','2021-05-26 16:22:06','',NULL,''),
(2016,'用户聊天修改',2013,3,'#','',1,0,'F','0','0','multhelp:chat:edit','#','admin','2021-05-26 16:22:06','',NULL,''),
(2017,'用户聊天删除',2013,4,'#','',1,0,'F','0','0','multhelp:chat:remove','#','admin','2021-05-26 16:22:06','',NULL,''),
(2018,'用户聊天导出',2013,5,'#','',1,0,'F','0','0','multhelp:chat:export','#','admin','2021-05-26 16:22:06','',NULL,''),
(2019,'聊天内容',2000,1,'content','multhelp/content/index',1,0,'C','0','0','multhelp:content:list','#','admin','2021-05-26 16:22:10','',NULL,'聊天内容菜单'),
(2020,'聊天内容查询',2019,1,'#','',1,0,'F','0','0','multhelp:content:query','#','admin','2021-05-26 16:22:10','',NULL,''),
(2021,'聊天内容新增',2019,2,'#','',1,0,'F','0','0','multhelp:content:add','#','admin','2021-05-26 16:22:10','',NULL,''),
(2022,'聊天内容修改',2019,3,'#','',1,0,'F','0','0','multhelp:content:edit','#','admin','2021-05-26 16:22:10','',NULL,''),
(2023,'聊天内容删除',2019,4,'#','',1,0,'F','0','0','multhelp:content:remove','#','admin','2021-05-26 16:22:10','',NULL,''),
(2024,'聊天内容导出',2019,5,'#','',1,0,'F','0','0','multhelp:content:export','#','admin','2021-05-26 16:22:10','',NULL,''),
(2025,'登陆验证',2000,1,'login','multhelp/login/index',1,0,'C','0','0','multhelp:login:list','#','admin','2021-05-26 16:22:14','',NULL,'登陆验证菜单'),
(2026,'登陆验证查询',2025,1,'#','',1,0,'F','0','0','multhelp:login:query','#','admin','2021-05-26 16:22:14','',NULL,''),
(2027,'登陆验证新增',2025,2,'#','',1,0,'F','0','0','multhelp:login:add','#','admin','2021-05-26 16:22:14','',NULL,''),
(2028,'登陆验证修改',2025,3,'#','',1,0,'F','0','0','multhelp:login:edit','#','admin','2021-05-26 16:22:14','',NULL,''),
(2029,'登陆验证删除',2025,4,'#','',1,0,'F','0','0','multhelp:login:remove','#','admin','2021-05-26 16:22:14','',NULL,''),
(2030,'登陆验证导出',2025,5,'#','',1,0,'F','0','0','multhelp:login:export','#','admin','2021-05-26 16:22:14','',NULL,''),
(2031,'消息界面',2000,1,'message','multhelp/message/index',1,0,'C','0','0','multhelp:message:list','#','admin','2021-05-26 16:22:17','',NULL,'消息界面菜单'),
(2032,'消息界面查询',2031,1,'#','',1,0,'F','0','0','multhelp:message:query','#','admin','2021-05-26 16:22:17','',NULL,''),
(2033,'消息界面新增',2031,2,'#','',1,0,'F','0','0','multhelp:message:add','#','admin','2021-05-26 16:22:17','',NULL,''),
(2034,'消息界面修改',2031,3,'#','',1,0,'F','0','0','multhelp:message:edit','#','admin','2021-05-26 16:22:17','',NULL,''),
(2035,'消息界面删除',2031,4,'#','',1,0,'F','0','0','multhelp:message:remove','#','admin','2021-05-26 16:22:17','',NULL,''),
(2036,'消息界面导出',2031,5,'#','',1,0,'F','0','0','multhelp:message:export','#','admin','2021-05-26 16:22:17','',NULL,''),
(2037,'发布帮助',2000,1,'post','multhelp/post/index',1,0,'C','0','0','multhelp:post:list','#','admin','2021-05-26 16:22:21','',NULL,'发布帮助菜单'),
(2038,'发布帮助查询',2037,1,'#','',1,0,'F','0','0','multhelp:post:query','#','admin','2021-05-26 16:22:21','',NULL,''),
(2039,'发布帮助新增',2037,2,'#','',1,0,'F','0','0','multhelp:post:add','#','admin','2021-05-26 16:22:21','',NULL,''),
(2040,'发布帮助修改',2037,3,'#','',1,0,'F','0','0','multhelp:post:edit','#','admin','2021-05-26 16:22:21','',NULL,''),
(2041,'发布帮助删除',2037,4,'#','',1,0,'F','0','0','multhelp:post:remove','#','admin','2021-05-26 16:22:21','',NULL,''),
(2042,'发布帮助导出',2037,5,'#','',1,0,'F','0','0','multhelp:post:export','#','admin','2021-05-26 16:22:21','',NULL,'');

/*Table structure for table `sys_notice` */

DROP TABLE IF EXISTS `sys_notice`;

CREATE TABLE `sys_notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='通知公告表';

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`notice_id`,`notice_title`,`notice_type`,`notice_content`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'温馨提醒：2018-07-01 若依新版本发布啦','2','新版本内容','0','admin','2021-05-26 16:00:03','',NULL,'管理员'),
(2,'维护通知：2018-07-01 若依系统凌晨维护','1','维护内容','0','admin','2021-05-26 16:00:03','',NULL,'管理员');

/*Table structure for table `sys_oper_log` */

DROP TABLE IF EXISTS `sys_oper_log`;

CREATE TABLE `sys_oper_log` (
  `oper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '模块标题',
  `business_type` int DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '请求方式',
  `operator_type` int DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '返回参数',
  `status` int DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='操作日志记录';

/*Data for the table `sys_oper_log` */

insert  into `sys_oper_log`(`oper_id`,`title`,`business_type`,`method`,`request_method`,`operator_type`,`oper_name`,`dept_name`,`oper_url`,`oper_ip`,`oper_location`,`oper_param`,`json_result`,`status`,`error_msg`,`oper_time`) values 
(100,'代码生成',6,'com.ruoyi.generator.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/ry-miniapp/tool/gen/importTable','127.0.0.1','内网IP','multhelp_account,multhelp_chat,multhelp_chatandcontent,multhelp_login,multhelp_content,multhelp_message,multhelp_post','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:16:43'),
(101,'菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.add()','POST',1,'admin',NULL,'/ry-miniapp/system/menu','127.0.0.1','内网IP','{\"visible\":\"0\",\"icon\":\"people\",\"orderNum\":\"0\",\"menuName\":\"微信互助\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"multhelp\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:17:52'),
(102,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/ry-miniapp/tool/gen','127.0.0.1','内网IP','{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Openid\",\"usableColumn\":false,\"columnId\":1,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"openid\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"微信给的账户id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(128)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1622017003000,\"tableId\":1,\"pk\":true,\"columnName\":\"openid\"},{\"capJavaField\":\"Nickname\",\"usableColumn\":false,\"columnId\":2,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"nickname\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"昵称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":1,\"pk\":false,\"columnName\":\"nickname\"},{\"capJavaField\":\"Avatarurl\",\"usableColumn\":false,\"columnId\":3,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"avatarurl\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"头像地址\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":1,\"pk\":false,\"columnName\":\"avatarurl\"},{\"capJavaField\":\"Gender\",\"usableColumn\":false,\"columnId\":4,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"gender\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"性别\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"tinyint\",\"createBy\":\"admin\",\"isPk','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:18:41'),
(103,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/ry-miniapp/tool/gen','127.0.0.1','内网IP','{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Chatid\",\"usableColumn\":false,\"columnId\":9,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"chatid\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"聊天id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"bigint(20) unsigned zerofill\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1622017003000,\"tableId\":2,\"pk\":true,\"columnName\":\"chatid\"},{\"capJavaField\":\"InitiatorOpenid\",\"usableColumn\":false,\"columnId\":10,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"initiatorOpenid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"发起者\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(128)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":2,\"pk\":false,\"columnName\":\"initiator_openid\"},{\"capJavaField\":\"InviteeOpenid\",\"usableColumn\":false,\"columnId\":11,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"inviteeOpenid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"受邀者\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(128)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":2,\"pk\":false,\"columnName\":\"invitee_openid\"},{\"capJavaField\":\"CreateTime\",\"usableColumn\":false,\"columnId\":12,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":true,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createTime\",\"htmlType\":\"datetime\",\"edit\":false,\"query\":false,\"columnComment\":\"创建时间\",\"sort\":4,\"list\":false,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:20:05'),
(104,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/ry-miniapp/tool/gen','127.0.0.1','内网IP','{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Chatid\",\"usableColumn\":false,\"columnId\":13,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"chatid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"聊天id\",\"isQuery\":\"1\",\"sort\":1,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"bigint\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"chatid\"},{\"capJavaField\":\"Contentid\",\"usableColumn\":false,\"columnId\":14,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"contentid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"聊天内容id\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"bigint\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"contentid\"}],\"businessName\":\"chatandcontent\",\"moduleName\":\"system\",\"className\":\"MulthelpChatandcontent\",\"tableName\":\"multhelp_chatandcontent\",\"crud\":true,\"options\":\"{\\\"parentMenuId\\\":2000}\",\"genType\":\"0\",\"packageName\":\"com.ruoyi.system\",\"functionName\":\"cc\",\"tree\":false,\"tableComment\":\"c\",\"params\":{\"parentMenuId\":2000},\"tplCategory\":\"crud\",\"parentMenuId\":\"2000\",\"tableId\":3,\"genPath\":\"/\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:20:21'),
(105,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/ry-miniapp/tool/gen','127.0.0.1','内网IP','{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Contentid\",\"usableColumn\":false,\"columnId\":15,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"contentid\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"内容id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"bigint(20) unsigned zerofill\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1622017003000,\"tableId\":4,\"pk\":true,\"columnName\":\"contentid\"},{\"capJavaField\":\"SendOpenid\",\"usableColumn\":false,\"columnId\":16,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"sendOpenid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"发送者id\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(128)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":4,\"pk\":false,\"columnName\":\"send_openid\"},{\"capJavaField\":\"ReceiveOpenid\",\"usableColumn\":false,\"columnId\":17,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"receiveOpenid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"接收者id\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(128)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":4,\"pk\":false,\"columnName\":\"receive_openid\"},{\"capJavaField\":\"Sender\",\"usableColumn\":false,\"columnId\":18,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"sender\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"发送人\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\"','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:20:31'),
(106,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/ry-miniapp/tool/gen','127.0.0.1','内网IP','{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Session3rd\",\"usableColumn\":false,\"columnId\":22,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"session3rd\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"服务器给的临时验证\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1622017003000,\"tableId\":5,\"pk\":true,\"columnName\":\"session_3rd\"},{\"capJavaField\":\"Openid\",\"usableColumn\":false,\"columnId\":23,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"openid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"微信给的id\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":5,\"pk\":false,\"columnName\":\"openid\"},{\"capJavaField\":\"SessionKey\",\"usableColumn\":false,\"columnId\":24,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"sessionKey\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"微信给的会话key\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":5,\"pk\":false,\"columnName\":\"session_key\"},{\"capJavaField\":\"CreateTime\",\"usableColumn\":false,\"columnId\":25,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":true,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createTime\",\"htmlType\":\"datetime\",\"edit\":false,\"query\":false,\"columnComment\":\"创建时间\",\"sort\":4,\"list\":false,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"timestamp\",\"createBy\"','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:20:43'),
(107,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/ry-miniapp/tool/gen','127.0.0.1','内网IP','{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Chatid\",\"usableColumn\":false,\"columnId\":26,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"chatid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"聊天id\",\"isQuery\":\"1\",\"sort\":1,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"bigint\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"chatid\"},{\"capJavaField\":\"LastContentid\",\"usableColumn\":false,\"columnId\":27,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"lastContentid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"最近的聊天内容id\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"bigint\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"last_contentid\"}],\"businessName\":\"message\",\"moduleName\":\"system\",\"className\":\"MulthelpMessage\",\"tableName\":\"multhelp_message\",\"crud\":true,\"options\":\"{\\\"parentMenuId\\\":2000}\",\"genType\":\"0\",\"packageName\":\"com.ruoyi.system\",\"functionName\":\"c\",\"tree\":false,\"tableComment\":\"c\",\"params\":{\"parentMenuId\":2000},\"tplCategory\":\"crud\",\"parentMenuId\":\"2000\",\"tableId\":6,\"genPath\":\"/\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:20:52'),
(108,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/ry-miniapp/tool/gen','127.0.0.1','内网IP','{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Postid\",\"usableColumn\":false,\"columnId\":28,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"postid\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"发布帮助id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Integer\",\"queryType\":\"EQ\",\"columnType\":\"bigint(10) unsigned zerofill\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1622017003000,\"tableId\":7,\"pk\":true,\"columnName\":\"postid\"},{\"capJavaField\":\"PublishOpenid\",\"usableColumn\":false,\"columnId\":29,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"publishOpenid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"发布人id\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":7,\"pk\":false,\"columnName\":\"publish_openid\"},{\"capJavaField\":\"ReceiveOpenid\",\"usableColumn\":false,\"columnId\":30,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"receiveOpenid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"帮助人id\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1622017003000,\"isEdit\":\"1\",\"tableId\":7,\"pk\":false,\"columnName\":\"receive_openid\"},{\"capJavaField\":\"Tittle\",\"usableColumn\":false,\"columnId\":31,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"tittle\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"标题\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-26 16:21:03'),
(109,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/ry-miniapp/tool/gen/batchGenCode','127.0.0.1','内网IP','{}','null',0,NULL,'2021-05-26 16:21:06');

/*Table structure for table `sys_post` */

DROP TABLE IF EXISTS `sys_post`;

CREATE TABLE `sys_post` (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int NOT NULL COMMENT '显示顺序',
  `status` char(1) COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='岗位信息表';

/*Data for the table `sys_post` */

insert  into `sys_post`(`post_id`,`post_code`,`post_name`,`post_sort`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'ceo','董事长',1,'0','admin','2021-05-26 16:00:03','',NULL,''),
(2,'se','项目经理',2,'0','admin','2021-05-26 16:00:03','',NULL,''),
(3,'hr','人力资源',3,'0','admin','2021-05-26 16:00:03','',NULL,''),
(4,'user','普通员工',4,'0','admin','2021-05-26 16:00:03','',NULL,'');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status` char(1) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色信息表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_key`,`role_sort`,`data_scope`,`menu_check_strictly`,`dept_check_strictly`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'超级管理员','admin',1,'1',1,1,'0','0','admin','2021-05-26 16:00:03','',NULL,'超级管理员'),
(2,'普通角色','common',2,'2',1,1,'0','0','admin','2021-05-26 16:00:03','',NULL,'普通角色');

/*Table structure for table `sys_role_dept` */

DROP TABLE IF EXISTS `sys_role_dept`;

CREATE TABLE `sys_role_dept` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `dept_id` bigint NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色和部门关联表';

/*Data for the table `sys_role_dept` */

insert  into `sys_role_dept`(`role_id`,`dept_id`) values 
(2,100),
(2,101),
(2,105);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色和菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values 
(2,1),
(2,2),
(2,3),
(2,4),
(2,100),
(2,101),
(2,102),
(2,103),
(2,104),
(2,105),
(2,106),
(2,107),
(2,108),
(2,109),
(2,110),
(2,111),
(2,112),
(2,113),
(2,114),
(2,115),
(2,116),
(2,500),
(2,501),
(2,1000),
(2,1001),
(2,1002),
(2,1003),
(2,1004),
(2,1005),
(2,1006),
(2,1007),
(2,1008),
(2,1009),
(2,1010),
(2,1011),
(2,1012),
(2,1013),
(2,1014),
(2,1015),
(2,1016),
(2,1017),
(2,1018),
(2,1019),
(2,1020),
(2,1021),
(2,1022),
(2,1023),
(2,1024),
(2,1025),
(2,1026),
(2,1027),
(2,1028),
(2,1029),
(2,1030),
(2,1031),
(2,1032),
(2,1033),
(2,1034),
(2,1035),
(2,1036),
(2,1037),
(2,1038),
(2,1039),
(2,1040),
(2,1041),
(2,1042),
(2,1043),
(2,1044),
(2,1045),
(2,1046),
(2,1047),
(2,1048),
(2,1049),
(2,1050),
(2,1051),
(2,1052),
(2,1053),
(2,1054),
(2,1055),
(2,1056),
(2,1057),
(2,1058),
(2,1059),
(2,1060);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) COLLATE utf8mb4_general_ci DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '手机号码',
  `sex` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '密码',
  `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`dept_id`,`user_name`,`nick_name`,`user_type`,`email`,`phonenumber`,`sex`,`avatar`,`password`,`status`,`del_flag`,`login_ip`,`login_date`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,103,'admin','若依','00','ry@163.com','15888888888','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2021-05-26 16:00:03','admin','2021-05-26 16:00:03','',NULL,'管理员'),
(2,105,'ry','若依','00','ry@qq.com','15666666666','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2021-05-26 16:00:03','admin','2021-05-26 16:00:03','',NULL,'测试员');

/*Table structure for table `sys_user_post` */

DROP TABLE IF EXISTS `sys_user_post`;

CREATE TABLE `sys_user_post` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户与岗位关联表';

/*Data for the table `sys_user_post` */

insert  into `sys_user_post`(`user_id`,`post_id`) values 
(1,1),
(2,2);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户和角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values 
(1,1),
(2,2);

/*!50106 set global event_scheduler = 1*/;

/* Event structure for event `e_multhelp_delete_login` */

/*!50106 DROP EVENT IF EXISTS `e_multhelp_delete_login`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`iwan`@`%` EVENT `e_multhelp_delete_login` ON SCHEDULE EVERY 5 SECOND STARTS '2021-05-22 16:59:17' ON COMPLETION NOT PRESERVE ENABLE DO delete from `multhelp_login` where `create_time`<(CURRENT_TIMESTAMP() + INTERVAL -60 MINUTE) */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
