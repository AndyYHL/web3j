/*
Navicat MySQL Data Transfer

Source Server         : 192.168.31.41_3306
Source Server Version : 50712
Source Host           : 192.168.31.41:3306
Source Database       : trafficdata

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2018-03-13 11:25:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agreement
-- ----------------------------
DROP TABLE IF EXISTS `agreement`;
CREATE TABLE `agreement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `vehicle_platenumber` varchar(20) DEFAULT '  ' COMMENT '车牌号',
  `usingnature` varchar(20) DEFAULT '  ' COMMENT '使用性质',
  `species` varchar(50) DEFAULT '  ' COMMENT '号牌种类',
  `type_de` varchar(20) DEFAULT '      ' COMMENT '车辆类型说明',
  `type` int(11) DEFAULT '1' COMMENT '车辆类型',
  `reservdefield1` varchar(50) DEFAULT '     ' COMMENT '预留字段1',
  `reservdefield2` int(11) DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) DEFAULT '1' COMMENT '是否删除',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `agreementype` int(11) DEFAULT '1' COMMENT '协议类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agreement
-- ----------------------------
INSERT INTO `agreement` VALUES ('1', '川A00002', null, '小型汽车', null, null, '     ', '1', '1', '2018-03-13 10:07:36', '2018-03-13 10:07:36', '2');
INSERT INTO `agreement` VALUES ('2', '川A00002', null, '小型汽车', null, null, '     ', '1', '1', '2018-03-13 10:11:38', '2018-03-13 10:11:38', '2');
INSERT INTO `agreement` VALUES ('3', '川A00002', null, '小型汽车', null, null, '     ', '1', '1', '2018-03-13 10:14:06', '2018-03-13 10:14:06', '2');
INSERT INTO `agreement` VALUES ('4', '川A00001', null, '大型汽车', null, null, '     ', '1', '1', '2018-03-13 10:14:12', '2018-03-13 10:14:12', '1');
INSERT INTO `agreement` VALUES ('5', '川A88888', null, '小型汽车', null, null, '     ', '1', '1', '2018-03-13 10:24:28', '2018-03-13 10:24:28', '2');
INSERT INTO `agreement` VALUES ('6', '川A88887', null, '大型客车', null, null, '     ', '1', '1', '2018-03-13 10:24:28', '2018-03-13 10:24:28', '2');
INSERT INTO `agreement` VALUES ('7', '川A88889', null, '运渣车', null, null, '     ', '1', '1', '2018-03-13 10:24:28', '2018-03-13 10:24:28', '1');

-- ----------------------------
-- Table structure for datacalculation_result
-- ----------------------------
DROP TABLE IF EXISTS `datacalculation_result`;
CREATE TABLE `datacalculation_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datacalculation_id` int(11) DEFAULT NULL,
  `startime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `stoptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` int(11) DEFAULT NULL,
  `origin` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `flow` varchar(20) DEFAULT NULL,
  `resultype` varchar(20) DEFAULT NULL,
  `datacalculation_rule_id` int(11) DEFAULT NULL,
  `date_task_id` varchar(50) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datacalculation_result
-- ----------------------------
INSERT INTO `datacalculation_result` VALUES ('1', '1', '2018-03-09 17:08:21', '2018-03-09 17:08:21', null, null, null, null, null, null, null, '2018-03-09 17:08:21', '2018-03-09 17:08:21', ' ', '1', '1');
INSERT INTO `datacalculation_result` VALUES ('2', '2', '2018-03-09 17:08:21', '2018-03-09 17:08:21', null, null, null, null, null, null, null, '2018-03-09 17:08:21', '2018-03-09 17:08:21', ' ', '1', '1');
INSERT INTO `datacalculation_result` VALUES ('3', '3', '2018-03-09 17:08:22', '2018-03-09 17:08:22', null, null, null, null, null, null, null, '2018-03-09 17:08:22', '2018-03-09 17:08:22', ' ', '1', '1');
INSERT INTO `datacalculation_result` VALUES ('4', '4', '2018-03-09 17:08:22', '2018-03-09 17:08:22', null, null, null, null, null, null, null, '2018-03-09 17:08:22', '2018-03-09 17:08:22', ' ', '1', '1');
INSERT INTO `datacalculation_result` VALUES ('5', '5', '2018-03-09 17:08:22', '2018-03-09 17:08:22', null, null, null, null, null, null, null, '2018-03-09 17:08:22', '2018-03-09 17:08:22', ' ', '1', '1');
INSERT INTO `datacalculation_result` VALUES ('6', '6', '2018-03-09 17:08:22', '2018-03-09 17:08:22', null, null, null, null, null, null, null, '2018-03-09 17:08:22', '2018-03-09 17:08:22', ' ', '1', '1');

-- ----------------------------
-- Table structure for datacalculation_rule
-- ----------------------------
DROP TABLE IF EXISTS `datacalculation_rule`;
CREATE TABLE `datacalculation_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT ' ',
  `process` varchar(100) NOT NULL DEFAULT ' ',
  `resultable` varchar(20) NOT NULL DEFAULT ' ',
  `describe1` varchar(100) NOT NULL DEFAULT ' ',
  `type` varchar(50) NOT NULL DEFAULT ' ',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datacalculation_rule
-- ----------------------------
INSERT INTO `datacalculation_rule` VALUES ('1', '1', ' 1', ' 1', ' 1', ' 1', '2018-03-08 11:15:13', '2018-03-08 11:15:13', ' ', '1', '1');
INSERT INTO `datacalculation_rule` VALUES ('4', '0', '1', '1', '1', '1', '2018-03-08 11:15:13', '2018-03-08 11:15:13', '', '1', '1');
INSERT INTO `datacalculation_rule` VALUES ('6', '2', '1', '1', '1', '1', '2018-03-08 11:15:13', '2018-03-08 11:15:13', '', '1', '1');
INSERT INTO `datacalculation_rule` VALUES ('7', '2', '1', '1', '1', '1', '2018-03-08 11:15:13', '2018-03-08 11:15:13', '', '1', '1');
INSERT INTO `datacalculation_rule` VALUES ('8', '2', '1', '1', '1', '1', '2018-03-08 11:15:13', '2018-03-08 11:15:13', '', '1', '1');

-- ----------------------------
-- Table structure for datacalculation_rule_parameter
-- ----------------------------
DROP TABLE IF EXISTS `datacalculation_rule_parameter`;
CREATE TABLE `datacalculation_rule_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `paratype` varchar(20) DEFAULT NULL,
  `paravalue` varchar(50) DEFAULT NULL,
  `datacalculation_rule_name` varchar(20) NOT NULL,
  `datacalculation_rule_id` int(11) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datacalculation_rule_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for datacalculation_task
-- ----------------------------
DROP TABLE IF EXISTS `datacalculation_task`;
CREATE TABLE `datacalculation_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `rule` varchar(20) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` smallint(6) NOT NULL DEFAULT '0',
  `datacalculation_rule_id` int(11) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datacalculation_task
-- ----------------------------
INSERT INTO `datacalculation_task` VALUES ('1', '1', '1', '2018-03-09 11:10:14', '0', null, '2018-03-09 11:10:14', '2018-03-09 11:10:14', ' ', '1', '1');

-- ----------------------------
-- Table structure for datacalculation_task_parameter
-- ----------------------------
DROP TABLE IF EXISTS `datacalculation_task_parameter`;
CREATE TABLE `datacalculation_task_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datacalculation_task_id` int(11) DEFAULT NULL,
  `datacalculation_rule_id` int(11) DEFAULT NULL,
  `datacalculation_rule_parameter_name` varchar(50) DEFAULT NULL,
  `datacalculation_rule_parameter_paratype` varchar(20) DEFAULT NULL,
  `datacalculation_rule_parameter_paravalue` varchar(50) DEFAULT NULL,
  `datacalculation_rule_parameter_id` int(11) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datacalculation_task_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for data_backup
-- ----------------------------
DROP TABLE IF EXISTS `data_backup`;
CREATE TABLE `data_backup` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) NOT NULL DEFAULT ' ' COMMENT '任务名称',
  `path` varchar(50) NOT NULL DEFAULT ' ' COMMENT '备份路径',
  `tablename` varchar(30) NOT NULL DEFAULT ' ' COMMENT '备份表名',
  `backuptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '备份时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_backup
-- ----------------------------

-- ----------------------------
-- Table structure for data_certificate_information
-- ----------------------------
DROP TABLE IF EXISTS `data_certificate_information`;
CREATE TABLE `data_certificate_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file` varchar(100) DEFAULT NULL,
  `hostname` varchar(100) DEFAULT NULL,
  `othername` varchar(100) DEFAULT NULL,
  `effectivestartime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `effectivestoptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` varchar(20) DEFAULT NULL,
  `signaturealgorithm` varchar(20) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_certificate_information
-- ----------------------------

-- ----------------------------
-- Table structure for data_pushservice
-- ----------------------------
DROP TABLE IF EXISTS `data_pushservice`;
CREATE TABLE `data_pushservice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `sysname` varchar(20) DEFAULT NULL,
  `certificatename` varchar(20) DEFAULT NULL,
  `effectivestartime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `effectivestoptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `connectionstatus` smallint(6) DEFAULT NULL,
  `subscribername` varchar(20) DEFAULT NULL,
  `currentstate` smallint(6) DEFAULT NULL,
  `certificateinformation_id` int(11) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_pushservice
-- ----------------------------

-- ----------------------------
-- Table structure for data_select_across
-- ----------------------------
DROP TABLE IF EXISTS `data_select_across`;
CREATE TABLE `data_select_across` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `status` smallint(6) DEFAULT '1',
  `effectivestartime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `effectivestoptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_select_across
-- ----------------------------
INSERT INTO `data_select_across` VALUES ('1', '编码0001', '张1', '1', '2018-03-09 17:01:41', '2018-03-09 17:01:41', '2018-03-09 17:01:41', '2018-03-09 17:01:41', ' ', '1', '1');
INSERT INTO `data_select_across` VALUES ('2', '编码0002', '张2', '1', '2018-03-09 17:01:41', '2018-03-09 17:01:41', '2018-03-09 17:01:41', '2018-03-09 17:01:41', ' ', '1', '1');
INSERT INTO `data_select_across` VALUES ('3', '编码0003', '张3', '1', '2018-03-09 17:01:42', '2018-03-09 17:01:42', '2018-03-09 17:01:42', '2018-03-09 17:01:42', ' ', '1', '1');
INSERT INTO `data_select_across` VALUES ('4', '编码0004', '张4', '1', '2018-03-09 17:01:42', '2018-03-09 17:01:42', '2018-03-09 17:01:42', '2018-03-09 17:01:42', ' ', '1', '1');
INSERT INTO `data_select_across` VALUES ('5', '编码0005', '张5', '1', '2018-03-09 17:01:42', '2018-03-09 17:01:42', '2018-03-09 17:01:42', '2018-03-09 17:01:42', ' ', '1', '1');
INSERT INTO `data_select_across` VALUES ('6', '编码0006', '张6', '1', '2018-03-09 17:01:43', '2018-03-09 17:01:43', '2018-03-09 17:01:43', '2018-03-09 17:01:43', ' ', '1', '1');
INSERT INTO `data_select_across` VALUES ('7', '编码0007', '张7', '1', '2018-03-09 17:01:44', '2018-03-09 17:01:44', '2018-03-09 17:01:44', '2018-03-09 17:01:44', ' ', '1', '1');

-- ----------------------------
-- Table structure for data_select_result
-- ----------------------------
DROP TABLE IF EXISTS `data_select_result`;
CREATE TABLE `data_select_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resultpermissions` varchar(50) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_select_result
-- ----------------------------
INSERT INTO `data_select_result` VALUES ('1', '权限A', '张1', '2018-03-09 17:00:39', '2018-03-09 17:00:39', ' ', '1', '1');
INSERT INTO `data_select_result` VALUES ('2', '权限B', '张2', '2018-03-09 17:00:39', '2018-03-09 17:00:39', ' ', '1', '1');
INSERT INTO `data_select_result` VALUES ('3', '权限C', '张3', '2018-03-09 17:00:39', '2018-03-09 17:00:39', ' ', '1', '1');
INSERT INTO `data_select_result` VALUES ('4', '权限D', '张4', '2018-03-09 17:00:39', '2018-03-09 17:00:39', ' ', '1', '1');
INSERT INTO `data_select_result` VALUES ('5', '权限E', '张5', '2018-03-09 17:00:40', '2018-03-09 17:00:40', ' ', '1', '1');
INSERT INTO `data_select_result` VALUES ('6', '权限F', '张6', '2018-03-09 17:00:40', '2018-03-09 17:00:40', ' ', '1', '1');

-- ----------------------------
-- Table structure for data_select_statistics
-- ----------------------------
DROP TABLE IF EXISTS `data_select_statistics`;
CREATE TABLE `data_select_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `effectivestartime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `effectivestoptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_select_statistics
-- ----------------------------
INSERT INTO `data_select_statistics` VALUES ('1', '张1', '2018-03-09 16:58:26', '2018-03-09 16:58:26', '2018-03-09 16:58:26', '2018-03-09 16:58:26', ' ', '1', '1');
INSERT INTO `data_select_statistics` VALUES ('2', '张2', '2018-03-09 16:58:26', '2018-03-09 16:58:26', '2018-03-09 16:58:26', '2018-03-09 16:58:26', ' ', '1', '1');
INSERT INTO `data_select_statistics` VALUES ('3', '张3', '2018-03-09 16:58:26', '2018-03-09 16:58:26', '2018-03-09 16:58:26', '2018-03-09 16:58:26', ' ', '1', '1');
INSERT INTO `data_select_statistics` VALUES ('4', '张4', '2018-03-09 16:58:27', '2018-03-09 16:58:27', '2018-03-09 16:58:27', '2018-03-09 16:58:27', ' ', '1', '1');
INSERT INTO `data_select_statistics` VALUES ('5', '张5', '2018-03-09 16:58:27', '2018-03-09 16:58:27', '2018-03-09 16:58:27', '2018-03-09 16:58:27', ' ', '1', '1');
INSERT INTO `data_select_statistics` VALUES ('6', '张6', '2018-03-09 16:58:27', '2018-03-09 16:58:27', '2018-03-09 16:58:27', '2018-03-09 16:58:27', ' ', '1', '1');

-- ----------------------------
-- Table structure for rfid
-- ----------------------------
DROP TABLE IF EXISTS `rfid`;
CREATE TABLE `rfid` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL DEFAULT '   ' COMMENT '断面名称',
  `rfid_number` varchar(50) NOT NULL DEFAULT ' ' COMMENT '编号',
  `address` varchar(50) NOT NULL DEFAULT ' ' COMMENT '位置',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '设备状态',
  `lng` varchar(20) NOT NULL DEFAULT ' ' COMMENT '经度',
  `lat` varchar(20) NOT NULL DEFAULT ' ' COMMENT '纬度',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT ' ' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rfid
-- ----------------------------
INSERT INTO `rfid` VALUES ('1', '断面1', '编号ASD001', '百草路1号', '1', '100.001', '30.245', '2018-03-09 17:03:46', '2018-03-09 17:03:46', ' ', '1', '1');
INSERT INTO `rfid` VALUES ('2', '断面2', '编号ASD002', '百草路2号', '1', '100.020', '30.300', '2018-03-09 17:03:46', '2018-03-09 17:03:46', ' ', '1', '1');
INSERT INTO `rfid` VALUES ('3', '断面3', '编号ASD003', '百草路3号', '1', '100.052', '30.445', '2018-03-09 17:03:46', '2018-03-09 17:03:46', ' ', '1', '1');
INSERT INTO `rfid` VALUES ('4', '断面4', '编号ASD004', '百草路4号', '1', '100.073', '30.577', '2018-03-09 17:03:47', '2018-03-09 17:03:47', ' ', '1', '1');
INSERT INTO `rfid` VALUES ('5', '断面5', '编号ASD005', '百草路5号', '1', '100.046', '30.666', '2018-03-09 17:03:47', '2018-03-09 17:03:47', ' ', '1', '1');
INSERT INTO `rfid` VALUES ('6', '断面6', '编号ASD006', '百草路6号', '1', '100.077', '30.886', '2018-03-09 17:03:47', '2018-03-09 17:03:47', ' ', '1', '1');
INSERT INTO `rfid` VALUES ('7', '断面7', '编号ASD007', '百草路7号', '1', '100.022', '30.789', '2018-03-09 17:03:49', '2018-03-09 17:03:49', ' ', '1', '1');

-- ----------------------------
-- Table structure for sourcemanage
-- ----------------------------
DROP TABLE IF EXISTS `sourcemanage`;
CREATE TABLE `sourcemanage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(20) NOT NULL DEFAULT '' COMMENT '信源编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '信源名称',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '信源类型',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT '' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  `instructions` varchar(200) NOT NULL DEFAULT '' COMMENT '说明',
  `status_de` varchar(50) NOT NULL DEFAULT '' COMMENT '状态说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sourcemanage
-- ----------------------------
INSERT INTO `sourcemanage` VALUES ('1', '编号001', '名称1', '类型1', '1', '2018-03-09 16:56:40', '2018-03-09 16:56:40', '', '1', '1', '', '');
INSERT INTO `sourcemanage` VALUES ('2', '编号003', '名称2', '类型2', '1', '2018-03-09 16:56:41', '2018-03-09 16:56:41', '', '1', '1', '', '');
INSERT INTO `sourcemanage` VALUES ('3', '编号001', '名称3', '类型3', '1', '2018-03-09 16:56:42', '2018-03-09 16:56:42', '', '1', '1', '', '');
INSERT INTO `sourcemanage` VALUES ('4', '编号002', '名称4', '类型4', '1', '2018-03-09 16:56:42', '2018-03-09 16:56:42', '', '1', '1', '', '');
INSERT INTO `sourcemanage` VALUES ('5', '编号001', '名称5', '类型5', '1', '2018-03-09 16:56:42', '2018-03-09 16:56:42', '', '1', '1', '', '');
INSERT INTO `sourcemanage` VALUES ('6', '编号002', '名称6', '类型6', '1', '2018-03-09 16:56:42', '2018-03-09 16:56:42', '', '1', '1', '', '');
INSERT INTO `sourcemanage` VALUES ('7', '编号001', '名称7', '类型7', '1', '2018-03-09 16:56:43', '2018-03-09 16:56:43', '', '1', '1', '', '');

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '设置参数名称',
  `value` varchar(50) NOT NULL DEFAULT '' COMMENT '参数值',
  `model` varchar(50) NOT NULL DEFAULT '' COMMENT '所属模块',
  `describe1` varchar(50) NOT NULL DEFAULT '' COMMENT '描述',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT '' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_setting
-- ----------------------------
INSERT INTO `sys_setting` VALUES ('1', '参数名称1', '参数值1', '所属模块1', '这是描述', '2018-03-09 16:52:13', '2018-03-09 16:52:16', '', '1', '1');
INSERT INTO `sys_setting` VALUES ('2', '参数名称2', '参数值2', '所属模块2', '这是描述', '2018-03-09 16:54:11', '2018-03-09 16:54:14', '', '1', '1');
INSERT INTO `sys_setting` VALUES ('3', '参数名称3', '参数值3', '所属模块1', '这是描述', '2018-03-09 16:54:32', '2018-03-09 16:54:32', '', '1', '1');
INSERT INTO `sys_setting` VALUES ('4', '参数名称4', '参数值4', '所属模块3', '这是描述', '2018-03-09 16:54:36', '2018-03-09 16:54:36', '', '1', '1');
INSERT INTO `sys_setting` VALUES ('5', '参数名称5', '参数值5', '所属模块1', '这是描述', '2018-03-09 16:54:41', '2018-03-09 16:54:41', '', '1', '1');
INSERT INTO `sys_setting` VALUES ('6', '参数名称6', '参数值6', '所属模块2', '这是描述', '2018-03-09 16:54:45', '2018-03-09 16:54:45', '', '1', '1');
INSERT INTO `sys_setting` VALUES ('7', '参数名称7', '参数值7', '所属模块1', '这是描述', '2018-03-09 16:54:48', '2018-03-09 16:54:48', '', '1', '1');

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `vehicle_platenumber` varchar(15) NOT NULL DEFAULT '' COMMENT '车牌号',
  `model` int(11) NOT NULL DEFAULT '1' COMMENT '车辆型号',
  `model_de` varchar(50) NOT NULL DEFAULT '' COMMENT '车辆型号说明',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '车辆状态',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT '' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '车辆类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', '川A00001', '1', '长安X70A', '1', '2018-03-09 16:50:45', '2018-03-09 16:50:45', '', '1', '1', '小汽车');
INSERT INTO `vehicle` VALUES ('2', '川A00002', '1', '比亚迪F3', '1', '2018-03-09 16:50:58', '2018-03-09 16:50:58', '', '1', '1', '小汽车');
INSERT INTO `vehicle` VALUES ('3', '川A00003', '1', '宝骏310', '1', '2018-03-09 16:51:12', '2018-03-09 16:51:12', '', '1', '1', '小汽车');
INSERT INTO `vehicle` VALUES ('4', '川A00004', '1', '五菱宏光S', '1', '2018-03-09 16:51:19', '2018-03-09 16:51:19', '', '1', '1', '小汽车');
INSERT INTO `vehicle` VALUES ('5', '川A00005', '1', '瑞虎3x', '1', '2018-03-09 16:51:23', '2018-03-09 16:51:23', '', '1', '1', '大货车');
INSERT INTO `vehicle` VALUES ('6', '川A00006', '1', 'WEY VV7', '1', '2018-03-09 16:51:32', '2018-03-09 16:51:32', '', '1', '1', '客车');

-- ----------------------------
-- Table structure for vehicle_rfid
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_rfid`;
CREATE TABLE `vehicle_rfid` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rfid_id` int(11) NOT NULL COMMENT '主键',
  `vehicle_id` int(11) NOT NULL COMMENT '主键',
  `vehicle_platenumber` varchar(20) NOT NULL DEFAULT '' COMMENT '车牌号',
  `rfid_number` varchar(20) NOT NULL DEFAULT '' COMMENT 'RFID编号',
  `startime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `stoptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  `reservdefield1` varchar(50) NOT NULL DEFAULT '' COMMENT '预留字段1',
  `reservdefield2` int(11) NOT NULL DEFAULT '1' COMMENT '预留字段2',
  `isdelete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除',
  `way_de` varchar(50) DEFAULT '' COMMENT '查询方式',
  `way` int(11) DEFAULT '1' COMMENT '查询方式',
  `bythetime` int(11) DEFAULT '1' COMMENT '通过时间',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle_rfid
-- ----------------------------
INSERT INTO `vehicle_rfid` VALUES ('1', '1', '1', '川A00001', ' 000000001', '2018-03-13 10:56:21', '2018-03-13 10:58:20', ' ', '1', '1', '', '1', '1', '2018-03-09 16:46:32', '2018-03-09 16:46:35');
INSERT INTO `vehicle_rfid` VALUES ('2', '2', '2', '川A00002', ' 000000002', '2018-03-13 10:56:25', '2018-03-13 10:58:27', ' ', '1', '1', '', '1', '1', '2018-03-09 16:47:05', '2018-03-09 16:47:05');
INSERT INTO `vehicle_rfid` VALUES ('3', '3', '3', '川A00003', ' 000000003', '2018-03-13 10:56:27', '2018-03-13 10:58:32', ' ', '1', '1', '', '1', '1', '2018-03-09 16:47:33', '2018-03-09 16:47:33');
INSERT INTO `vehicle_rfid` VALUES ('4', '4', '4', '川A00004', ' 000000004', '2018-03-13 10:56:34', '2018-03-13 10:58:35', ' ', '1', '1', '', '1', '1', '2018-03-09 16:48:02', '2018-03-09 16:48:02');
INSERT INTO `vehicle_rfid` VALUES ('5', '5', '5', '川A00005', ' 000000004', '2018-03-13 10:56:38', '2018-03-13 10:58:38', ' ', '1', '1', '', '1', '1', '2018-03-09 16:48:31', '2018-03-09 16:48:31');
INSERT INTO `vehicle_rfid` VALUES ('6', '6', '6', '川A00006', '  000000004', '2018-03-13 10:59:20', '2018-03-13 10:59:38', ' ', '1', '1', '', '1', '1', '2018-03-09 16:49:34', '2018-03-09 16:49:34');
INSERT INTO `vehicle_rfid` VALUES ('7', '7', '6', '川A00006', '  000000004', '2018-03-13 10:59:24', '2018-03-13 10:59:38', ' ', '1', '1', '', '1', '1', '2018-03-09 16:49:41', '2018-03-09 16:49:41');
