/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : book_lending

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 30/12/2022 21:40:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `press` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pub_time` datetime(0) NULL DEFAULT NULL,
  `tid` int NULL DEFAULT NULL,
  `book_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '深入了解java虚拟机', '周志明', '机械工业出版社', '2019-12-01 12:15:31', 1, '深入了解java虚拟机.png', '作为一位Java程序员，你是否也曾经想深入理解Java虚拟机，但是却被它的复杂和深奥拒之门外？没关系，本书极尽化繁为简之妙，能带领你在轻松中领略Java虚拟机的奥秘。本书是近年来国内出版的唯一一本与Java虚拟机相关的专著，也是唯一一本同时从核心理论和实际运用这两个角度去探讨Java虚拟机的著作，不仅理论分析得透彻，而且书中包含的典型案例和最佳实践也极具现实指导意义。', 1, 2, 5);
INSERT INTO `book` VALUES (2, '数据库系统概论', '王珊、萨师煊', '高等教育出版社', '2014-09-16 12:22:47', 2, '数据库系统概论.jpg', '第一篇基础篇，包括绪论、关系数据库、关系数据库标准语言SQL、数据库安全性和数据库完整性，共5章；第二篇设计与应用开发篇，包括关系数据理论、数据库设计和数据库编程，共3章；第三篇系统篇，包括关系查询处理和查询优化、数据库恢复技术、并发控制和数据库管理系统，共4章；第四篇新技术篇，包括数据库技术发展概述、大数据管理、内存数据库系统和数据仓库与联机分析处理技术，共4章。', 2, 1, 5);
INSERT INTO `book` VALUES (3, '算法导论', ' [美] Thomas H.Cormen / Charles E.Leiserson / Ronald L.Rivest / Clifford Stein', '机械工业出版社', '2006-09-21 18:51:19', 3, '算法导论.jpg', '这本书深入浅出，全面地介绍了计算机算法。对每一个算法的分析既易于理解又十分有趣，并保持了数学严谨性。本书的设计目标全面，适用于多种用途。涵盖的内容有：算法在计算中的作用，概率分析和随机算法的介绍。书中专门讨论了线性规划，介绍了动态规划的两个应用，随机化和线性规划技术的近似算法等，还有有关递归求解、快速排序中用到的划分方法与期望线性时间顺序统计算法，以及对贪心算法元素的讨论。', 1, 2, 0);
INSERT INTO `book` VALUES (4, '深入理解计算机系统', '[美] Randal E.Bryant / [美] David O\' Hallaron', '机械工业出版社', '2011-01-01 18:56:11', 4, '深入理解计算机系统.jpg', '本书从程序员的视角详细阐述计算机系统的本质概念，并展示这些概念如何实实在在地影响应用程序的正确性、性能和实用性。全书共12章，主要内容包括信息的表示和处理、程序的机器级表示、处理器体系结构、优化程序性能、存储器层次结构、链接、异常控制流、虚拟存储器、系统级I/O、网络编程、并发编程等。书中提供大量的例子和练习，并给出部分答案，有助于读者加深对正文所述概念和知识的理解。', 2, 2, 4);
INSERT INTO `book` VALUES (5, 'C程序设计语言', '[美] Brian W. Kernighan / [美] Dennis M. Ritchie', '机械工业出版社', '2004-01-21 18:58:57', 1, 'C程序设计语言.jpg', '在计算机发展的历史上，没有哪一种程序设计语言像C语言这样应用广泛。本书作者是C语言的设计者之一Dennis M. Ritchie和著名计算机科学家Brian W. Kernighan合著的一本介绍C语言的权威经典著作。我们现在见到的大量论述C语言程序设计的教材和专著均以此书为蓝本。', 1, 2, 0);
INSERT INTO `book` VALUES (6, 'UNIX网络编程', '史蒂文斯 / 芬纳 / 鲁道夫', '清华大学出版社', '2006-01-21 19:02:43', 5, 'UNIX网络编程.jpg', '《UNIX网络编程》第1版和第2版由已故UNIX网络专家W. Richard Stevens博士独自编写。《UNIX网络编程》(第1卷)(套接口API第3版)是3版，由世界著名网络专家Bill Fenner和Andrew M. Rudoff执笔，根据近几年网络技术的发展，对上一版进行全面修订，增添了IPv6的更新过的信息、SCTP协议和密钥管理套接口的内容，删除了X/Open传输接口的内容。', 2, 1, 12);
INSERT INTO `book` VALUES (7, '设计模式-', ' [美] Erich Gamma / Richard Helm / Ralph Johnson / John Vlissides', '机械工业出版社', '2000-09-21 00:00:00', 6, '设计模式.jpg', '这本书结合设计实作例从面向对象的设计中精选出23个设计模式，总结了面向对象设计中最有价值的经验，并且用简洁可复用的形式表达出来。书中分类描述了一组设计良好、表达清楚的软件设计模式，这些模式在实用环境下特别有用。此书适合大学计算机专业的学生、研究生及相关人员参考。', 1, 0, 8);
INSERT INTO `book` VALUES (8, 'Kafka权威指南', 'Neha Narkhede / Gwen Shapira / Todd Palino', '清华大学出版社', '2017-12-26 00:00:00', 7, 'Kafka权威指南.jpg', '每个应用程序都会产生数据，包括日志消息、度量指标、用户活动记录、响应消息等。如何移动数据，几乎变得与数据本身一样重要。如果你是架构师、开发者或者产品工程师，同时也是Apache Kafka新手，那么这本实践指南将会帮助你成为流式平台上处理实时数据的专家。', 4, 2, 0);
INSERT INTO `book` VALUES (9, 'Java并发编程实战', '[美] Brian Goetz[美] Tim Peierls[美] Joshua Bloch[美] Joseph Bowbeer[美] David Holmes[美] Doug Lea', '机械工业出版社', '2020-05-22 00:00:00', 1, 'Java并发编程实战.jpg', '本书深入浅出地介绍了Java线程和并发，是一本完美的Java并发参考手册。书中从并发性和线程安全性的基本概念出发，介绍了如何使用类库提供的基本并发构建块，用于避免并发危险、构造线程安全的类及验证线程安全的规则', 4, 0, 0);
INSERT INTO `book` VALUES (10, 'MySQL技术内幕', '姜承尧', '机械工业出版社', '2013-06-22 17:20:23', 2, 'MySQL技术内幕.jpg', '本书从源代码的角度深度解析了InnoDB的体系结构、实现原理、工作机制，并给出了大量最佳实践，能帮助你系统而深入地掌握InnoDB，更重要的是，它能为你设计管理高性能、高可用的数据库系统提供绝佳的指导。', 3, 1, 10);
INSERT INTO `book` VALUES (11, 'SQL必知必会', '[美] 本·福达（Ben Forta）', '人民邮电出版社 ', '2020-07-22 17:23:01', 2, 'SQL必知必会.jpg', 'SQL是使用最广泛的数据库语言，绝大多数重要的DBMS支持SQL。本书由浅入深地讲解了SQL的基本概念和语法，涉及数据的排序、过滤和分组，以及表、视图、联结、子查询、游标、存储过程和触发器等内容，实例丰富，便于查阅。新版对书中的案例进行了全面的更新，并增加了章后挑战题，便于读者巩固所学知识。', 3, 0, 0);
INSERT INTO `book` VALUES (12, 'Python3面向对象编程', '[加] 达斯帝·菲利普斯（Dusty Phillips）', '电子工业出版社', '2018-06-22 17:31:38', 1, 'Python3面向对象编程.jpg', '本书中的每一章都会包含一节案例学习的内容，通过一个实践相关的案例将本章介绍的主要内容以及前面章节中介绍过的内容串联起来。除此之外，每一章最后的练习旨在指导你利用本章学习到的知识，使用面向对象编程改善以往项目中的代码，并进一步掌握如何在合适的时机使用Python 3进行面向对象编程。', 4, 1, 22);
INSERT INTO `book` VALUES (14, 'Rust程序设计', '[美] 吉姆·布兰迪（Jim Blandy）[美] 贾森·奥伦多夫（Jason Orendorff）', '人民邮电出版社', '2020-09-22 17:44:49', 1, 'Rust程序设计.jpg', '本书由两位经验丰富的系统程序员撰写，介绍了一种具有C和C++性能，同时安全且支持并发的新型系统编程语言Rust，解释了Rust如何在性能和安全性之间架起桥梁，以及我们如何用好这门语言。', 5, 0, 0);
INSERT INTO `book` VALUES (15, 'C++标准库', '[德] Nicolai M.Josuttis', '电子工业出版社', '2015-06-22 17:46:41', 1, 'C++标准库.jpg', '本书是全球C++经典权威参考书籍时隔12年，基于C++11标准的全新重大升级。标准库提供了一组公共类和接口，极大地拓展了C++语言核心功能。本书详细讲解了每一标准库组件，包括其设计目的和方法、复杂概念的剖析、实用而高效的编程细节、存在的陷阱、重要的类和函数，又辅以大量用C++11标准实现的实用代码范例。', 5, 0, 0);
INSERT INTO `book` VALUES (27, '高可用MySQL', 'Charles Bell Mats Kindahl Lars Thalmann', '电子工业出版社', '2011-10-02 13:30:09', 2, '高可用MySQL.jpg', '高可用mysql:构建健壮的数据中心》读者对象是mysql 专业人士。假设读者已拥有sql、mysql 管理和操作系统的基础背景知识。书中介绍一些关于复制、灾难恢复、系统监控及其他高可用性主题的背景信息...', 2, 0, 0);
INSERT INTO `book` VALUES (31, '图解HTTP', '任文涛', '西安邮电大学出版社', '1970-03-30 00:00:00', 1, '1653878678714.jpg', '这本书很不错', 4, 0, 0);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `bid` int NULL DEFAULT NULL,
  `uid` int NULL DEFAULT NULL,
  `comment_time` datetime(0) NULL DEFAULT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, 2, 1, '2022-04-06 16:29:39', '同志们好');
