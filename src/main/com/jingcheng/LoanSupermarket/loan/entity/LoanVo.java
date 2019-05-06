package jingcheng.LoanSupermarket.loan.entity;

import java.util.List;

/**
 * 贷款展示列表
 */
public class LoanVo {

    /**
     * id
     */
    private Long id;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品封面图
     */
    private String productCoverUrl;
    /**
     * 跳转路径
     */
    private String jumpUrl;
    /**
     * 利率类型(2日 3月 4年)
     */
    private int rateType;
    /**
     * 利率
     */
    private double rate;
    /**
     * 额度范围起始值
     */
    private int amountMin;
    /**
     * 额度范围最大值
     */
    private int amountMax;
    /**
     * 放款时间类型(1小时 2日 3月)
     */
    private int loanType;
    /**
     * 放款时间
     */
    private int loanTime;
    /**
     * 标签字符串
     */
    private String tags;
    /**
     * 标签格式化集合
     */
    private List<Tag> tagList;
    /**
     * 申请人数
     */
    private int applyNum;

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCoverUrl() {
        return productCoverUrl;
    }

    public void setProductCoverUrl(String productCoverUrl) {
        this.productCoverUrl = productCoverUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getRateType() {
        return rateType;
    }

    public void setRateType(int rateType) {
        this.rateType = rateType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(int amountMin) {
        this.amountMin = amountMin;
    }

    public int getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(int amountMax) {
        this.amountMax = amountMax;
    }

    public int getLoanType() {
        return loanType;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

    public int getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(int loanTime) {
        this.loanTime = loanTime;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
