package edu.xiyou.BCS.dao;

import java.util.List;

import edu.xiyou.BCS.model.CrawlUrl;

public interface CrawlUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlUrl record);

    int insertSelective(CrawlUrl record);

    CrawlUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlUrl record);

    int updateByPrimaryKey(CrawlUrl record);

    List<CrawlUrl> selectBySelective(CrawlUrl record);
}