INSERT INTO `comment` VALUES (3, 1, 2, '2022-04-01 17:10:47', '我是李岳耿');
INSERT INTO `comment` VALUES (4, 1, 3, '2022-04-23 07:32:11', '好好好');
INSERT INTO `comment` VALUES (5, 2, 1, '2022-04-23 07:50:46', 'hello');
INSERT INTO `comment` VALUES (6, 1, 1, '2022-04-25 07:39:45', '测试');
INSERT INTO `comment` VALUES (7, 1, 1, '2022-04-25 07:40:07', '测试2');
INSERT INTO `comment` VALUES (8, 1, 1, '2022-04-25 07:45:03', '213');
INSERT INTO `comment` VALUES (9, 1, 1, '2022-04-25 07:45:05', '4213');
INSERT INTO `comment` VALUES (11, 4, 1, '2022-04-25 07:58:47', '213');
INSERT INTO `comment` VALUES (12, 19, 1, '2022-04-25 09:59:42', '评论');
INSERT INTO `comment` VALUES (13, 6, 1, '2022-04-25 10:48:54', 'HAHHA');
INSERT INTO `comment` VALUES (14, 4, 1, '2022-05-22 19:18:12', 'ddd');
INSERT INTO `comment` VALUES (15, 4, 1, '2022-05-22 19:18:19', 'ddd');
INSERT INTO `comment` VALUES (17, 12, 4, '2022-05-23 10:22:20', 'aaa');
INSERT INTO `comment` VALUES (18, 3, 4, '2022-05-23 10:43:26', 'aaa');
INSERT INTO `comment` VALUES (19, 9, 4, '2022-05-23 10:44:25', 'aaa');
INSERT INTO `comment` VALUES (20, 15, 4, '2022-05-23 10:46:40', 'aaa');
INSERT INTO `comment` VALUES (21, 7, 4, '2022-05-23 10:48:59', 'aaa');
INSERT INTO `comment` VALUES (22, 7, 4, '2022-05-23 10:49:54', '这本书很不错 真的很不错，大家快去看～～');
INSERT INTO `comment` VALUES (23, 6, 4, '2022-05-23 11:00:16', '这本书真的很不错');
INSERT INTO `comment` VALUES (24, 4, 4, '2022-05-23 11:01:28', '这本书真的很不错');
INSERT INTO `comment` VALUES (28, 10, 1, '2022-06-06 17:52:27', '啦啦啦');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `hid` int NOT NULL AUTO_INCREMENT,
  `luid` int NULL DEFAULT NULL,
  `bid` int NULL DEFAULT NULL,
  `buid` int NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `real_time` datetime(0) NULL DEFAULT NULL,
  `punctuality` int NULL DEFAULT NULL,
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (1, 1, 1, 2, '2022-04-01 17:22:36', '2022-04-16 17:22:44', '2022-04-15 17:22:50', 0);
INSERT INTO `history` VALUES (2, 2, 2, 1, '2022-04-02 17:23:24', '2022-04-07 17:23:29', '2022-04-08 17:23:32', 1);
INSERT INTO `history` VALUES (3, 1, 3, 2, '2022-04-24 09:54:33', '2022-04-16 17:22:44', '2022-04-24 09:58:29', 1);
INSERT INTO `history` VALUES (4, 4, 12, 1, '2022-05-16 08:52:04', '2022-07-16 17:22:44', '2022-05-16 14:51:48', 0);
INSERT INTO `history` VALUES (5, 1, 6, 4, '2022-05-16 17:58:46', '2022-06-05 17:58:49', '2022-05-17 17:58:53', 0);
INSERT INTO `history` VALUES (6, 2, 27, 1, '2022-05-16 22:54:46', '2022-05-25 22:54:51', '2022-05-16 14:55:27', 0);
INSERT INTO `history` VALUES (7, 2, 27, 1, '2022-05-16 22:59:57', '2022-05-19 23:00:18', '2022-05-16 15:13:47', 0);
INSERT INTO `history` VALUES (8, 1, 3, 4, '2022-05-17 12:20:33', '2022-05-26 12:20:37', '2022-05-17 04:22:15', 0);
INSERT INTO `history` VALUES (9, 1, 5, 4, '2022-05-10 12:24:37', '2022-05-20 12:24:40', '2022-05-17 12:32:07', 0);
INSERT INTO `history` VALUES (10, 1, 5, 4, '2022-05-15 12:32:46', '2022-05-29 12:32:48', '2022-05-17 12:33:31', 0);
INSERT INTO `history` VALUES (11, 1, 1, 4, '2022-05-17 12:42:44', '2022-05-19 12:42:56', '2022-05-17 12:43:12', 0);
INSERT INTO `history` VALUES (12, 1, 7, 4, '2022-05-18 12:58:42', '2022-05-18 12:58:45', NULL, NULL);
INSERT INTO `history` VALUES (13, 2, 4, 3, '2022-05-18 19:18:27', '2022-05-28 19:18:22', NULL, NULL);
INSERT INTO `history` VALUES (14, 3, 10, 1, '2022-06-06 17:49:32', '2022-06-06 00:00:00', NULL, NULL);
INSERT INTO `history` VALUES (15, 2, 6, 1, '2022-06-06 19:46:48', '2022-06-06 00:00:00', NULL, NULL);

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend`  (
  `rid` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint NULL DEFAULT NULL,
  `bid` bigint NULL DEFAULT NULL,
  `val` bigint NULL DEFAULT NULL,
  `r_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES (1, 1, 1, 5, '2022-04-21 22:20:28');
