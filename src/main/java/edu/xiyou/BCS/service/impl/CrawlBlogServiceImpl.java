package edu.xiyou.BCS.service.impl;

import edu.xiyou.BCS.dao.CrawlBlogMapper;
import edu.xiyou.BCS.model.CrawlBlog;
import edu.xiyou.BCS.service.CrawlBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by andrew on 15-12-8.
 */
@Service
public class CrawlBlogServiceImpl implements CrawlBlogService{
    @Resource
    private CrawlBlogMapper crawlBlogMapper;

    @Override
    public List<CrawlBlog> selectByselective(CrawlBlog record) {
        return null;
    }

    public CrawlBlogMapper getCrawlBlogMapper() {
        return crawlBlogMapper;
    }

    public void setCrawlBlogMapper(CrawlBlogMapper crawlBlogMapper) {
        this.crawlBlogMapper = crawlBlogMapper;
    }
}
