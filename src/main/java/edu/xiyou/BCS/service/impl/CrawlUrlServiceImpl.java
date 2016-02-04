package edu.xiyou.BCS.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.xiyou.BCS.dao.CrawlUrlMapper;
import edu.xiyou.BCS.model.CrawlUrl;
import edu.xiyou.BCS.service.CrawlUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by andrew on 15-12-8.
 */

@Service
public class CrawlUrlServiceImpl implements CrawlUrlService {

    private static final Logger LOG = LoggerFactory.getLogger(CrawlUrlService.class);

    @Resource
    private CrawlUrlMapper crawlUrlMapper;

    @Override
    public int insert(CrawlUrl record) throws Exception {
        LOG.info("insert crawlUrl : ", record);
        try {
            return crawlUrlMapper.insert(record);
        } catch (Exception e) {
            LOG.error("insert record={} error  Exception = {} " + record, e);
            throw new Exception("insert record={} error  Exception = {} " + record, e);
        }
    }

    @Override
    public PageInfo<CrawlUrl> selectBySelective(CrawlUrl record ,Page page) throws Exception {
        LOG.info("selectBySelective selective = {}", record);
        try {
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            PageInfo pageInfo = new PageInfo(crawlUrlMapper.selectBySelective(record));
            System.out.println(pageInfo.getList());
            return pageInfo;
        }catch (Exception e){
            LOG.error("selectBySelective selective = {}, Exception = {}" + record,  e);
            throw new Exception("selectBySelective selective = {}, Exception = {}" + record,  e);
        }
    }

    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        LOG.info("deleteByPrimaryKey id = {}",  id);
        try {
            return crawlUrlMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            LOG.error("deleteByPrimaryKey id = {}, Exception = {}" + id, e);
            throw new Exception("deleteByPrimaryKey id = {}, Exception = {}" + id, e);
        }
    }

    public CrawlUrlMapper getCrawlUrlMapper() {
        return crawlUrlMapper;
    }

    public void setCrawlUrlMapper(CrawlUrlMapper crawlUrlMapper) {
        this.crawlUrlMapper = crawlUrlMapper;
    }
}
