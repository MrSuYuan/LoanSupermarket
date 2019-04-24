package jingcheng.LoanSupermarket.loan.entity;

import java.util.Date;

/**
 * 贷款轮播页
 */
public class LoanCarousel {

    /**
     * id
     */
    private Long id;
    /**
     * 贷款id
     */
    private Long loanId;
    /**
     * 轮播图
     */
    private String carouselUrl;
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

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
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
