package edu.xiyou.BCS.crawl.parser;

import com.google.common.collect.Lists;
import edu.xiyou.BCS.BaseTest;
import edu.xiyou.BCS.crawl.parser.PageDiggerImpl.PageDiggerCSDN;
import edu.xiyou.BCS.crawl.parser.PageDiggerImpl.PageDiggerITEYE;
import edu.xiyou.BCS.model.CrawlBlog;
import edu.xiyou.BCS.service.CrawlBlogService;
import edu.xiyou.andrew.Egg.parser.Response;
import edu.xiyou.andrew.Egg.parser.Handler;
import edu.xiyou.andrew.Egg.utils.RegexRule;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrew on 15-12-16.
 * <p/>
 * 博客抓取后，对抓取到的html进行处理，转化称本地所需的格式,它实现了爬虫Egg 的Handler 接口，
 * 它定义了抓取成功，失败，以及下一次抓取链接提取的操作
 */
public class TestHtml2BlogHandler  extends BaseTest implements Handler {
    private static final Logger LOGGER = LoggerFactory.getLogger(Html2BlogHandler.class);

    private RegexRule regexRule;

    private CrawlBlogService crawlBlogService;

    private AtomicInteger num = new AtomicInteger(0);

    @Override
    public void onSuccess(Response response) {
        CrawlBlog crawBlog = null;
        if (regexRule.satisfy(response.getUrl())){
            PageDigger pageDigger = null;

            if (response.getUrl().contains("blog.csdn.net")){
                pageDigger = new PageDiggerCSDN();
            }
            if (response.getUrl().contains("iteye.com")){
                pageDigger = new PageDiggerITEYE();
            }
            crawBlog = pageDigger != null ? pageDigger.getInfo(response) : null;
        }
        try {
            if (crawBlog != null) {
                crawlBlogService.insert(crawBlog);
            }
        } catch (Exception e) {
            LOGGER.error("function=onSuccess, insert fail url={}" + response.getUrl(), e);
        }
    }

    @Override
    public void onFail(Response response) {
        LOGGER.error("fetch fail url={}"+response.getUrl());
    }

    @Override
    public List<String> handleAndGetLinks(Response response) {
        List<String> list = Lists.newArrayList();
        Document document = Jsoup.parse(new String(response.getContent()), parseBaseUri(response.getUrl()));
        Elements links = document.select("a[href]");
        for (Element link : links) {
            String url = link.attr("abs:href");
            if (StringUtils.isNotEmpty(url) && (regexRule.satisfy(url))) {
                list.add(url);
            }
        }
        return list;
    }

    public RegexRule getRegexRule() {
        return regexRule;
    }

    public void setRegexRule(RegexRule regexRule) {
        this.regexRule = regexRule;
    }

    public AtomicInteger getNum() {
        return num;
    }

    public void setNum(AtomicInteger num) {
        this.num = num;
    }

    private String parseBaseUri(String url){
        int index = url.indexOf("/", 10);
        return url.substring(0, index);
    }

//    public static void main(String[] args) {
//        Html2BlogHandler handler = new Html2BlogHandler();
//        System.out.println(handler.parseBaseUri("http://blog.csdn.net/omsvip/article/details/9384396249"));
//    }


    public CrawlBlogService getCrawlBlogService() {
        return crawlBlogService;
    }

    public void setCrawlBlogService(CrawlBlogService crawlBlogService) {
        this.crawlBlogService = crawlBlogService;
    }
}
