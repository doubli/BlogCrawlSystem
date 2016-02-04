package edu.xiyou.BCS.crawl.fetcher;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import edu.xiyou.BCS.crawl.parser.Html2BlogHandler;
import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.page.PageConstant;
import edu.xiyou.BCS.service.CrawlUrlService;
import edu.xiyou.andrew.Egg.fetcher.Fetcher;
import edu.xiyou.andrew.Egg.scheduler.HashSetScheduler;
import edu.xiyou.andrew.Egg.scheduler.Scheduler;
import edu.xiyou.andrew.Egg.utils.RegexRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrew on 15-12-16.
 * <p/>
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
            Page page = new Page(PageConstant.DEFAULT_CURRENT_PAGE, PageConstant.DEFAULT_PAGE_SIZE);
            crawlUrlList = crawlUrlService.selectBySelective(new CrawlUrl(),page).getList();
        } catch (Exception e) {
            crawlUrlList = Lists.newArrayList();
        }
    }

    private Html2BlogHandler handler;
    private Scheduler scheduler;

    public Spider(Html2BlogHandler handler, Scheduler scheduler) {
        this.handler = handler;
        this.scheduler = scheduler;
    }

    public Spider(Html2BlogHandler handler) {
        this(handler, new HashSetScheduler());
    }

    public Spider() {
        this(new Html2BlogHandler(), new HashSetScheduler());
    }

    public void fetch() {
        try {
            handler.init();
        } catch (Exception e) {
            LOG.error("handler init fail Exception={}", e);
        }
        final Fetcher fetcher = new Fetcher(scheduler, handler);
        fetcher.init();
        fetcher.before();

        boolean flag = true;
        List<String> seedList = Lists.newArrayList();
        List<String> regexPosite = Lists.newArrayList();

        for (CrawlUrl crawlUrl : crawlUrlList){
            if (System.currentTimeMillis() - crawlUrl.getCrawlDate().getTime() > crawlUrl.getIntervalTime()) {
                seedList.add(crawlUrl.getUrl());
                regexPosite.add(crawlUrl.getRegex());
            }
        }
        for (CrawlUrl crawlUrl : crawlUrlList) {
            if (System.currentTimeMillis() - crawlUrl.getCrawlDate().getTime() > crawlUrl.getIntervalTime()) {
                scheduler.offer(Collections.singletonList(crawlUrl.getUrl()));
                handler.setRegexRule(new RegexRule(Collections.singletonList(crawlUrl.getRegex())));
                if (flag) {
                    fetcher.fetch();
                    flag = false;
                }
            }

            while (scheduler.currentCount() != 0) {
                try {
                    Thread.sleep(5);
                    if (scheduler.currentCount() == 0) {
                        Thread.sleep(10);
                        if (scheduler.currentCount() == 0) {
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    LOG.error("fetch sleep error", e);
                }
            }
            scheduler.clear();
        }

        fetcher.after();
        while (!fetcher.isClose()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }


    public CrawlUrlService getCrawlUrlService() {
        return crawlUrlService;
    }

    public void setCrawlUrlService(CrawlUrlService crawlUrlService) {
        this.crawlUrlService = crawlUrlService;
    }

    public List<CrawlUrl> getCrawlUrlList() {
        return crawlUrlList;
    }

    public void setCrawlUrlList(List<CrawlUrl> crawlUrlList) {
        this.crawlUrlList = crawlUrlList;
    }

    public Html2BlogHandler getHandler() {
        return handler;
    }

    public void setHandler(Html2BlogHandler handler) {
        this.handler = handler;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
