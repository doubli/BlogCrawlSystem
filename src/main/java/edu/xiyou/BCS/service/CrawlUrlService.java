package edu.xiyou.BCS.service;


import edu.xiyou.BCS.model.CrawlUrl;

import java.util.List;

/**
 * Created by andrew on 15-12-8.
 */

//主要面向添加爬取的url链接的服务
public interface CrawlUrlService {

    int insert(CrawlUrl record) throws Exception;

    List<CrawlUrl> selectBySelective(CrawlUrl record) throws Exception;

    int deleteByPrimaryKey(Integer id) throws Exception;
}