INSERT INTO `recommend` VALUES (2, 1, 2, 4, '2022-04-14 22:20:43');
INSERT INTO `recommend` VALUES (3, 1, 3, 1, '2022-04-21 22:46:00');
INSERT INTO `recommend` VALUES (4, 1, 4, 5, '2022-04-21 22:46:03');
INSERT INTO `recommend` VALUES (5, 1, 5, 2, '2022-04-21 22:46:05');
INSERT INTO `recommend` VALUES (6, 1, 6, 5, '2022-04-08 22:46:12');
INSERT INTO `recommend` VALUES (7, 1, 7, 3, '2022-04-08 22:46:15');
INSERT INTO `recommend` VALUES (8, 2, 1, 4, '2022-04-06 22:46:18');
INSERT INTO `recommend` VALUES (9, 2, 2, 5, '2022-04-08 22:46:21');
INSERT INTO `recommend` VALUES (10, 2, 3, 1, '2022-04-14 22:46:25');
INSERT INTO `recommend` VALUES (11, 2, 4, 3, '2022-04-22 22:46:29');
INSERT INTO `recommend` VALUES (12, 2, 5, 4, '2022-04-15 22:46:32');
INSERT INTO `recommend` VALUES (13, 2, 6, 4, '2022-04-16 22:46:35');
INSERT INTO `recommend` VALUES (14, 2, 7, 3, '2022-04-16 22:46:37');
INSERT INTO `recommend` VALUES (15, 3, 1, 5, '2022-04-22 10:48:23');
INSERT INTO `recommend` VALUES (16, 3, 3, 5, '2022-04-22 10:48:27');
INSERT INTO `recommend` VALUES (17, 3, 1, 1, '2022-04-22 10:59:11');
INSERT INTO `recommend` VALUES (18, 4, 3, 2, '2022-04-22 10:59:14');
INSERT INTO `recommend` VALUES (19, 4, 5, 5, '2022-04-22 10:59:18');
INSERT INTO `recommend` VALUES (20, 4, 2, 5, '2022-04-22 10:59:21');
INSERT INTO `recommend` VALUES (21, 4, 4, 3, '2022-04-22 10:59:23');
INSERT INTO `recommend` VALUES (22, 4, 6, 5, '2022-04-22 10:59:26');
INSERT INTO `recommend` VALUES (23, 5, 2, 5, '2022-04-22 10:59:28');
INSERT INTO `recommend` VALUES (24, 5, 3, 4, '2022-04-22 10:59:30');
INSERT INTO `recommend` VALUES (25, 5, 5, 1, '2022-04-22 10:59:32');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `tid` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '编程语言');
INSERT INTO `type` VALUES (2, '数据库');
INSERT INTO `type` VALUES (3, '算法');
INSERT INTO `type` VALUES (4, '计算机系统');
INSERT INTO `type` VALUES (5, '网络编程');
INSERT INTO `type` VALUES (6, '设计模式');
INSERT INTO `type` VALUES (7, '消息队列');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `open_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scores` int NULL DEFAULT NULL,
  `register_time` datetime(0) NULL DEFAULT NULL,
  `role` int NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'oR0AJ5ZaaC-j0K_wqiIcW1bUhls4', '黄颖博', 1, '安悦北2504', '18740253585', '', 40, '2022-04-14 17:02:28', 0);
