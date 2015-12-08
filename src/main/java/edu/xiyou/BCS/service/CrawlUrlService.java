package edu.xiyou.BCS.service;

import edu.xiyou.BCS.model.CrawlUrl;

/**
 * Created by andrew on 15-12-8.
 */
public interface CrawlUrlService {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlUrl record);

    int insertSelective(CrawlUrl record);

    CrawlUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlUrl record);

    int updateByPrimaryKey(CrawlUrl record);

}
