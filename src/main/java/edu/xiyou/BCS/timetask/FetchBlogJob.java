package edu.xiyou.BCS.timetask;

import edu.xiyou.BCS.crawl.fetcher.Spider;
import edu.xiyou.BCS.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by andrew on 15-12-25.
 */
public class FetchBlogJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchBlogJob.class);

    public void work(){
        LOGGER.info("fetch job start");
        Long startTime = System.currentTimeMillis();
        Spider spider = new Spider();
        spider.fetch();
        Long endTime = System.currentTimeMillis();
        LOGGER.info(String.format("fetch job end, fetch Time: %s", DateUtil.parseDateToString(new Date(endTime - startTime))));
    }
}