INSERT INTO `user` VALUES (2, 'oR0AJ5aRVANV7Dfn-qYYqCQOnJQM', '李岳耿', 0, '安美南2504', '12345678965', '1354645482@qq.com', 10, '2022-04-16 17:07:15', 0);
INSERT INTO `user` VALUES (3, 'hbkhkhjbkjhlsdfsdfsdfsdfsdfsddg', '严凯治', 0, '安悦北2504', '12345678975', '7894564123@qq.com', 0, '2022-04-22 10:47:41', 0);
INSERT INTO `user` VALUES (4, 'oR0AJ5UHQIWDvbjosjh7ox16W2h0', '任文涛', 1, '安悦北2504', '15291083796', '1476081727@qq.com', 72, '2022-04-22 15:44:13', 0);
INSERT INTO `user` VALUES (5, 'hbkhkhjbkjhlsdfsdfsdfsdfsdfsddg', '齐彭涛', 1, '安悦北2504', '12345678975', '1294564123@qq.com', 0, '2022-04-22 15:44:15', 0);
INSERT INTO `user` VALUES (6, 'oR0AJ5UHQIWDvbjosjh7ox16W', '任文涛', 1, '安岳北2504~~~', '15291083796', '1476081727@qq.com', 0, '2022-05-06 08:41:09', 1);
INSERT INTO `user` VALUES (7, 'oR0AJ5UHQIWDvbjosjh7ox16W2', NULL, 2, NULL, NULL, NULL, 0, '2022-05-14 12:23:05', 2);
INSERT INTO `user` VALUES (8, 'oR0AJ5aRVANV7Dfn-qYYqCQOnJ', '里约更', 1, '海南临高', '18389870558', '1605482778@qq.com', 0, '2022-05-14 12:24:03', 0);

SET FOREIGN_KEY_CHECKS = 1;
