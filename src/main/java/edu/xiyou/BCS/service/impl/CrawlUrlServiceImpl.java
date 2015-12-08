package edu.xiyou.BCS.service.impl;

import edu.xiyou.BCS.dao.CrawlUrlMapper;
import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.service.CrawlUrlService;

import javax.annotation.Resource;

/**
 * Created by andrew on 15-12-8.
 */

@Resource
public class CrawlUrlServiceImpl implements CrawlUrlService{
    @Resource
    CrawlUrlMapper crawlUrlMapper;



    public CrawlUrlMapper getCrawlUrlMapper() {
        return crawlUrlMapper;
    }

    public void setCrawlUrlMapper(CrawlUrlMapper crawlUrlMapper) {
        this.crawlUrlMapper = crawlUrlMapper;
    }
}
