use `crawl_system`;

DROP TABLE IF EXISTS `crarl_blogs`;

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
  write_date    	DATETIME NOT NULL ,
  create_date   	DATETIME NOT NULL DEFAULT now() ,
  update_date   	DATETIME NOT NULL DEFAULT now(),
  vistors_num   	INT，
  local_vistors_num 	INT,
  tag			VARCHAR(250),
  category		VARCHAR(100)，
  reprint		TINYINT DEFAULT 0,
  reprint_url 		VARCHAR(150),
  reprint_author 	VARCHAR(50),
  other 		VARCHAR(200),
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
-- interval_time 		抓取的间隔时间 86400 = 24 * 60 * 60 秒 一天
-- create_date 			创建时间
-- update_date 			更新时间
-- -----------------------------------------------------------
CREATE TABLE `crawl_urls`(
	id 			INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
	url 			VARCHAR(150) NOT NULL,
	author			VARCHAR(50),
	interval_time 		INT NOT DEFAULT 86400,
	create_date 		DATETIME NOT NULL DEFAULT now(),
	update_date 		DATETIME NOT NULL DEFAULT now(),
	index(url),
	index(create_date)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;