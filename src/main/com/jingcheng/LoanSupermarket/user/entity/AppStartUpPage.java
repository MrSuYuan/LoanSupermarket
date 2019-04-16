package jingcheng.LoanSupermarket.user.entity;

import java.util.Date;

/**
 * 启动页
 */
public class AppStartUpPage {

    /**
     * id
     */
    private Long id;
    /**
     * 路径
     */
    private String pageUrl;
    /**
     * 创建时间
     */
     private Date createTime;
    /**
     * 使用状态(1正常 2禁用)
     */
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
