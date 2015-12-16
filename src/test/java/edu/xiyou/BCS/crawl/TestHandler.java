package edu.xiyou.BCS.crawl;

import edu.xiyou.andrew.Egg.parser.Handler;
import edu.xiyou.andrew.Egg.parser.LinksList;
import edu.xiyou.andrew.Egg.parser.Response;
import edu.xiyou.andrew.Egg.utils.FileUtils;
import edu.xiyou.andrew.Egg.utils.RegexRule;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrew on 15-12-16.
 */
public class TestHandler implements Handler{
    /**
     * 抓取成功是的操作
     * @param response
     */
    @Override
    public void onSuccess(Response response) {
        String path = "/home/andrew/Data/baike/data/";
        String fileName = path + System.nanoTime();
        try {
            FileUtils.write2File(new File(fileName), response.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 失败的操作
     * @param response
     */
    @Override
    public void onFail(Response response) {

    }

    /**
     * 获取下一次爬取页面的操作
     * @param response
     * @return
     */
    @Override
    public List<String> handleAndGetLinks(Response response) {
        LinksList list = new LinksList();
        RegexRule regexRule = new RegexRule();
        regexRule.addPositive(Collections.singletonList("http://baike.baidu.com/\\S+"));
        regexRule.addNegative("http://baike.baidu.com/redirect/\\S+");
        list.getLinkByA(Jsoup.parse(new String(response.getContent())), regexRule);
        return list;
    }
}
