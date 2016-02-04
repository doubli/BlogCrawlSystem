package edu.xiyou.BCS.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.service.CrawlUrlService;
import edu.xiyou.BCS.util.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
	public String listUrl(Model model,int currentPage, int pageSize){
		PageInfo<CrawlUrl> dataList = null;
		System.out.println("当前的currentPage:"+currentPage+"|||pageSize:"+pageSize);
		String Msg = "ok";
		try {
			Page<CrawlUrl> page = new Page<CrawlUrl>(currentPage,pageSize);
			dataList = crawlUrlService.selectBySelective(null,page);
		} catch (Exception e) {
			e.printStackTrace();
			Msg = "error";
		}
		model.addAttribute("dataList",dataList);
		model.addAttribute("Msg",Msg);
		return "main";
	}
}
