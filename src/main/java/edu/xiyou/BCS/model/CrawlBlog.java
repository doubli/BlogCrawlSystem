package edu.xiyou.BCS.model;

import java.util.Date;

public class CrawlBlog {
    private Integer id;

    private String url;

    private String title;

    private String author;

    private Date writeDate;

    private Date createDate;

    private Date updateDate;

    private Integer vistorsNum;

    private Integer localVistorsNum;

    private String tag;

    private String category;

    private Boolean reprint;

    private String reprintUrl;

    private String reprintAuthor;

    private String other;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getVistorsNum() {
        return vistorsNum;
    }

    public void setVistorsNum(Integer vistorsNum) {
        this.vistorsNum = vistorsNum;
    }

    public Integer getLocalVistorsNum() {
        return localVistorsNum;
    }

    public void setLocalVistorsNum(Integer localVistorsNum) {
        this.localVistorsNum = localVistorsNum;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Boolean getReprint() {
        return reprint;
    }

    public void setReprint(Boolean reprint) {
        this.reprint = reprint;
    }

    public String getReprintUrl() {
        return reprintUrl;
    }

    public void setReprintUrl(String reprintUrl) {
        this.reprintUrl = reprintUrl == null ? null : reprintUrl.trim();
    }

    public String getReprintAuthor() {
        return reprintAuthor;
    }

    public void setReprintAuthor(String reprintAuthor) {
        this.reprintAuthor = reprintAuthor == null ? null : reprintAuthor.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}