/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : sports

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-28 20:10:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `aca_id` int(11) DEFAULT NULL,
  `aca_name` varchar(255) DEFAULT NULL,
  `aca_grade` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `admin_login` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'superadmin', 'superadmin', '2017-11-27 16:32:52', '0');

-- ----------------------------
-- Table structure for athlete
-- ----------------------------
DROP TABLE IF EXISTS `athlete`;
CREATE TABLE `athlete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ath_id` char(4) DEFAULT NULL,
  `credit_id` varchar(12) DEFAULT NULL,
  `group_id` char(2) DEFAULT NULL,
  `ath_name` varchar(255) DEFAULT NULL,
  `ath_sex` varchar(255) DEFAULT NULL,
  `ath_age` varchar(255) DEFAULT NULL,
  `ath_type` varchar(255) DEFAULT NULL,
  `ath_status` varchar(255) DEFAULT NULL,
  `11111_grade` double(255,2) DEFAULT NULL,
  `11111_point` int(1) DEFAULT NULL,
  `11111_rank` int(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `school_id` (`credit_id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of athlete
-- ----------------------------
INSERT INTO `athlete` VALUES ('1', '0550', '201706010105', '05', '杨蒙', '女', null, '大学生组', null, '23.00', '9', '1', null);
INSERT INTO `athlete` VALUES ('7', '0551', '201706010201', '05', '常澳华', '女', null, '大学生组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('3', '0800', '201706010108', '08', '陈鑫', '男', null, '大学生组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('4', '0801', '201706010120', '08', '蒲瑞龙', '男', null, '大学生组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('31', '2320', '201706010223', '23', '危星', '男', null, '中年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('29', '2100', '201706010221', '21', '王振博', '男', null, '青年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('27', '0552', '201706010213', '05', '李程', '女', null, '大学生组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('30', '2101', '201706010311', '21', '范朋凯', '男', null, '青年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('32', '2321', '201706010313', '23', '贾延伟', '男', null, '中年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('33', '2950', '201706010319', '29', '文涛', '女', null, '青年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('34', '2951', '201706010301', '29', '陈璨', '女', null, '青年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('35', '3070', '201706010302', '30', '姜唯佳', '女', null, '中年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('36', '3071', '201706010320', '30', '燕康康', '女', null, '中年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('52', '2640', '201706010226', '26', '杨晓凯', '男', null, '老年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('53', '2720', '201706010227', '27', '尹康', '男', null, '中年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('39', '0200', '201706010114', '02', '何纪航', '男', null, '大学生组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('40', '0400', '201706010116', '04', '梁晨', '男', null, '大学生组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('43', '2650', '201706010406', '26', '杨凡', '女', null, '青年教工组', null, null, null, null, null);
INSERT INTO `athlete` VALUES ('44', '2770', '201706010407', '27', '张倩', '女', null, '中年教工组', null, null, null, null, null);

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `group_id` char(2) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `group_leader` varchar(255) DEFAULT NULL,
  `group_coach_1` varchar(255) DEFAULT NULL,
  `group_staff_1` varchar(255) DEFAULT NULL,
  `group_point` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('1', '01', null, '陈李斌', '卢绍勋', '乔宇', null);
INSERT INTO `group` VALUES ('2', '21', null, '陈李斌', '陈李斌', '王雪青', null);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `item_id` char(5) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_type` varchar(255) DEFAULT NULL,
  `item_grade_format` varchar(255) DEFAULT NULL,
  `item_rank_rule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '11112', '大学生组女子100米', '大学生组|个人|女子|径赛|100米', 's', '小');
INSERT INTO `item` VALUES ('2', '21214', '教工青年组女子铅球', '教工青年组|个人|女子|田赛|铅球', 'm', '大');

-- ----------------------------
-- Table structure for item_basic
-- ----------------------------
DROP TABLE IF EXISTS `item_basic`;
CREATE TABLE `item_basic` (
  `id` int(11) NOT NULL,
  `item_type` varchar(255) DEFAULT NULL,
  `item_value_1` varchar(255) DEFAULT NULL,
  `item_value_2` varchar(255) DEFAULT NULL,
  `item_value_3` varchar(255) DEFAULT NULL,
  `item_value_4` varchar(255) DEFAULT NULL,
  `item_value_5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_basic
-- ----------------------------
INSERT INTO `item_basic` VALUES ('1', '参赛身份', '大学生组', '教工青年组', '教工中年组', '教工老年组', null);
INSERT INTO `item_basic` VALUES ('2', '参赛形式', '个人', '团体', null, null, null);
INSERT INTO `item_basic` VALUES ('3', '性别', '男子', '女子', null, null, null);
INSERT INTO `item_basic` VALUES ('4', '比赛大类', '田赛', '径赛', '趣味赛', null, null);
INSERT INTO `item_basic` VALUES ('5', '田赛比赛项', '跳高', '跳远', '三级跳远', '铅球', '标枪');
INSERT INTO `item_basic` VALUES ('6', '径赛比赛项', '110米栏', '100米', '200米', '400米', '800米');

-- ----------------------------
-- Table structure for record_basic
-- ----------------------------
DROP TABLE IF EXISTS `record_basic`;
CREATE TABLE `record_basic` (
  `id` int(11) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_grade` varchar(255) DEFAULT NULL,
  `ath_name` varchar(255) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `sports_game` varchar(255) DEFAULT NULL,
  `break_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `break_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record_basic
-- ----------------------------
INSERT INTO `record_basic` VALUES ('1', '男子100米', '11.2', '陈军', '材料', '省第二十届大学生\r\n田径运动会\r\n省第二十届大学生\r\n田径运动会\r\n省第二十届大学生\r\n田径运动会\r\n', '1997-05-01 00:00:00', '西安财院');

-- ----------------------------
-- Table structure for referee
-- ----------------------------
DROP TABLE IF EXISTS `referee`;
CREATE TABLE `referee` (
  `id` int(11) DEFAULT NULL,
  `refe_id` int(11) NOT NULL,
  `credit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`refe_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of referee
-- ----------------------------

-- ----------------------------
-- Table structure for temp_group_grade
-- ----------------------------
DROP TABLE IF EXISTS `temp_group_grade`;
CREATE TABLE `temp_group_grade` (
  `id` int(11) DEFAULT NULL,
  `temp_group_id` int(11) DEFAULT NULL,
  `temp_item_id` int(11) DEFAULT NULL,
  `temp_grade` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temp_group_grade
-- ----------------------------

-- ----------------------------
-- Table structure for temp_indiv_grade
-- ----------------------------
DROP TABLE IF EXISTS `temp_indiv_grade`;
CREATE TABLE `temp_indiv_grade` (
  `id` int(11) DEFAULT NULL,
  `temp_ath_id` int(11) DEFAULT NULL,
  `temp_item_id` int(11) DEFAULT NULL,
  `temp_grade` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temp_indiv_grade
-- ----------------------------

-- ----------------------------
-- Table structure for unit_basic
-- ----------------------------
DROP TABLE IF EXISTS `unit_basic`;
CREATE TABLE `unit_basic` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `unit_id` char(2) DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL,
  `unit_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unit_basic
-- ----------------------------
INSERT INTO `unit_basic` VALUES ('1', '01', '轻工科学与工程学院', '学院');
INSERT INTO `unit_basic` VALUES ('2', '02', '材料科学与工程学院', '学院');
INSERT INTO `unit_basic` VALUES ('3', '03', '环境科学与工程学院', '学院');
INSERT INTO `unit_basic` VALUES ('4', '04', '食品与生物工程学院', '学院');
INSERT INTO `unit_basic` VALUES ('5', '05', '机电工程学院', '学院');
INSERT INTO `unit_basic` VALUES ('6', '06', '电气与信息工程学院', '学院');
INSERT INTO `unit_basic` VALUES ('7', '07', '经济与管理学院', '学院');
INSERT INTO `unit_basic` VALUES ('8', '08', '化学与化工学院', '学院');
INSERT INTO `unit_basic` VALUES ('9', '09', '设计与艺术学院', '学院');
INSERT INTO `unit_basic` VALUES ('10', '10', '文理学院', '学院');
INSERT INTO `unit_basic` VALUES ('11', '11', '职业技术学院', '学院');
INSERT INTO `unit_basic` VALUES ('12', '12', '镐京学院', '学院');
INSERT INTO `unit_basic` VALUES ('13', '21', '轻工科学与工程学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('14', '22', '材料科学与工程学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('15', '23', '环境科学与工程学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('16', '24', '食品与生物工程学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('17', '25', '机电工程学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('18', '26', '电气与信息工程学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('19', '27', '经济与管理学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('20', '28', '化学与化工学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('21', '29', '设计与艺术学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('22', '30', '文理学院教工', '工会');
INSERT INTO `unit_basic` VALUES ('23', '31', '职业技术学院教工 ', '工会');
INSERT INTO `unit_basic` VALUES ('24', '32', '机关分会', '工会');
INSERT INTO `unit_basic` VALUES ('25', '33', '保障分会', '工会');
INSERT INTO `unit_basic` VALUES ('26', '34', '后勤集团分会', '工会');
INSERT INTO `unit_basic` VALUES ('27', '35', '图书馆分会 ', '工会');
INSERT INTO `unit_basic` VALUES ('28', '36', '思政部分会', '工会');
INSERT INTO `unit_basic` VALUES ('29', '37', '咸阳分会 ', '工会');
INSERT INTO `unit_basic` VALUES ('30', '38', '附中分会', '工会');

-- ----------------------------
-- Table structure for user_basic
-- ----------------------------
DROP TABLE IF EXISTS `user_basic`;
CREATE TABLE `user_basic` (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_id` char(12) DEFAULT NULL,
  `unit_id` char(2) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL,
  `user_birth` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `user_tel` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `yb_userid` char(32) DEFAULT NULL,
  `qq_openid` char(32) DEFAULT NULL,
  `sign_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `school_id` (`credit_id`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_basic
-- ----------------------------
INSERT INTO `user_basic` VALUES ('1', '201706010101', '01', '翟欣然', '', '女', null, '大学生', '123', 'admin@mail.com', '', '', '2017-11-27 21:20:52');
INSERT INTO `user_basic` VALUES ('2', '201706010102', '02', '李晔晴', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:20:58');
INSERT INTO `user_basic` VALUES ('3', '201706010103', '03', '田香凝', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:00');
INSERT INTO `user_basic` VALUES ('4', '201706010104', '04', '王冠婷', '', '女', null, '大学生', '11', 'swws@wdw', '', '', '2017-11-27 23:13:38');
INSERT INTO `user_basic` VALUES ('5', '201706010105', '05', '杨蒙', '', '女', null, '大学生', '123', 'admin@www', '', '', '2017-11-27 21:21:04');
INSERT INTO `user_basic` VALUES ('6', '201706010106', '06', '张沁阳', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:05');
INSERT INTO `user_basic` VALUES ('7', '201706010107', '07', '张婷婷', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:07');
INSERT INTO `user_basic` VALUES ('8', '201706010108', '08', '陈鑫', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:08');
INSERT INTO `user_basic` VALUES ('9', '201706010109', '09', '杜丹阳', '', '男', null, '大学生', '18888888888', 'admin@ddw.com', '', '', '2017-11-28 16:14:41');
INSERT INTO `user_basic` VALUES ('10', '201706010110', '10', '郭佳伟', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:10');
INSERT INTO `user_basic` VALUES ('11', '201706010111', '11', '郭泽坤', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:12');
INSERT INTO `user_basic` VALUES ('12', '201706010112', '12', '郭煜祺', '', '男', null, '大学生', '15555555555', '1515@dwdw.com', '', '', '2017-11-28 16:17:43');
INSERT INTO `user_basic` VALUES ('13', '201706010113', '01', '韩帅', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:15');
INSERT INTO `user_basic` VALUES ('14', '201706010114', '02', '何纪航', '', '男', null, '大学生', '11', 'swws@wdw', '', '', '2017-11-27 23:13:56');
INSERT INTO `user_basic` VALUES ('15', '201706010115', '03', '李靖', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:17');
INSERT INTO `user_basic` VALUES ('16', '201706010116', '04', '梁晨', '', '男', null, '大学生', '11', 'swws@wdw', '', '', '2017-11-27 23:14:13');
INSERT INTO `user_basic` VALUES ('17', '201706010117', '05', '刘向栋', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:20');
INSERT INTO `user_basic` VALUES ('18', '201706010118', '06', '马丕川', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:21');
INSERT INTO `user_basic` VALUES ('19', '201706010119', '07', '潘艺豪', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:24');
INSERT INTO `user_basic` VALUES ('20', '201706010120', '08', '蒲瑞龙', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:25');
INSERT INTO `user_basic` VALUES ('21', '201706010121', '09', '齐跃', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:26');
INSERT INTO `user_basic` VALUES ('22', '201706010122', '10', '王化东', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:27');
INSERT INTO `user_basic` VALUES ('23', '201706010123', '11', '王佳豪', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:29');
INSERT INTO `user_basic` VALUES ('24', '201706010124', '12', '王桅', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:30');
INSERT INTO `user_basic` VALUES ('25', '201706010125', '01', '王禹森', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:31');
INSERT INTO `user_basic` VALUES ('26', '201706010126', '02', '张博文', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:32');
INSERT INTO `user_basic` VALUES ('27', '201706010127', '03', '张由之', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:33');
INSERT INTO `user_basic` VALUES ('28', '201706010128', '04', '苌晓辉', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:35');
INSERT INTO `user_basic` VALUES ('29', '201706010201', '05', '常澳华', '', '女', null, '大学生', '11', 'swws@wdw', '', '', '2017-11-27 22:39:06');
INSERT INTO `user_basic` VALUES ('30', '201706010202', '06', '程欣', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:37');
INSERT INTO `user_basic` VALUES ('31', '201706010203', '07', '吕诗茗', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:40');
INSERT INTO `user_basic` VALUES ('32', '201706010204', '08', '王佳琪', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:41');
INSERT INTO `user_basic` VALUES ('33', '201706010205', '09', '王雪纯', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:42');
INSERT INTO `user_basic` VALUES ('34', '201706010206', '10', '徐可心', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:43');
INSERT INTO `user_basic` VALUES ('35', '201706010207', '11', '张严', '', '女', null, '大学生', '', '', '', '', '2017-11-27 21:21:45');
INSERT INTO `user_basic` VALUES ('36', '201706010208', '12', '郭家东', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:46');
INSERT INTO `user_basic` VALUES ('37', '201706010209', '01', '贺嘉辉', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:49');
INSERT INTO `user_basic` VALUES ('38', '201706010210', '02', '洪子轩', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:51');
INSERT INTO `user_basic` VALUES ('39', '201706010211', '03', '焦峰', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:52');
INSERT INTO `user_basic` VALUES ('40', '201706010212', '04', '雷翼获', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:53');
INSERT INTO `user_basic` VALUES ('41', '201706010213', '05', '李程', '', '女', null, '大学生', '11', 'swws@wdw', '', '', '2017-11-27 22:56:43');
INSERT INTO `user_basic` VALUES ('42', '201706010214', '06', '李嘉扬', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:55');
INSERT INTO `user_basic` VALUES ('43', '201706010215', '07', '刘景轩', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:56');
INSERT INTO `user_basic` VALUES ('44', '201706010216', '08', '马磊', '', '男', null, '大学生', '1212', 'admin@dsdsds', '', '', '2017-11-28 12:41:44');
INSERT INTO `user_basic` VALUES ('45', '201706010217', '09', '蒙昱佳', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:21:59');
INSERT INTO `user_basic` VALUES ('46', '201706010218', '10', '裴江龙', '', '男', null, '大学生', '', '', '', '', '2017-11-27 21:22:00');
INSERT INTO `user_basic` VALUES ('47', '201706010219', '11', '汪致卉', '', '男', null, '大学生', 'wqqwq', '11111', '', '', '2017-11-28 12:43:29');
INSERT INTO `user_basic` VALUES ('48', '201706010220', '12', '王诚伟', '', '男', null, '大学生', '18291911319', 'admin@dds.com', '', '', '2017-11-28 12:47:23');
INSERT INTO `user_basic` VALUES ('49', '201706010221', '21', '王振博', '', '男', null, '青年教工', '11', 'swws@wdw', '', '', '2017-11-27 22:49:09');
INSERT INTO `user_basic` VALUES ('50', '201706010222', '22', '王钰琦', '', '男', null, '青年教工', '11', 'swws@wdw', '', '', '2017-11-27 22:49:46');
INSERT INTO `user_basic` VALUES ('51', '201706010223', '23', '危星', '', '男', null, '中年教工', '11', 'swws@wdw', '', '', '2017-11-27 22:59:23');
INSERT INTO `user_basic` VALUES ('52', '201706010224', '24', '熊威', '', '男', null, '中年教工', '', '', '', '', '2017-11-27 21:28:19');
INSERT INTO `user_basic` VALUES ('53', '201706010225', '25', '薛嘉俊', '', '男', null, '老年教工', '18291911319', 'admin@ddw', '', '', '2017-11-28 12:56:29');
INSERT INTO `user_basic` VALUES ('54', '201706010226', '26', '杨晓凯', '', '男', null, '老年教工', '18291911319', 'swsws@dwsds', '', '', '2017-11-28 12:57:54');
INSERT INTO `user_basic` VALUES ('55', '201706010227', '27', '尹康', '', '男', null, '中年教工', '18291911319', 'admin@admin', '', '', '2017-11-28 12:59:13');
INSERT INTO `user_basic` VALUES ('56', '201706010228', '28', '朱睿哲', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('57', '201706010301', '29', '陈璨', '', '女', null, '青年教工', '11', 'swws@wdw', '', '', '2017-11-27 23:11:04');
INSERT INTO `user_basic` VALUES ('58', '201706010302', '30', '姜唯佳', '', '女', null, '中年教工', '11', 'swws@wdw', '', '', '2017-11-27 23:11:49');
INSERT INTO `user_basic` VALUES ('59', '201706010303', '31', '雷改转', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('60', '201706010304', '32', '刘新娜', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('61', '201706010305', '33', '吕嘉欣', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('62', '201706010306', '34', '薛妍', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('63', '201706010307', '35', '张晴', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('64', '201706010308', '36', '程毓杰', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('65', '201706010309', '37', '党文博', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('66', '201706010310', '38', '杜景云', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('67', '201706010311', '21', '范朋凯', '', '男', null, '青年教工', '11', 'swws@wdw', '', '', '2017-11-27 22:41:34');
INSERT INTO `user_basic` VALUES ('68', '201706010312', '22', '贺頔', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('69', '201706010313', '23', '贾延伟', '', '男', null, '中年教工', '11', 'swws@wdw', '', '', '2017-11-27 23:00:05');
INSERT INTO `user_basic` VALUES ('70', '201706010314', '24', '赖涛', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('71', '201706010315', '25', '刘俊豪', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('72', '201706010316', '26', '庞策', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('73', '201706010317', '27', '彭涛', '', '男', null, '老年教工', '1826226', '1826226', '', '', '2017-11-28 12:30:31');
INSERT INTO `user_basic` VALUES ('74', '201706010318', '28', '汪炯', '', '男', null, '老年教工', 'ewew', 'ewew', '', '', '2017-11-28 12:32:29');
INSERT INTO `user_basic` VALUES ('75', '201706010319', '29', '文涛', '', '女', null, '青年教工', '11', 'swws@wdw', '', '', '2017-11-27 23:10:03');
INSERT INTO `user_basic` VALUES ('76', '201706010320', '30', '燕康康', '', '女', null, '中年教工', '123123', 'qweqwe', '', '', '2017-11-28 12:40:28');
INSERT INTO `user_basic` VALUES ('77', '201706010321', '31', '燕敏杰', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('78', '201706010322', '32', '杨智浩', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('79', '201706010323', '33', '杨诒尧', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('80', '201706010324', '34', '张浩铭', '', '男', null, '老年教工', '12121212', 'qwqwqwq', '', '', '2017-11-28 12:38:34');
INSERT INTO `user_basic` VALUES ('81', '201706010325', '35', '张盼盼', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('82', '201706010326', '36', '张少乐', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('83', '201706010327', '37', '郑凯迪', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('84', '201706010328', '38', '左李楠', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('85', '201706010401', '21', '李晨', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('86', '201706010402', '22', '乔佳', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('87', '201706010403', '23', '任奕星', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('88', '201706010404', '24', '司萌', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('89', '201706010405', '25', '王茜', '', '女', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('90', '201706010406', '26', '杨凡', '', '女', null, '青年教工', '12121', 'adsaisdji@maid', '', '', '2017-11-28 11:43:39');
INSERT INTO `user_basic` VALUES ('91', '201706010407', '27', '张倩', '', '女', null, '中年教工', '1211', 'swsw@ss', '', '', '2017-11-28 12:27:18');
INSERT INTO `user_basic` VALUES ('92', '201706010408', '28', '翟勇森', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('93', '201706010409', '29', '段浩浩', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('94', '201706010410', '30', '李昊轩', '', '男', null, '中年教工', '11', 'swws@wdw', '', '', '2017-11-27 23:12:58');
INSERT INTO `user_basic` VALUES ('95', '201706010411', '31', '刘世康', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('96', '201706010412', '32', '刘晟源', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('97', '201706010413', '33', '陆彦之', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('98', '201706010414', '34', '马豪', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('99', '201706010415', '35', '毛磊', '', '男', null, '教工', '', '', '', '', null);
INSERT INTO `user_basic` VALUES ('100', '201706010416', '36', '宋金鹏', '', '男', null, '教工', '', '', '', '', null);
SET FOREIGN_KEY_CHECKS=1;
