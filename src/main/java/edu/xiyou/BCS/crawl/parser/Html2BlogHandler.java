package edu.xiyou.BCS.crawl.parser;

import com.google.common.collect.Lists;
import edu.xiyou.andrew.Egg.parser.Response;
import edu.xiyou.andrew.Egg.parser.Handler;
import edu.xiyou.andrew.Egg.utils.RegexRule;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrew on 15-12-16.
 * <p/>
 * 博客抓取后，对抓取到的html进行处理，转化称本地所需的格式,它实现了爬虫Egg 的Handler 接口，
 * 它定义了抓取成功，失败，以及下一次抓取链接提取的操作
 */
public class Html2BlogHandler implements Handler {

    private RegexRule regexRule;

    private AtomicInteger num = new AtomicInteger(0);

    @Override
    public void onSuccess(Response response) {
        //提取需要的内容
//        System.out.println(new String(response.getContent()));


        System.out.println("fetch ok fetchNum = " + num.incrementAndGet());

    }

    @Override
    public void onFail(Response response) {

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
}
