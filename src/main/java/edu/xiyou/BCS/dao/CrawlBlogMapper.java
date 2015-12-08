package edu.xiyou.BCS.dao;

import edu.xiyou.BCS.model.CrawlBlog;

public interface CrawlBlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlBlog record);

    int insertSelective(CrawlBlog record);

    CrawlBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlBlog record);

    int updateByPrimaryKeyWithBLOBs(CrawlBlog record);

    int updateByPrimaryKey(CrawlBlog record);
}