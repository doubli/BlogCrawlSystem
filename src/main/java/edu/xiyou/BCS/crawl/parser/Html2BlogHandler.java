package edu.xiyou.BCS.crawl.parser;

import edu.xiyou.andrew.Egg.parser.Response;
import edu.xiyou.andrew.Egg.parser.Handler;

import java.util.List;

/**
 * Created by andrew on 15-12-16.
 *
 * 博客抓取后，对抓取到的html进行处理，转化称本地所需的格式,它实现了爬虫Egg 的Handler 接口，
 * 它定义了抓取成功，失败，以及下一次抓取链接提取的操作
 */
public class Html2BlogHandler implements Handler{

    @Override
    public void onSuccess(Response response) {

    }

    @Override
    public void onFail(Response response) {

    }

    @Override
    public List<String> handleAndGetLinks(Response response) {
        return null;
    }

}
