package edu.xiyou.BCS.service.impl;

import edu.xiyou.BCS.dao.CrawlBlogMapper;
import edu.xiyou.BCS.model.CrawlBlog;
import edu.xiyou.BCS.service.CrawlBlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by andrew on 15-12-8.
 */
@Service
public class CrawlBlogServiceImpl implements CrawlBlogService{
    private final static Logger LOG = LoggerFactory.getLogger(CrawlBlogService.class);

    @Resource
    private CrawlBlogMapper crawlBlogMapper;

    @Override
    public List<CrawlBlog> selectBySelective(CrawlBlog record) throws Exception {
        LOG.info("selectBySelective record = {}" , record);
        try {
            return crawlBlogMapper.selectBySelective(record);
        }catch (Exception e){
            LOG.error("selectBySelective record = {}, Exception = {}" + record, e);
            throw new Exception("selectBySelective record = {}, Exception = {}" + record, e);
        }
    }

    @Override
    public int insert(CrawlBlog record) throws Exception {
        LOG.info("insert record = {}",  record);
        try {
            return crawlBlogMapper.insert(record);
        }catch (Exception e){
            LOG.error("insert record = {}, Exception = {}" + record,  e);
            throw new Exception("insert record = {}, Exception = {}" + record,  e);
        }
    }

    @Override
    public int insertSelective(CrawlBlog record) throws Exception {
        LOG.info("insertSelective record = {}",  record);
        try {
            return crawlBlogMapper.insertSelective(record);
        }catch (Exception e){
            LOG.error("insertSelective record = {}, Exception = {}" + record, e);
            throw new Exception("insertSelective record = {}, Exception = {}" + record, e);
        }
    }

    public CrawlBlogMapper getCrawlBlogMapper() {
        return crawlBlogMapper;
    }

    public void setCrawlBlogMapper(CrawlBlogMapper crawlBlogMapper) {
        this.crawlBlogMapper = crawlBlogMapper;
    }
}
