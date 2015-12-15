package edu.xiyou.BCS.service;

import edu.xiyou.BCS.BaseTest;
import edu.xiyou.BCS.model.CrawlBlog;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by andrew on 15-12-15.
 */
public class CrawlBlogServiceTest extends BaseTest{
    @Resource
    private CrawlBlogService crawlBlogService;

    @Test
    public void testSelectBySelective(){
        try {
            List<CrawlBlog> list = crawlBlogService.selectBySelective(new CrawlBlog());
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        CrawlBlog crawlBlog = new CrawlBlog();
        crawlBlog.setUpdateDate(new Date());
        crawlBlog.setCreateDate(new Date());
        crawlBlog.setAuthor("unknow");
        crawlBlog.setCategory("category");
        crawlBlog.setContent("content");
        crawlBlog.setLocalVistorsNum(123);
        crawlBlog.setOther("other");
        crawlBlog.setReprint(false);
        crawlBlog.setReprintAuthor("reprintAuthor");
        crawlBlog.setReprintUrl("reprintUrl");
        crawlBlog.setTag("tag");
        crawlBlog.setTitle("title");
        crawlBlog.setWriteDate(new Date());
        crawlBlog.setUrl("url");
        try {
            if (crawlBlogService.insert(crawlBlog) > 0){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertSelective(){
        CrawlBlog crawlBlog  = new CrawlBlog();
        crawlBlog.setTitle("title");
        crawlBlog.setAuthor("author");
        crawlBlog.setUrl("url");
        crawlBlog.setContent("content");
        crawlBlog.setWriteDate(new Date());
        crawlBlog.setUpdateDate(new Date());
        crawlBlog.setCreateDate(new Date());
        try {
            crawlBlogService.insertSelective(crawlBlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CrawlBlogService getCrawlBlogService() {
        return crawlBlogService;
    }

    public void setCrawlBlogService(CrawlBlogService crawlBlogService) {
        this.crawlBlogService = crawlBlogService;
    }
}
