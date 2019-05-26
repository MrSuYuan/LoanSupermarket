package jingcheng.LoanSupermarket.loan.entity;

import java.util.Date;
import java.util.List;

/**
 * 贷款信息
 */
public class Loan {

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
     * 产品图(多张逗号拼接)
     */
    private String productUrl;
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
     * 贷款期限起始
     */
    private String deadlineStart;
    /**
     * 贷款期限结束
     */
    private String deadlineEnd;
    /**
     * 放款时间类型(1小时 2日 3月)
     */
    private int loanType;
    /**
     * 放款时间
     */
    private int loanTime;
    /**
     * 权重
     */
    private int weights;
    /**
     * 申请条件
     */
    private String applyTerm;
    /**
     * 申请材料
     */
    private String applyMaterial;
    /**
     * 备注
     */
    private String remark;
    /**
     * 标签
     */
    private String tags;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 使用状态(1正常 2禁用)
     */
    private int status;
    /**
     * 标签格式化集合
     */
    private List<Tag> tagList;
    /**
     * 收藏状态 0未收藏 1收藏
     */
    private int collectStatus;
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

    public int getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(int collectStatus) {
        this.collectStatus = collectStatus;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
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

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
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

    public String getDeadlineStart() {
        return deadlineStart;
    }

    public void setDeadlineStart(String deadlineStart) {
        this.deadlineStart = deadlineStart;
    }

    public String getDeadlineEnd() {
        return deadlineEnd;
    }

    public void setDeadlineEnd(String deadlineEnd) {
        this.deadlineEnd = deadlineEnd;
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

    public int getWeights() {
        return weights;
    }

    public void setWeights(int weights) {
        this.weights = weights;
    }

    public String getApplyTerm() {
        return applyTerm;
    }

    public void setApplyTerm(String applyTerm) {
        this.applyTerm = applyTerm;
    }

    public String getApplyMaterial() {
        return applyMaterial;
    }

    public void setApplyMaterial(String applyMaterial) {
        this.applyMaterial = applyMaterial;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
