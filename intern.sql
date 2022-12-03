/*
 Navicat Premium Data Transfer

 Source Server         : PK
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39)
 Source Host           : localhost:3306
 Source Schema         : intern

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39)
 File Encoding         : 65001

 Date: 04/12/2022 00:19:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adm_id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名字',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adm_id`) USING BTREE,
  UNIQUE INDEX `nameOnly`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '1001', '123456');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `cpmy_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `company_legal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `company_licence` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0是没删，1删了',
  PRIMARY KEY (`cpmy_id`) USING BTREE,
  UNIQUE INDEX `company_name`(`company_name`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '权威企业', '张三', '1669995857022cat2.png', 'root', '123456', 0);
INSERT INTO `company` VALUES (2, '生作和斯', '金明', 'http://voi.io/gtc', 'fyhxftgentsg', 'ipxtrcxghkuiqtcgb', 0);
INSERT INTO `company` VALUES (3, '样专面', '白强', 'http://fbmlrow.org/xhtvopc', 'ecohpjlzxfl', 'xkcskurhyjvgthzpj', 0);
INSERT INTO `company` VALUES (4, '主感达任合场代', '秦芳', 'http://hhyjim.ug/wkqisbzq', 'zjdngoxvcguq', 'cyqyuvl', 0);
INSERT INTO `company` VALUES (5, '到山广动', '阎霞', 'http://wmnvmxfft.sz/puqbwh', 'josjxlin', 'qsrigfpemlskynpwkrue', 0);
INSERT INTO `company` VALUES (6, '格就省对带', '黄娜', 'http://mnfuudgmy.do/xgcbg', 'sokfgevc', 'wunrkmlztwswph', 0);
INSERT INTO `company` VALUES (7, '制保战世', '萧涛', 'http://vvv.mm/vtifrjix', 'dworkzjphro', 'ccnwenhopvzcesrmg', 0);
INSERT INTO `company` VALUES (8, '教石比情', '蒋丽', 'http://oueryrywm.lc/nkehjxpz', 'cnmkxuyiii', 'elxglmbydqs', 0);
INSERT INTO `company` VALUES (9, '流前果其然', '廖静', 'http://hrbdvjpfus.np/cfzpyqhko', 'pambdbbhnu', 'ijbojkgbpeurswdykjb', 0);
INSERT INTO `company` VALUES (10, '引表酸结自工', '乔秀英', 'http://dchrt.cn/bnflno', 'nugpinapnv', 'bjjndjpxeeoqzhav', 0);
INSERT INTO `company` VALUES (11, '委干不联包', '武艳', 'http://ajyq.bt/ijsycghqy', 'lyrwfuteyxxh', 'wugtcrnjietsu', 0);
INSERT INTO `company` VALUES (12, '音只果打切物流', '田涛', 'http://miuteppg.ge/tnzmnxs', 'xlorcoyl', 'ptklificewmzaruri', 0);
INSERT INTO `company` VALUES (13, '务化号是形', '冯杰', 'http://sfmj.cg/opmuybfxsq', 'diuocmscnq', 'tlovvry', 0);
INSERT INTO `company` VALUES (14, '又步天具反热九', '万娟', 'http://lwcyujbo.kp/wuyjfh', 'lmvfbmlqvyh', 'ktdhywwchspi', 0);
INSERT INTO `company` VALUES (15, '么团切状观他', '罗丽', 'http://umfkvnhy.tel/iogdimgxou', 'qvsdqtswxo', 'xqddmmglupfmo', 0);

-- ----------------------------
-- Table structure for evaluate_c
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_c`;
CREATE TABLE `evaluate_c`  (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评假id',
  `stu_id` int(12) NOT NULL COMMENT '学生id',
  `com_id` int(11) NOT NULL COMMENT '企业id',
  `eva_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `eva_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`eva_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of evaluate_c
-- ----------------------------
INSERT INTO `evaluate_c` VALUES (1, 1, 1, 'in est', '1982-09-29 03:45:22', 0);

-- ----------------------------
-- Table structure for evaluate_t
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_t`;
CREATE TABLE `evaluate_t`  (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评假id',
  `stu_id` int(12) NOT NULL COMMENT '学生id',
  `t_id` int(12) NOT NULL COMMENT '教师',
  `eva_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `eva_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`eva_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of evaluate_t
-- ----------------------------
INSERT INTO `evaluate_t` VALUES (1, 1, 1, 'Ut laborum incididunt consequat sit', '1988-10-07 19:51:45', 0);

-- ----------------------------
-- Table structure for pro_stu
-- ----------------------------
DROP TABLE IF EXISTS `pro_stu`;
CREATE TABLE `pro_stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `apply_com` int(11) NOT NULL DEFAULT 0 COMMENT '岗位申请是否通过，0申请中，1通过，2不通过，默认0',
  `del` int(11) NOT NULL DEFAULT 0 COMMENT '0默认，1离职',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pro_stu
-- ----------------------------
INSERT INTO `pro_stu` VALUES (1, 209350322, 1, 0, 0);
INSERT INTO `pro_stu` VALUES (2, 209350301, 1, 0, 0);

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `salary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '薪水',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '介绍岗位信息，包括公司联系方式和地址',
  `apply_num` int(11) NOT NULL DEFAULT 0 COMMENT '人数',
  `com_id` int(11) NOT NULL COMMENT '企业id',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '岗位状态 0未审核，1开启，2关闭，3未通过审核',
  `del` tinyint(1) NOT NULL DEFAULT 0 COMMENT '默认0，删除后是显示1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES (1, '软件设计', '3000-5000', '岗位信息：XXXX，地址：XXXXx', 8, 1, 1, 0);
INSERT INTO `profession` VALUES (2, '更二近处', '2502', '地址：甘肃省 临夏回族自治州 和政县，联系方式：18693471636', 13, 2, 0, 0);
INSERT INTO `profession` VALUES (3, '少志按先年', '4664', '地址：山西省 朔州市 平鲁区，联系方式：18178634341', 7, 8, 0, 0);
INSERT INTO `profession` VALUES (4, '用政更快争得', '2155', '地址：浙江省 绍兴市 越城区，联系方式：18183461616', 9, 3, 0, 0);
INSERT INTO `profession` VALUES (5, '政风政近分程温', '3054', '地址：天津 天津市 河东区，联系方式：13493452625', 10, 1, 3, 0);
INSERT INTO `profession` VALUES (6, '本完根东克委素', '3505', '地址：河南省 南阳市 宛城区，联系方式：18147015962', 9, 2, 0, 0);
INSERT INTO `profession` VALUES (7, '属形据作社', '2442', '地址：云南省 昭通市 鲁甸县，联系方式：18172584306', 9, 8, 0, 0);
INSERT INTO `profession` VALUES (8, '干重题片分省', '4403', '地址：新疆维吾尔自治区 阿克苏地区 乌什县，联系方式：18126944836', 10, 1, 0, 0);
INSERT INTO `profession` VALUES (9, '感位金山准', '2866', '地址：云南省 红河哈尼族彝族自治州 金平苗族瑶族傣族自治县，联系方式：18688176869', 13, 3, 0, 0);
INSERT INTO `profession` VALUES (10, '本式压布酸家', '2481', '地址：重庆 重庆市 双桥区，联系方式：18624867387', 13, 2, 0, 0);

-- ----------------------------
-- Table structure for stu_leave
-- ----------------------------
DROP TABLE IF EXISTS `stu_leave`;
CREATE TABLE `stu_leave`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apply` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0申请，1同意，2不同意',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_leave
-- ----------------------------

-- ----------------------------
-- Table structure for stu_plan
-- ----------------------------
DROP TABLE IF EXISTS `stu_plan`;
CREATE TABLE `stu_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_plan
-- ----------------------------

-- ----------------------------
-- Table structure for stu_repo
-- ----------------------------
DROP TABLE IF EXISTS `stu_repo`;
CREATE TABLE `stu_repo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_repo
-- ----------------------------

-- ----------------------------
-- Table structure for stu_t
-- ----------------------------
DROP TABLE IF EXISTS `stu_t`;
CREATE TABLE `stu_t`  (
  `id` int(11) NOT NULL,
  `stu_id` int(12) NOT NULL,
  `t_id` int(12) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of stu_t
-- ----------------------------

-- ----------------------------
-- Table structure for stu_week
-- ----------------------------
DROP TABLE IF EXISTS `stu_week`;
CREATE TABLE `stu_week`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` date NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_week
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(12) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `specialty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `classname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `academy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `del` tinyint(1) NULL DEFAULT 0,
  `vitae` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简历',
  `apply` tinyint(255) NULL DEFAULT 0 COMMENT '实习申请，0未申请/未通过，1已申请，2通过',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (209350301, '方娜', '123456', '计算机网络技术', '12班', '护士学院', '女', '18131642936', 0, '1669995011198cat2.png', 2);
INSERT INTO `student` VALUES (209350305, '邵平', 'vumllrfsduhi', '计算机应用技术', '2班', '软件学院', '女', '13483775641', 0, '1669988580930cat2.png', 0);
INSERT INTO `student` VALUES (209350308, '龚静', 'atzotmcvjgepj', '自动化', '4班', '经贸学院', '女', '13224058835', 0, NULL, 0);
INSERT INTO `student` VALUES (209350312, '阎洋', 'guwdjxqeg', '护理', '5班', '机电学院', '男', '18126179283', 0, NULL, 0);
INSERT INTO `student` VALUES (209350318, '余敏', 'gldddfrtwhc', '软件工程', '5班', '护士学院', '女', '18116517665', 0, NULL, 0);
INSERT INTO `student` VALUES (209350319, '金丽', 'vzfeonn', '自动化', '3班', '机电学院', '男', '18637827549', 0, NULL, 0);
INSERT INTO `student` VALUES (209350321, '秦娟', 'dyqctjeedblmcuvau', '电子商务', '4班', '计算机学院', '女', '18187247411', 0, NULL, 0);
INSERT INTO `student` VALUES (209350322, '陈一', '123456', '计算机科学与技术', '3班', '计算机学院', '男', '17345598426', 0, NULL, 0);
INSERT INTO `student` VALUES (209350323, '黄娟', 'wijipqinyrl', '机械工程', '2班', '软件学院', '女', '19813465278', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350329, '胡超', 'ivyesemmyffdvoegwhs', '电子商务', '3班', '软件学院', '男', '18691502697', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350340, '万洋', 'dlpliiirb', '机械工程', '1班', '计算机学院', '女', '18100641536', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350341, '赵艳', 'ojpqlgogqkbllhxfovb', '计算机应用技术', '2班', '经贸学院', '女', '18684631274', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350343, '叶静', 'mxkfjodq', '机械工程', '6班', '软件学院', '男', '18158179141', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350346, '程洋', 'vxcsobwvym', '护理', '5班', '护士学院', '男', '18132487635', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350350, '曹强', 'eqkfaalfxupobojpdfgm', '机械工程', '2班', '机电学院', '男', '18127664465', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350357, '廖静', 'odyeiwtvrsybyplthci', '机械工程', '4班', '经贸学院', '男', '13564940943', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350360, '史敏', 'gluagcydwajolgtd', '计算机应用技术', '2班', '软件学院', '女', '18178665003', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350362, '郑桂英', 'vmxulcbntlczmmzawx', '护理', '5班', '机电学院', '男', '19805445818', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350365, '金霞', 'mdnwtbnmmiofejezbeh', '自动化', '2班', '经贸学院', '女', '18132548254', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350366, '于超', 'pamvwd', '机械工程', '5班', '经贸学院', '女', '18683988915', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350372, '赖秀兰', 'wkwhiirivktiwssepxzi', '计算机网络技术', '5班', '机电学院', '女', '13441873455', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350376, '方娜', 'lbudxldae', '计算机网络技术', '5班', '软件学院', '女', '18141576221', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350378, '刘敏', 'ojrjcvy', '计算机网络技术', '2班', '软件学院', '男', '18147296526', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350382, '万刚', 'tfyanj', '护理', '4班', '机电学院', '女', '19875556454', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350391, '余强', 'onkkywpdumkef', '计算机网络技术', '2班', '经贸学院', '男', '19832719044', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350392, '邹强', 'ycdvdfkffjoertwchink', '护理', '2班', '软件学院', '女', '18626876647', 0, NULL, NULL);
INSERT INTO `student` VALUES (209350398, '尹秀英', 'vdzevf', '计算机网络技术', '2班', '经贸学院', '女', '19892153516', 0, NULL, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int(12) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `academy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (10001, '李老师', '123456', '男', '17345561794', '计算机', 0);
INSERT INTO `teacher` VALUES (10003, '龙磊', 'kffhiijytuicfondlh', '男', '18157239876', '软件学院', 0);
INSERT INTO `teacher` VALUES (10005, '武杰', 'hepdgmqoflwy', '男', '18678377637', '机电学院', 0);
INSERT INTO `teacher` VALUES (10007, '侯娜', 'eeseeipipjendfhqql', '女', '19824557835', '机电学院', 0);
INSERT INTO `teacher` VALUES (10011, '毛伟', 'hxguozjhap', '女', '18124741712', '机电学院', 0);
INSERT INTO `teacher` VALUES (10013, '魏杰', 'irjbvakwgnzephq', '男', '19831505326', '护士学院', 0);
INSERT INTO `teacher` VALUES (10014, '邱磊', 'tilsgvxfxkesewscahc', '女', '19873134668', '经贸学院', 0);
INSERT INTO `teacher` VALUES (10015, '刘明', 'auzvuxdjnburrn', '女', '19826158621', '经贸学院', 0);
INSERT INTO `teacher` VALUES (10016, '韩伟', 'ivkogwiu', '男', '19887117825', '经贸学院', 0);
INSERT INTO `teacher` VALUES (10017, '许娟', 'eybpenwfh', '女', '18153714318', '机电学院', 0);
INSERT INTO `teacher` VALUES (10018, '龙刚', 'xpitjaumoibwd', '男', '18182961191', '软件学院', 0);
INSERT INTO `teacher` VALUES (10019, '唐刚', 'ejvvudfksmdbcohhi', '男', '13159794844', '机电学院', 0);
INSERT INTO `teacher` VALUES (10020, '秦桂英', 'dodqpnubtkbgy', '男', '18626097238', '软件学院', 0);

SET FOREIGN_KEY_CHECKS = 1;
