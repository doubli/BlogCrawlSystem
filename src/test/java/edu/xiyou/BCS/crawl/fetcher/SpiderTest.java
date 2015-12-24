package edu.xiyou.BCS.crawl.fetcher;

import com.google.common.collect.Lists;
import edu.xiyou.BCS.BaseTest;
import edu.xiyou.BCS.crawl.parser.Html2BlogHandler;
import edu.xiyou.BCS.crawl.parser.TestHtml2BlogHandler;
import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.service.CrawlBlogService;
import edu.xiyou.andrew.Egg.fetcher.Fetcher;
import edu.xiyou.andrew.Egg.scheduler.HashSetScheduler;
import edu.xiyou.andrew.Egg.scheduler.Scheduler;
import edu.xiyou.andrew.Egg.utils.RegexRule;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by andrew on 15-12-16.
 * <p/>
 * 对博客进行爬取
 * 默认scheduler是Egg的HashSetScheduler
 * 默认的Handler是 parser 包下的 Html2BlogHandler
 */


public class SpiderTest extends BaseTest{
    private final static Logger LOG = LoggerFactory.getLogger(Spider.class);

    @Resource
    private CrawlBlogService crawlBlogService;

    private List<CrawlUrl> crawlUrlList;

    @Before
    public void init(){
        CrawlUrl crawlUrl = new CrawlUrl();
        crawlUrl.setCrawlDate(new Date(0));
        crawlUrl.setUrl("http://blog.csdn.net/omsvip");
        crawlUrl.setRegex("http://blog.csdn.net/omsvip/article/details/[0-9]+\\b");
        crawlUrl.setIntervalTime(60);
        crawlUrlList = Collections.singletonList(crawlUrl);
        this.scheduler = new HashSetScheduler();
        this.handler = new Html2BlogHandler();
        handler.setCrawlBlogService(crawlBlogService);
        try {
            crawlBlogService.deleteAllRecords();
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage());
        }
    }

    private Html2BlogHandler handler;
    private Scheduler scheduler;

    @org.junit.Test
    public void fetch() throws InterruptedException {
        final Fetcher fetcher = new Fetcher(scheduler, handler);
        fetcher.init();
        fetcher.before();

        boolean flag = true;
        for (CrawlUrl crawlUrl : crawlUrlList) {
            if (System.currentTimeMillis() - crawlUrl.getCrawlDate().getTime() > crawlUrl.getIntervalTime()) {
                scheduler.offer(Collections.singletonList(crawlUrl.getUrl()));
                RegexRule regexRule = new RegexRule();
                regexRule.addPositive(crawlUrl.getRegex());
                handler.setRegexRule(regexRule);
                if (flag) {

                    fetcher.fetch();
                    flag = false;
                }
            }
//            scheduler.offer(Arrays.asList());
        }
//        fetcher.fetch();
        while (true) {
            System.out.println("scheduler count : " + scheduler.currentCount());
            if (scheduler.currentCount() != 0) {
                Thread.sleep(5);
            } else {
                Thread.sleep(10);
                if (scheduler.currentCount() == 0) {
                    break;
                }
            }
        }
        fetcher.after();
        while (!fetcher.isClose()) {
            try {
                System.out.println(" isclose ...........");
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }

//    public static void main(String[] args) {
//        SpiderTest spiderTest = new SpiderTest();
//        try {
//            spiderTest.fetch();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
