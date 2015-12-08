package edu.xiyou.BCS.service.impl;

import edu.xiyou.BCS.dao.CrawlBlogMapper;
import edu.xiyou.BCS.model.CrawlBlog;
import edu.xiyou.BCS.service.CrawlBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by andrew on 15-12-8.
 */
@Service
public class CrawlBlogServiceImpl implements CrawlBlogService{
    @Resource
    CrawlBlogMapper crawlBlogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return crawlBlogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrawlBlog record) {
        return crawlBlogMapper.insert(record);
    }

    @Override
    public int insertSelective(CrawlBlog record) {
        return crawlBlogMapper.insertSelective(record);
    }

    @Override
    public CrawlBlog selectByPrimaryKey(Integer id) {
        return crawlBlogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrawlBlog record) {
        return crawlBlogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(CrawlBlog record) {
        return crawlBlogMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(CrawlBlog record) {
        return crawlBlogMapper.updateByPrimaryKey(record);
    }

    public CrawlBlogMapper getCrawlBlogMapper() {
        return crawlBlogMapper;
    }

    public void setCrawlBlogMapper(CrawlBlogMapper crawlBlogMapper) {
        this.crawlBlogMapper = crawlBlogMapper;
    }
}
