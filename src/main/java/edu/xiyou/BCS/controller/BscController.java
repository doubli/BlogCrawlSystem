package edu.xiyou.BCS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.page.Page;
import edu.xiyou.BCS.service.CrawlUrlService;
import edu.xiyou.BCS.util.DateUtil;

@Controller
@RequestMapping("/")
public class BscController {
	
	private static final Logger LOG = Logger.getLogger(BscController.class);
	
	@Autowired
	private CrawlUrlService crawlUrlService;
	
	

	@RequestMapping(value="/addUrl",method=RequestMethod.POST)
	public String index(@Param(value = "url") String url,@Param(value = "regex") String regex){
		if ( url != null && !"".equals(url)) {
			CrawlUrl crawlUrl = new CrawlUrl();
			
			crawlUrl.setCreateDate(DateUtil.getNow());
			crawlUrl.setUpdateDate(DateUtil.getNow());
			crawlUrl.setCrawlDate(DateUtil.getNow());
			crawlUrl.setRegex(regex);
			crawlUrl.setUrl(url);
			crawlUrl.setIntervalTime(24 * 60 * 60);
			
			try {
				crawlUrlService.insert(crawlUrl);
			} catch (Exception e) {
				LOG.error("插入url:"+url+"失败！",e);
			}
		}
		return "redirect:/listUrls.do";  
	}
	
	@ResponseBody  
	@RequestMapping(value="/deleteUrl",method=RequestMethod.POST)
	public Map<String, String> listUrl(@Param(value = "id") int id){
		Map<String, String> model = new HashMap<String,String>();
		try {
			crawlUrlService.deleteByPrimaryKey(id);
			model.put("Msg","success");
		} catch (Exception e) {
			LOG.error("删除失败");
			model.put("Msg","fail");
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/listUrls",method={RequestMethod.POST,RequestMethod.GET})
	public String listUrl(Model model){
		List<CrawlUrl> urlList = null; 
		try {
			urlList = crawlUrlService.selectBySelective(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("urlList",urlList);
		return "main";
	}
}
