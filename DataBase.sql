�糧����¼�������룬��˾���ƣ���������[ˮ���𡢷硢����]����ʷ������������Ԥ�������λ�ã��������ͣ�ͼƬ��·������ע��
�û�����¼�������룬��˾���ƣ���ʷ���׵糧id����ʷ���׵�ۣ���ʷ���׵������������������λ�ã���˾���ͣ���˾��ģ����ע��
�Ƽ����û�id���糧id��

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

INSERT INTO `elects` VALUES (1,'cggc','123','�й����ްӼ��Ź�˾','ˮ��',13,11,'����ʡ�˲���','ˮ��','jd1.jpg','img/','���ް�ˮ����Ŧ��λ���й�����ʡ�˲��о��ڵĳ�����Ͽĩ�˺Ӷ��ϣ����볤����Ͽ�����Ͻ������2.3������ǳ����ϵ�һ������ˮ��վ��Ҳ�����������ĵ�ˮͷ������������ʽˮ��վ��');

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

INSERT INTO `users` VALUES (1,'kang','123','neu','cggc',0.102,0.3,0.4,'����ʡ������','ѧУ','3��������','������ѧ��Northeastern University������ƶ���(NEU)���л����񹲺͹�������ֱ���������о��ʹ�ѧ�������ڶ������ĳ����������ǹ���������211���̡��͡�985���̡��ص㽨���У���ɽ�����������ʡ�������������ص㹲�����Ⱥ���ѡ��2011�ƻ�������111�ƻ�������׿Խ����ʦ���������ƻ����������Ҵ�ѧ��������ʵ��ƻ����ȣ�Ϊ��21����ѧ�����ˡ���Ա��У�����ҹ��������Ͱ�ʮ������������о���Ժ����ʮ������У֮һ���о���������ʮ�����������߸�У֮һ�����й�����1960�ꡢ1978��ȷ����ȫ���ص��ѧ������Ժ��1981��������׼�ľ��в�ʿѧλ����Ȩ�ĸ�У��');

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

INSERT INTO `bill` VALUES (1,'user','cggc','1,1','������','��һ������','�ֽ�','2010-04-11','����');


