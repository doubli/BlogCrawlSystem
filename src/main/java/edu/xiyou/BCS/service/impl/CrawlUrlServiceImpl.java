package edu.xiyou.BCS.service.impl;

import edu.xiyou.BCS.dao.CrawlUrlMapper;
import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.service.CrawlUrlService;

import javax.annotation.Resource;

/**
 * Created by andrew on 15-12-8.
 */
public class CrawlUrlServiceImpl implements CrawlUrlService{
    @Resource
    CrawlUrlMapper crawlUrlMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return crawlUrlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrawlUrl record) {
        return crawlUrlMapper.insert(record);
    }

    @Override
    public int insertSelective(CrawlUrl record) {
        return crawlUrlMapper.insertSelective(record);
    }

    @Override
    public CrawlUrl selectByPrimaryKey(Integer id) {
        return crawlUrlMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrawlUrl record) {
        return crawlUrlMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrawlUrl record) {
        return crawlUrlMapper.updateByPrimaryKey(record);
    }

    public CrawlUrlMapper getCrawlUrlMapper() {
        return crawlUrlMapper;
    }

    public void setCrawlUrlMapper(CrawlUrlMapper crawlUrlMapper) {
        this.crawlUrlMapper = crawlUrlMapper;
    }
}
