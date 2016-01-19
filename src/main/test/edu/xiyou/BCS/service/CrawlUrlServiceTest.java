package edu.xiyou.BCS.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import edu.xiyou.BCS.BaseTest;
import edu.xiyou.BCS.model.CrawlUrl;

/**
 * Created by andrew on 15-12-15.
 */

public class CrawlUrlServiceTest  extends BaseTest{
    @Resource
    private CrawlUrlService crawlUrlService;

//    @Test
    public void testInsert(){
        CrawlUrl crawlUrl = new CrawlUrl();
        crawlUrl.setUrl("www.baidu.com");
        crawlUrl.setAuthor("liyanhong");
        crawlUrl.setIntervalTime(24*60*60);
        crawlUrl.setCreateDate(new Date());
        crawlUrl.setUpdateDate(new Date());
        try {
            if (crawlUrlService.insert(crawlUrl) > 0){
                System.out.println("success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void deleteByPrimaryKey(){
        try {
            crawlUrlService.deleteByPrimaryKey(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectBySelective(){
        try {
            List<CrawlUrl> list = crawlUrlService.selectBySelective(new CrawlUrl());
            for (CrawlUrl crawlUrl : list){
                System.out.println(crawlUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
