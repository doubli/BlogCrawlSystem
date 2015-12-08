package edu.xiyou.BCS.service;

import edu.xiyou.BCS.model.CrawlBlog;

/**
 * Created by andrew on 15-12-8.
 */
public interface CrawlBlogService {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlBlog record);

    int insertSelective(CrawlBlog record);

    CrawlBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlBlog record);

    int updateByPrimaryKeyWithBLOBs(CrawlBlog record);

    int updateByPrimaryKey(CrawlBlog record);
}
