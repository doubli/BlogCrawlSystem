/**
 * CSDN博客网站的博客
 * 搜集所给的html页面的信息到对象中，并返回对象
 */
package edu.xiyou.BCS.crawl.parser.PageDiggerImpl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.xiyou.BCS.crawl.parser.PageDigger;
import edu.xiyou.BCS.model.CrawlBlog;
import edu.xiyou.BCS.util.DateUtil;
import edu.xiyou.andrew.Egg.parser.Response;

public class PageDiggerCSDN implements PageDigger{
	
	private  CrawlBlog cb = null;
	
	private static final Logger LOG = Logger.getLogger(PageDiggerCSDN.class);
	
	public PageDiggerCSDN(){
		this.cb = new CrawlBlog();
	}
	
	/**
	 *   获取页面上的信息
	 * @param resp
	 * @return CrawBlog对象
	 */
	public  CrawlBlog getInfo(Response resp){
		
		String content = new String(resp.getContent());
		
		Document document = Jsoup.parse(content);
		
		String url = resp.getUrl();
		
		
		cb.setUrl(url);
		LOG.info("url:"+url);
		
		//设置文章的标题title   title 的值为  使用FileUtils简化你的文件操作 - 蚂蚁的技术总结 - 博客频道 - CSDN.NET
		String title = document.title();
		cb.setTitle(title);
		LOG.info("title:"+title);
		
		//设置文章的内容 content
		String article_content = document.select("#article_content").html();
		cb.setContent(article_content);
		
		//设置author		 作者
		String author = document.select("#blog_userface .user_name").text();
		LOG.info("author:"+author);
		cb.setAuthor(author);
		
		//设置write_date 				文章发布的时间
		String writeDateStr = document.select(".link_postdate").text();
		Date writeDate = DateUtil.parseStringToDate(writeDateStr);//	格式 ：2014-08-01 16:15
		LOG.info("writeDate:"+writeDate);
		cb.setWriteDate(writeDate);
		
		//create_date 				文章加入数据库的时间   暂定相同
		Date create_date = DateUtil.getNow();
		LOG.info("create_date:"+create_date);
		cb.setCreateDate(create_date);
		
		//设置更新时间 ：update_date 				本条数据更新的时间    csdn 更新时间同创建时间
		Date update_date = DateUtil.getNow();
		LOG.info("update_date:"+update_date);
		cb.setUpdateDate(update_date);
		
		//local_vistors_num    		在本站中，该文章的浏览数目    初始是0
		LOG.info("local_vistors_num:"+0);
		cb.setLocalVistorsNum(0);
		
		//vistors_num 				原文章浏览者的数目     
		String vistorsNumStr = document.select(".link_view").text();
		Pattern patternNum = Pattern.compile("\\d+");
		Matcher matcherNum = patternNum.matcher(vistorsNumStr);
		Integer visitNumber = 0;
		if(matcherNum.find()){
			visitNumber = Integer.parseInt(matcherNum.group());
		}else{
			LOG.debug("Not found Number of visitor numbers");
		}
		LOG.info("visitNumber:"+visitNumber);
		cb.setVistorsNum(visitNumber);
		
		//tag 					文章的标签   分类  
		String tagStr = document.select(".link_categories a").text();
		LOG.info("tagStr:"+tagStr);
		tagStr = tagStr.replaceAll(" ", ",");
		cb.setTag(tagStr);
		
		//category 				文章分类
		String categoryStr = document.select(".category_r span").text();
		Pattern patternCategory = Pattern.compile("[a-zA-Z]*");
		Matcher matcherCategory = patternCategory.matcher(categoryStr);
		String category = "";
		if(matcherCategory.find()){
			category = matcherCategory.group();
		}else{
			LOG.debug("Not found category");
		}
		LOG.info("category:"+category);
		cb.setCategory(category);
		
		//reprint 					是否是转载 0:原创   1:转载    ico ico_type_Original
		Elements reprintElement = document.select(".ico ico_type_Repost");
		boolean reprintFlag = false;
		if(reprintElement != null){
			reprintFlag = true;
		}
		LOG.info("reprint:"+reprintFlag);
		cb.setReprint(reprintFlag);

		//reprint_author 			原创的作者   需要搜索url
		cb.setReprintAuthor("");
		
		//reprint_url 				原创的博客的地址
		cb.setReprintUrl("");
		
		return cb;
	}
	
}
