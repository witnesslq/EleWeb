电厂表（登录名，密码，公司名称，发电类型[水、火、风、节能]，历史发电量，本次预测电量，位置，机组类型，图片，路径，备注）
用户表（登录名，密码，公司名称，历史交易电厂id，历史交易电价，历史交易电量，本次需求电量，位置，公司类型，公司规模，备注）
推荐表（用户id，电厂id）

CREATE DATABASE `elesys` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `elesys`;
SET NAMES GBK;
CREATE TABLE `elects` (
  `Id` int(11) NOT NULL auto_increment,
  `uid` varchar(20) default '',
  `pwd` varchar(20) default '',
  `cname` varchar(40) default '',
  `type` varchar(20) default '',
  `prequan` float default '0',
  `thisquan` float default '0',
  `location` varchar(100) default '',
  `genset` varchar(40) default '',
  `pic` varchar(20) default '',
  `dir` varchar(20) default '',
  `des` text,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `elects` VALUES (1,'cggc','123','中国葛洲坝集团公司','水电',13,11,'湖北省宜昌市','水轮','jd1.jpg','img/','葛洲坝水利枢纽它位于中国湖北省宜昌市境内的长江三峡末端河段上，距离长江三峡出口南津关下游2.3公里。它是长江上第一座大型水电站，也是世界上最大的低水头大流量、径流式水电站。');

CREATE TABLE `users` (
  `Id` int(11) NOT NULL auto_increment,
  `uid` varchar(20) default '',
  `pwd` varchar(20) default '',
  `cname` varchar(40) default '',
  `predealeid` varchar(20) default '',
  `predealprice` float default '0',
  `predealquan` float default '0',
  `thisrequirequan` float default '0',
  `location` varchar(100) default '',
  `comtype` varchar(20) default '',
  `scale` varchar(20) default '',
  `des` text,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `users` VALUES (1,'kang','123','neu','cggc',0.102,0.3,0.4,'辽宁省沈阳市','学校','3万人以上','东北大学（Northeastern University），简称东大(NEU)，中华人民共和国教育部直属的理工类研究型大学，坐落于东北中心城市沈阳，是国家首批“211工程”和“985工程”重点建设高校，由教育部、辽宁省、沈阳市三方重点共建，先后入选“2011计划”、“111计划”、“卓越工程师教育培养计划”、“国家大学生创新性实验计划”等，为“21世纪学术联盟”成员高校，是我国在上世纪八十年代最早设立研究生院的三十二所高校之一、研究生招生三十四所自主划线高校之一，是中共中央1960年、1978年确定的全国重点大学，国务院在1981年首批批准的具有博士学位授予权的高校。');

CREATE TABLE `recommends` (
  `Id` int(11) NOT NULL auto_increment,
  `uid` varchar(20) default '',
  `eid` varchar(20) default '',
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `recommends` VALUES (1, 'kang', 'cggc');

CREATE TABLE `bill` (
  `Id` int(11) NOT NULL auto_increment,
  `uid` varchar(20) default '',
  `eid` varchar(20) default '',
  `gnums` varchar(255) default '',
  `state` varchar(20) default '',
  `btime` varchar(10) default '',
  `btype` varchar(10) default '',
  `ctime` varchar(20) default '',
  `address` varchar(255) default '',
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `bill` VALUES (1,'user','cggc','1,1','处理中','周一至周五','现金','2010-04-11','北京');


