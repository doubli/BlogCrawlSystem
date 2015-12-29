package edu.xiyou.BCS.crawl.parser;

import edu.xiyou.BCS.model.CrawlBlog;
import edu.xiyou.andrew.Egg.parser.Response;

public interface PageDigger {
	/**
	 * 
	 * @param resp
	 * @return
	 */
	public CrawlBlog getInfo(Response resp);
}
