package edu.xiyou.BCS.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import edu.xiyou.BCS.model.CrawlUrl;

/**
 * Created by andrew on 15-12-8.
 */

//主要面向添加爬取的url链接的服务
public interface CrawlUrlService {

    int insert(CrawlUrl record) throws Exception;

    PageInfo<CrawlUrl> selectBySelective(CrawlUrl record, Page page) throws Exception;

    int deleteByPrimaryKey(Integer id) throws Exception;
}
