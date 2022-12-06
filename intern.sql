/*
 Navicat Premium Data Transfer

 Source Server         : Saika
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : intern

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 06/12/2022 17:39:45
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
  `company_legal` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司介绍',
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
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `stu_id` int(12) NOT NULL COMMENT '学生id',
  `com_id` int(11) NOT NULL COMMENT '企业id',
  `eva_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `eva_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`eva_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of evaluate_c
-- ----------------------------
INSERT INTO `evaluate_c` VALUES (1, 1, 1, 'in est', '1982-09-29 03:45:22', 0);
INSERT INTO `evaluate_c` VALUES (3, 209350301, 1, '1234', '2022-12-05', 0);
INSERT INTO `evaluate_c` VALUES (4, 209350322, 1, '12345', '2022-12-05', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of evaluate_t
-- ----------------------------
INSERT INTO `evaluate_t` VALUES (1, 1, 1, 'Ut laborum incididunt consequat sit', '1988-10-07 19:51:45', 0);
INSERT INTO `evaluate_t` VALUES (2, 209350301, 10001, '好', '2022-12-06', 0);

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
INSERT INTO `pro_stu` VALUES (1, 209350322, 1, 1, 1);
INSERT INTO `pro_stu` VALUES (2, 209350301, 1, 1, 0);

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `salary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '薪水',
  `introduce` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '介绍岗位信息，包括公司联系方式和地址',
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
INSERT INTO `profession` VALUES (2, '更二近处', '2502', '地址：甘肃省 临夏回族自治州 和政县，联系方式：18693471636', 13, 2, 3, 0);
INSERT INTO `profession` VALUES (3, '少志按先年', '4664', '地址：山西省 朔州市 平鲁区，联系方式：18178634341', 7, 8, 1, 0);
INSERT INTO `profession` VALUES (4, '用政更快争得', '2155', '地址：浙江省 绍兴市 越城区，联系方式：18183461616', 9, 3, 3, 0);
INSERT INTO `profession` VALUES (5, '政风政近分程温', '3054', '地址：天津 天津市 河东区，联系方式：13493452625', 10, 1, 1, 0);
INSERT INTO `profession` VALUES (6, '本完根东克委素', '3505', '地址：河南省 南阳市 宛城区，联系方式：18147015962', 9, 2, 3, 0);
INSERT INTO `profession` VALUES (7, '属形据作社', '2442', '地址：云南省 昭通市 鲁甸县，联系方式：18172584306', 9, 8, 0, 0);
INSERT INTO `profession` VALUES (8, '干重题片分省', '4403', '地址：新疆维吾尔自治区 阿克苏地区 乌什县，联系方式：18126944836', 10, 1, 1, 0);
INSERT INTO `profession` VALUES (9, '感位金山准', '2866', '地址：云南省 红河哈尼族彝族自治州 金平苗族瑶族傣族自治县，联系方式：18688176869', 13, 3, 0, 0);
INSERT INTO `profession` VALUES (10, '本式压布酸家', '2481', '地址：重庆 重庆市 双桥区，联系方式：18624867387', 13, 2, 0, 0);

-- ----------------------------
-- Table structure for stu_leave
-- ----------------------------
DROP TABLE IF EXISTS `stu_leave`;
CREATE TABLE `stu_leave`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apply` int(255) NULL DEFAULT 0 COMMENT '0申请，1同意，2不同意,默认0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_leave
-- ----------------------------
INSERT INTO `stu_leave` VALUES (2, 209350301, '123', '2022-12-14', '2023-01-12', 0);
INSERT INTO `stu_leave` VALUES (3, 209350301, '我们一般认为，抓住了问题的关键，其他一切则会迎刃而解。 带着这些问题，我们来审视一下实习请假申请。 这样看来， 我认为， 这种事实对本人来说意义重大，相信对这个世界也是有一定意义的。 了解清楚实习请假申请到底是一种怎么样的存在，是解决一切问题的关键。 那么， 黑塞曾经提到过，有勇气承担命运这才是英雄好汉。我希望诸位也能好好地体会这句话。 而这些并不是完全重要，更加重要的问题是， 经过上述讨论， 一般来讲，我们都必须务必慎重的考虑考虑。 一般来讲，我们都必须务必慎重的考虑考虑。 叔本华曾经说过，普通人只想到如何度过时间，有才能的人设法利用时间。这似乎解答了我的疑惑。 实习请假申请，发生了会如何，不发生又会如何。 就我个人来说，实习请假申请对我的意义，不能不说非常重大。 我们都知道，只要有意义，那么就必须慎重考虑。 既然如何， 生活中，若实习请假申请出现了，我们就不得不考虑它出现了的事实。 叔本华在不经意间这样说过，意志是一个强壮的盲人，倚靠在明眼的跛子肩上。这句话语虽然很短，但令我浮想联翩。 在这种困难的抉择下，本人思来想去，寝食难安。 我们不得不面对一个非常尴尬的事实，那就是， 培根在不经意间这样说过，深窥自己的心，而后发觉一切的奇迹在你自己。我希望诸位也能好好地体会这句话。 可是，即使是这样，实习请假申请的出现仍然代表了一定的意义。 一般来说， 了解清楚实习请假申请到底是一种怎么样的存在，是解决一切问题的关键。 实习请假申请的发生，到底需要如何做到，不实习请假申请的发生，又会如何产生。 在这种困难的抉择下，本人思来想去，寝食难安。 我们不得不面对一个非常尴尬的事实，那就是， 了解清楚实习请假申请到底是一种怎么样的存在，是解决一切问题的关键。 斯宾诺莎说过一句富有哲理的话，最大的骄傲于最大的自卑都表示心灵的最软弱无力。我希望诸位也能好好地体会这句话。 我们都知道，只要有意义，那么就必须慎重考虑。 既然如何， 实习请假申请，到底应该如何实现。 所谓实习请假申请，关键是实习请假申请需要如何写。 我们都知道，只要有意义，那么就必须慎重考虑。 生活中，若实习请假申请出现了，我们就不得不考虑它出现了的事实。 在这种困难的抉择下，本人思来想去，寝食难安。 一般来说， 实习请假申请的发生，到底需要如何做到，不实习请假申请的发生，又会如何产生。 实习请假申请的发生，到底需要如何做到，不实习请假申请的发生，又会如何产生。 阿卜·日·法拉兹说过一句富有哲理的话，学问是异常珍贵的东西，从任何源泉吸收都不可耻。带着这句话，我们还要更加慎重的审视这个问题： 每个人都不得不面对这些问题。 在面对这种问题时， 所谓实习请假申请，关键是实习请假申请需要如何写。 要想清楚，实习请假申请，到底是一种怎么样的存在。 带着这些问题，我们来审视一下实习请假申请。 要想清楚，实习请假申请，到底是一种怎么样的存在。 就我个人来说，实习请假申请对我的意义，不能不说非常重大。 生活中，若实习请假申请出现了，我们就不得不考虑它出现了的事实。 一般来说， 对我个人而言，实习请假申请不仅仅是一个重大的事件，还可能会改变我的人生。 那么， 那么， 问题的关键究竟为何？ 实习请假申请因何而发生？ 从这个角度来看， 既然如此， 韩非曾经说过，内外相应，言行相称。这似乎解答了我的疑惑。 本人也是经过了深思熟虑，在每个日日夜夜思考这个问题。 白哲特曾经说过，坚强的信念能赢得强者的心，并使他们变得更坚强。 这不禁令我深思。 对我个人而言，实习请假申请不仅仅是一个重大的事件，还可能会改变我的人生。 既然如此， 拿破仑·希尔曾经说过，不要等待，时机永远不会恰到好处。这句话语虽然很短，但令我浮想联翩。 经过上述讨论， 池田大作曾经说过，不要回避苦恼和困难，挺起身来向它挑战，进而克服它。带着这句话，我们还要更加慎重的审视这个问题： 就我个人来说，实习请假申请对我的意义，不能不说非常重大。 实习请假申请的发生，到底需要如何做到，不实习请假申请的发生，又会如何产生。', '2022-12-07', '2023-01-06', 0);

-- ----------------------------
-- Table structure for stu_plan
-- ----------------------------
DROP TABLE IF EXISTS `stu_plan`;
CREATE TABLE `stu_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_plan
-- ----------------------------
INSERT INTO `stu_plan` VALUES (1, 209350301, '123132414134', '2022-12-06');

-- ----------------------------
-- Table structure for stu_repo
-- ----------------------------
DROP TABLE IF EXISTS `stu_repo`;
CREATE TABLE `stu_repo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_repo
-- ----------------------------
INSERT INTO `stu_repo` VALUES (1, 209350301, '351314641653737', '2022-12-06');

-- ----------------------------
-- Table structure for stu_t
-- ----------------------------
DROP TABLE IF EXISTS `stu_t`;
CREATE TABLE `stu_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NOT NULL,
  `t_id` int(12) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of stu_t
-- ----------------------------
INSERT INTO `stu_t` VALUES (51, 209350308, 10001);
INSERT INTO `stu_t` VALUES (52, 209350312, 10001);
INSERT INTO `stu_t` VALUES (53, 209350318, 10001);
INSERT INTO `stu_t` VALUES (55, 209350301, 10001);
INSERT INTO `stu_t` VALUES (56, 209350305, 10001);

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_week
-- ----------------------------
INSERT INTO `stu_week` VALUES (1, 209350301, '12314143', '2022-12-01', '2022-12-08');

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
INSERT INTO `student` VALUES (209350305, '邵平', '123456', '计算机应用技术', '2班', '软件学院', '女', '13483775641', 0, '1669988580930cat2.png', 0);
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
INSERT INTO `student` VALUES (209350392, '邹强', 'ycdvdfkffjoertwchink', '护理', '2班', '软件学院', '女', '18626876647', 1, NULL, NULL);
INSERT INTO `student` VALUES (209350398, '尹秀英', 'vdzevf', '计算机网络技术', '2班', '经贸学院', '女', '19892153516', 1, NULL, NULL);
INSERT INTO `student` VALUES (209350399, '134314', '13413414', '13413413', '134134134', '34134134', '男', '134134134', 1, NULL, 0);
INSERT INTO `student` VALUES (1241341341, '1341314', '13413413413', '134134134', '13413434', '134134134', '男', '134134', 1, NULL, 0);
INSERT INTO `student` VALUES (1241351351, '1351515', '135135135', '135135135', '135135135', '13513514515', '男', '13513515', 1, NULL, 0);

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
INSERT INTO `teacher` VALUES (10001, '李老师', '123456', '女', '17345561794', '计算机', 0);
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
