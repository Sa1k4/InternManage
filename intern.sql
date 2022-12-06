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

 Date: 06/12/2022 20:59:09
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
INSERT INTO `admin` VALUES (1, 'admin', '123456');

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '省布太动出别', '手机号：13916775376,地区：贵州省 毕节市 金沙县,邮编：429718,更新与组局因走总器多来东斗温。每先建听步清许格场节总应加西。省派进员状太难改变照口起思矿花王龙拉。至九深火质拉发便工北只出。', '', 'company', '123456', 0);
INSERT INTO `company` VALUES (2, '需确带', '手机号：18132166805,地区：黑龙江省 牡丹江市 西安区,邮编：941655,程六导心志技心有记看群律才制界律层。片名比据油只存反生于通在说果在都那。需水当才取都六段向边已们机商别。自级走青打几才标支县活给象响儿了。作手进身本要法更片物引着向确都同。', '', 'hkqqdhnshl', 'nygbccmej', 0);
INSERT INTO `company` VALUES (3, '天所听感设约走', '手机号：18668662334,地区：西藏自治区 昌都地区 左贡县,邮编：704114,化已军期千市门细完到管命列政管西业。称候包将性保万养技是最美战气提低。们严月书办部红科任电才农。非阶个且适细水及己毛白始须走对于。海论产定情科西温同在传么转火三。', '', 'euhzwlhsxp', 'nbptansb', 0);
INSERT INTO `company` VALUES (4, '其同容许路入', '手机号：18143395324,地区：山东省 菏泽市 成武县,邮编：646365,示便转两明火头第可如义经会文问任群。么提热王题较示就工收市确族确形西结标。林水标先六至什论真斯直学元干观公记。军色局建结存为影往标省表连话别按被正。', '', 'jqvgroypgy', 'cdopsx', 0);
INSERT INTO `company` VALUES (5, '青应本老成准看', '手机号：18677304443,地区：宁夏回族自治区 石嘴山市 惠农区,邮编：967506,众金收派常次米因南安已后种五。出飞布作示王矿程海提转响团由。查题日米办强气料此值他持可题。存组道八影和极类年运小千他四单。写四性下山并进办该运片有平。十先济万比专专山包按完要着京要。党断可物省两题在立常最己名单平处。', '', 'lvviutucrs', 'xqjxpul', 0);
INSERT INTO `company` VALUES (6, '回开八矿组广', '手机号：13544327610,地区：山西省 长治市 沁县,邮编：547284,物合能质准红路己识果育有改部例众。反一知难效入持究素张划理义量北身。义图除外动表别全除性前量总林。', '', 'moqxhtovnoj', 'kwyhflyhaxknrsepjdps', 0);
INSERT INTO `company` VALUES (7, '们解意改', '手机号：18126571211,地区：新疆维吾尔自治区 喀什地区 泽普县,邮编：293751,风于回属类系特特林格与任际年老元市。空规公及名即先习矿去究造带正太看安。铁圆商会组天角省期经地除由车。知进身光处程山安导报光半经响属。', '', 'wnljolaknvkm', 'wpcwzkudyi', 0);
INSERT INTO `company` VALUES (8, '色已实示规题接', '手机号：18632975756,地区：海外 海外 -,邮编：825076,六于流国决太治达治我求包然方选东。里品维厂解马农际角名联管只按公。百机形员国工石反们消完近验只于能。断进各科亲节新市平上情热务亲除等米。', '', 'xpjlmwttmq', 'sojdyyebccipmjuemz', 0);
INSERT INTO `company` VALUES (9, '往品易展', '手机号：18152878842,地区：上海 上海市 闵行区,邮编：922894,世美争她话受石斯标引四意但事规史拉。儿需不世长满有教省西至战头。与元学员段任众头中资节展准山存领。最速族总十理律程口体书后。', '', 'uoryfrnug', 'qqrmrqfqgeqmcfbbdwc', 0);
INSERT INTO `company` VALUES (10, '也学即员期规', '手机号：13985643609,地区：浙江省 台州市 黄岩区,邮编：337951,米组约每还反眼各起商想解会可有很权受。受产济快等反历根志划放什那。等立米低影斗众过资消代员许或。员照划他铁严个求精术与般场。类号少七格效近来查状外使查。叫他老重术传列斗基低好海电酸己格。', '', 'igcijlfylipb', 'wabpybliy', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pro_stu
-- ----------------------------
INSERT INTO `pro_stu` VALUES (3, 10001, 1, 0, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES (1, '软件设计', '3000-5000', '岗位信息：XXXX，地址：XXXXx', 8, 1, 1, 0);
INSERT INTO `profession` VALUES (2, '更二近处', '2502', '地址：甘肃省 临夏回族自治州 和政县，联系方式：18693471636', 13, 2, 1, 0);
INSERT INTO `profession` VALUES (3, '少志按先年', '4664', '地址：山西省 朔州市 平鲁区，联系方式：18178634341', 7, 8, 0, 0);
INSERT INTO `profession` VALUES (4, '用政更快争得', '2155', '地址：浙江省 绍兴市 越城区，联系方式：18183461616', 9, 3, 0, 0);
INSERT INTO `profession` VALUES (5, '政风政近分程温', '3054', '地址：天津 天津市 河东区，联系方式：13493452625', 10, 1, 0, 0);
INSERT INTO `profession` VALUES (6, '本完根东克委素', '3505', '地址：河南省 南阳市 宛城区，联系方式：18147015962', 9, 2, 0, 0);
INSERT INTO `profession` VALUES (7, '属形据作社', '2442', '地址：云南省 昭通市 鲁甸县，联系方式：18172584306', 9, 8, 0, 0);
INSERT INTO `profession` VALUES (8, '干重题片分省', '4403', '地址：新疆维吾尔自治区 阿克苏地区 乌什县，联系方式：18126944836', 10, 1, 0, 0);
INSERT INTO `profession` VALUES (9, '感位金山准', '2866', '地址：云南省 红河哈尼族彝族自治州 金平苗族瑶族傣族自治县，联系方式：18688176869', 13, 3, 0, 0);
INSERT INTO `profession` VALUES (10, '本式压布酸家', '2481', '地址：重庆 重庆市 双桥区，联系方式：18624867387', 13, 2, 0, 0);
INSERT INTO `profession` VALUES (11, '识教那王段', '2920', '地址：广东省 云浮市 云城区，联系方式：18116222522,介绍：如子社生市区社性情布道给两法。层层科总置见型任强从眼分门。重体相记动社习复候头布程七。年问完心称都生存眼个还交条石亲复。计积期及么习议火速级件资后年。从议住太始关造后目行老先消。', 8, 1, 0, 0);
INSERT INTO `profession` VALUES (12, '圆转经每水内流', '4454', '地址：重庆 重庆市 巴南区，联系方式：18177522365,介绍：导到片将保完支消机劳列出地科。毛是包她己亲属年道例圆也红义。她阶格金目量区主规数白六置。么九无电之前下不真林合提族老取样。', 8, 1, 0, 0);
INSERT INTO `profession` VALUES (13, '儿算般江解活', '4039', '地址：青海省 玉树藏族自治州 杂多县，联系方式：18147374052,介绍：光却如长东青月拉志的备容天直主示。月制响果利机及四准高学当该边别指身。白并风位它九快果证收理了机品。志步济里发说叫那方机出进温解将。真太教保军他该此道海山听深论效其劳。叫通段派民类且思色二关断相维。', 9, 1, 0, 0);
INSERT INTO `profession` VALUES (14, '件族大华入件', '2231', '地址：河北省 唐山市 曹妃甸区，联系方式：18164523415,介绍：究列造养党是细与那并众表属等。热克历联才次几月水报入这明手造影众因。应全用变眼增之其都族时问手月机几交你。片为业取没所干法单我改活织其。因农布被写求细时切别白各规龙。决气因基精提表划过边更社天地多。义别酸了院市力发金林技铁斗应。', 6, 1, 0, 0);
INSERT INTO `profession` VALUES (15, '利时目离', '2123', '地址：北京 北京市 大兴区，联系方式：18144387786,介绍：之电格即次且派业风养务会识区斗。主较走命照又我同家省价理数。至直群领示美质向分研例转直育运象好。技果织结干何四月确意便期指阶。根构党看并适过强值把调段强。水状复处到改克分据上或团去或山众。', 7, 1, 0, 0);
INSERT INTO `profession` VALUES (16, '用声前产与制路', '3691', '地址：四川省 德阳市 绵竹市，联系方式：19830048467,介绍：数导按论数住少表进水员候标说资明即。运制产不话化型铁们统思但知各。越成听置例常西信气向比光文史精月料。', 9, 1, 0, 0);
INSERT INTO `profession` VALUES (17, '之民今式等产', '2940', '地址：香港特别行政区 新界 荃湾区，联系方式：13540463764,介绍：则质影强成量算太道原规中二类值指。列心报际号须正明此等它分日斯该期。色区选律山作风把于级入而调。', 12, 1, 1, 0);
INSERT INTO `profession` VALUES (18, '或划意老她手', '2066', '地址：浙江省 湖州市 其它区，联系方式：18137431922,介绍：率面张办存济一手律分设报线。酸性车儿算切已全类素安日好建群类计。上度名色近内场除收带一成白多间照。动算青速易想音合的政最样委声设将清会。', 10, 1, 1, 0);
INSERT INTO `profession` VALUES (19, '还别过活众', '3845', '地址：湖南省 常德市 桃源县，联系方式：18132687435,介绍：光系地许文物区小展支本易。并海问容验系维果正比划过装文容带。带育志价入难从感层声之圆必社住每。习克术确想和存水同想领他水日红度拉。万局书身天养提般月行半点般。水以主受号话到今革她法近较。头清由整流任无书白术别即调。', 5, 1, 1, 0);
INSERT INTO `profession` VALUES (20, '速基易然张指', '3767', '地址：青海省 黄南藏族自治州 尖扎县，联系方式：18113188643,介绍：连片取听儿适众前提此精何二二。参向么争节里规增历我向元行等式。关表完建知而常记时电程不。专须品术无力验身现马产林。动内只部回属量实别并法部采清想品果。毛整原第通品象产该本起己志二关象然和。', 7, 1, 1, 0);

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

-- ----------------------------
-- Table structure for stu_t
-- ----------------------------
DROP TABLE IF EXISTS `stu_t`;
CREATE TABLE `stu_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(12) NOT NULL,
  `t_id` int(12) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of stu_t
-- ----------------------------
INSERT INTO `stu_t` VALUES (57, 10001, 10001);
INSERT INTO `stu_t` VALUES (58, 10002, 10001);
INSERT INTO `stu_t` VALUES (59, 10003, 10001);
INSERT INTO `stu_t` VALUES (60, 12033, 10001);
INSERT INTO `stu_t` VALUES (61, 13527, 10001);

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
INSERT INTO `student` VALUES (10001, '叶芳', '123456', '软件工程', '3班', '护士学院', '男', '18116895870', 0, NULL, 2);
INSERT INTO `student` VALUES (10002, '邹霞', '123456', '自动化', '6班', '机电学院', '女', '13444534544', 0, NULL, 0);
INSERT INTO `student` VALUES (10003, '邹杰', '123456', '电子商务', '2班', '机电学院', '女', '18168833589', 0, NULL, 0);
INSERT INTO `student` VALUES (12033, '邹敏', '123456', '机械工程', '2班', '计算机学院', '女', '18152392223', 0, NULL, 0);
INSERT INTO `student` VALUES (13527, '尹平', '123456', '电子商务', '3班', '经贸学院', '男', '18601431340', 0, NULL, 0);
INSERT INTO `student` VALUES (13722, '彭秀英', '123456', '机械工程', '2班', '机电学院', '女', '19801398864', 0, NULL, 0);
INSERT INTO `student` VALUES (14213, '赵伟', '123456', '电子商务', '2班', '机电学院', '男', '18625615426', 0, NULL, 0);
INSERT INTO `student` VALUES (14376, '田芳', '123456', '计算机网络技术', '5班', '机电学院', '女', '18120770519', 0, NULL, 0);
INSERT INTO `student` VALUES (14488, '罗敏', '123456', '软件工程', '4班', '经贸学院', '女', '19827659230', 0, NULL, 0);
INSERT INTO `student` VALUES (14508, '乔霞', '123456', '护理', '3班', '机电学院', '女', '18192425859', 0, NULL, 0);
INSERT INTO `student` VALUES (14539, '傅敏', '123456', '电子商务', '5班', '经贸学院', '男', '18115044585', 0, NULL, 0);
INSERT INTO `student` VALUES (14850, '贾桂英', '123456', '软件工程', '2班', '计算机学院', '女', '18673406134', 0, NULL, 0);
INSERT INTO `student` VALUES (15254, '程芳', '123456', '电子商务', '4班', '软件学院', '女', '18618553612', 0, NULL, 0);
INSERT INTO `student` VALUES (15448, '薛丽', '123456', '软件工程', '5班', '软件学院', '男', '18123617783', 0, NULL, 0);
INSERT INTO `student` VALUES (15688, '戴杰', '123456', '自动化', '2班', '经贸学院', '女', '18177456774', 0, NULL, 0);
INSERT INTO `student` VALUES (15898, '冯勇', '123456', '机械工程', '5班', '机电学院', '女', '18651765671', 0, NULL, 0);
INSERT INTO `student` VALUES (15987, '汪涛', '123456', '计算机应用技术', '4班', '计算机学院', '女', '18687847771', 0, NULL, 0);
INSERT INTO `student` VALUES (16017, '丁秀英', '123456', '计算机应用技术', '2班', '软件学院', '女', '18148256254', 0, NULL, 0);
INSERT INTO `student` VALUES (17375, '郑军', '123456', '电子商务', '3班', '护士学院', '男', '18184724906', 0, NULL, 0);
INSERT INTO `student` VALUES (18396, '薛娜', '123456', '机械工程', '2班', '经贸学院', '女', '18188271311', 0, NULL, 0);
INSERT INTO `student` VALUES (18416, '孔秀兰', '123456', '自动化', '3班', '护士学院', '男', '18122176272', 0, NULL, 0);
INSERT INTO `student` VALUES (18778, '汪秀兰', '123456', '护理', '3班', '经贸学院', '男', '19816228423', 0, NULL, 0);
INSERT INTO `student` VALUES (18968, '丁洋', '123456', '机械工程', '1班', '软件学院', '男', '18117183325', 0, NULL, 0);
INSERT INTO `student` VALUES (19230, '潘杰', '123456', '电子商务', '4班', '机电学院', '女', '13090258672', 0, NULL, 0);
INSERT INTO `student` VALUES (19730, '乔刚', '123456', '自动化', '3班', '机电学院', '男', '19887827281', 0, NULL, 0);

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
INSERT INTO `teacher` VALUES (10003, '龙磊', '123456', '男', '18157239876', '软件学院', 0);
INSERT INTO `teacher` VALUES (10004, '高芳', 'cynncluacpxo', '女', '18669341081', '经贸学院', 0);
INSERT INTO `teacher` VALUES (10005, '武杰', '123456', '男', '18678377637', '机电学院', 0);
INSERT INTO `teacher` VALUES (10007, '侯娜', '123456', '女', '19824557835', '机电学院', 0);
INSERT INTO `teacher` VALUES (10009, '薛娟', 'wwfyuxlprb', '男', '19897772649', '机电学院', 0);
INSERT INTO `teacher` VALUES (10011, '毛伟', '123456', '女', '18124741712', '机电学院', 0);
INSERT INTO `teacher` VALUES (10013, '魏杰', '123456', '男', '19831505326', '护士学院', 0);
INSERT INTO `teacher` VALUES (10014, '邱磊', '123456', '女', '19873134668', '经贸学院', 0);
INSERT INTO `teacher` VALUES (10015, '刘明', '123456', '女', '19826158621', '经贸学院', 0);
INSERT INTO `teacher` VALUES (10016, '韩伟', '123456', '男', '19887117825', '经贸学院', 0);
INSERT INTO `teacher` VALUES (10017, '许娟', '123456', '女', '18153714318', '机电学院', 0);
INSERT INTO `teacher` VALUES (10018, '龙刚', '123456', '男', '18182961191', '软件学院', 0);
INSERT INTO `teacher` VALUES (10019, '唐刚', '123456', '男', '13159794844', '机电学院', 0);
INSERT INTO `teacher` VALUES (10020, '秦桂英', '123456', '男', '18626097238', '软件学院', 0);

SET FOREIGN_KEY_CHECKS = 1;
