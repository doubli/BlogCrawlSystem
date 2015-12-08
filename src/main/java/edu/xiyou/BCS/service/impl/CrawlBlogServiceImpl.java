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


    public CrawlBlogMapper getCrawlBlogMapper() {
        return crawlBlogMapper;
    }

    public void setCrawlBlogMapper(CrawlBlogMapper crawlBlogMapper) {
        this.crawlBlogMapper = crawlBlogMapper;
    }
}
