﻿use `crawl_system`;

DROP TABLE IF EXISTS `crawl_blogs`;

-- -----------------------------------------------------------
-- id 					文章主键
-- url 					文章的地址
-- title 				文章的标题
-- content 				文章的内容
-- author				作者
-- write_date 				文章发布的时间
-- create_date 				文章加入数据库的时间
-- update_date 				本条数据更新的时间
-- vistors_num 				原文章浏览者的数目
-- local_vistors_num    		在本站中，该文章的浏览数目
-- tag 					文章的标签
-- category 				文章分类
-- reprint 				是否是转载 0:原创   1:转载
-- reprint_author 			原创的作者
-- reprint_url 				原创的博客的地址
-- other 				其他数据
-- -----------------------------------------------------------
CREATE TABLE `crawl_blogs`(
  id       		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL ,
  url			VARCHAR(150) NOT NULL,	
  title         	CHAR(100) NOT NULL ,
  content       	TEXT NOT NULL ,
  author        	VARCHAR(50) NOT NULL ,
  write_date		TIMESTAMP NOT NULL,
  create_date		TIMESTAMP NOT NULL,
  update_date		TIMESTAMP NOT NULL,
  vistors_num   		INT(10),
  local_vistors_num  	INT(10),
  tag					VARCHAR(250),
  category 				VARCHAR(100),
  reprint				TINYINT(1) DEFAULT 0,
  reprint_url 			VARCHAR(150),
  reprint_author 		VARCHAR(50),
  other 				VARCHAR(200),
  index(author),
  index(write_date),
  index(create_date),
  index(local_vistors_num)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `crawl_urls`;

-- -----------------------------------------------------------
-- id 				主键
-- url 				抓取的链接
-- author 			作者
-- regex 			正则
-- interval_time 		抓取的间隔时间 86400 = 24 * 60 * 60 秒 一天
-- create_date 			创建时间
-- update_date 			更新时间
-- crawl_date 			上一次爬取的时间
-- -----------------------------------------------------------
CREATE TABLE `crawl_urls`(
	id 			             INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
	url 			             VARCHAR(150) NOT NULL,
	author			       VARCHAR(50),
  regex               VARCHAR(100) NOT NULL,
	interval_time 		INT(10) NOT NULL DEFAULT 86400,
	create_date			  TIMESTAMP NOT NULL,
	update_date			TIMESTAMP NOT NULL,
  crawl_date        TIMESTAMP NOT NULL,
	index(url),
	index(create_date),
  index(crawl_date)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;