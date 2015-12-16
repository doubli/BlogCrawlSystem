package edu.xiyou.BCS.crawl.fetcher;

import com.google.common.collect.Lists;
import edu.xiyou.BCS.crawl.parser.Html2BlogHandler;
import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.service.CrawlUrlService;
import edu.xiyou.andrew.Egg.parser.Handler;
import edu.xiyou.andrew.Egg.scheduler.HashSetScheduler;
import edu.xiyou.andrew.Egg.scheduler.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by andrew on 15-12-16.
 *
 * 对博客进行爬取
 * 默认scheduler是Egg的HashSetScheduler
 * 默认的Handler是 parser 包下的 Html2BlogHandler
 */


public class Spider {
    private final static Logger LOG = LoggerFactory.getLogger(Spider.class);

    @Resource
    private CrawlUrlService crawlUrlService;

    private List<CrawlUrl> crawlUrlList;

    {
        try {
             crawlUrlList = crawlUrlService.selectBySelective(new CrawlUrl());
        } catch (Exception e) {
            crawlUrlList = Lists.newArrayList();
        }
    }

    private Handler handler;
    private Scheduler scheduler;

    public Spider(Handler handler, Scheduler scheduler){
        this.handler = handler;
        this.scheduler = scheduler;
    }

    public Spider(Handler handler){
        this(handler, new HashSetScheduler());
    }

    public Spider(){
        this(new Html2BlogHandler(), new HashSetScheduler());
    }

    public void fetch(){

    }
}
