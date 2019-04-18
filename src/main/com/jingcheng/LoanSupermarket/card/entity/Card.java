package jingcheng.LoanSupermarket.card.entity;

/**
 * 信用卡
 */
public class Card {

    /**
     * id
     */
    private Long id;
    /**
     * 银行id
     */
    private Long bankId;
    /**
     * 卡片名称
     */
    private String cardName;
    /**
     * 跳转路径
     */
    private String jumpUrl;
    /**
     * 封面图
     */
    private String coverUrl;
    /**
     * 产品图(多张逗号拼接)
     */
    private String productUrl;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 等级(1普卡 2金卡 3白金卡)
     */
    private int level;
    /**
     * 币种(1人民币 2美元 3日元)
     */
    private int moneyType;
    /**
     * 发卡组织(1银联 2visa 3jcb 4运通)
     */
    private int cardOrganization;
    /**
     * 免息期限
     */
    private String interestFreePeriod;
    /**
     * 积分累计
     */
    private String pointTotal;
    /**
     * 积分期限
     */
    private String pointPeriod;
    /**
     * 年费类型(1终身免年费 2交易免年费)
     */
    private int annualFeeType;
    /**
     * 年费说明
     */
    private String annualFeeDescription;
    /**
     * 取现比例
     */
    private String CashWithdrawalRatio;
    /**
     * 取现费用
     */
    private String CashWithdrawalFee;
    /**
     * 最低还款
     */
    private String MinimumRepayment;

    /**
     * 特权(1航空保险 2健康保险 3机场贵宾服务 4健康服务 5汽车救援)
     */
    private int privilege;
    /**
     * 其他权益
     */
    private String otherPrivilege;
    /**
     * 申请卡资格及技巧
     */
    private String applySkill;
    /**
     * 其他详情
     */
    private String otherDetails;
    /**
     * 申请人数
     */
    private int applyNum;
    /**
     * 卡面类型(1商务 2卡通 3时尚 4炫酷 5简约 6清新 7传统 8主题)
     */
    private int cardCoverType;

    public int getCardCoverType() {
        return cardCoverType;
    }

    public void setCardCoverType(int cardCoverType) {
        this.cardCoverType = cardCoverType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(int moneyType) {
        this.moneyType = moneyType;
    }

    public int getCardOrganization() {
        return cardOrganization;
    }

    public void setCardOrganization(int cardOrganization) {
        this.cardOrganization = cardOrganization;
    }

    public String getInterestFreePeriod() {
        return interestFreePeriod;
    }

    public void setInterestFreePeriod(String interestFreePeriod) {
        this.interestFreePeriod = interestFreePeriod;
    }

    public String getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(String pointTotal) {
        this.pointTotal = pointTotal;
    }

    public String getPointPeriod() {
        return pointPeriod;
    }

    public void setPointPeriod(String pointPeriod) {
        this.pointPeriod = pointPeriod;
    }

    public int getAnnualFeeType() {
        return annualFeeType;
    }

    public void setAnnualFeeType(int annualFeeType) {
        this.annualFeeType = annualFeeType;
    }

    public String getAnnualFeeDescription() {
        return annualFeeDescription;
    }

    public void setAnnualFeeDescription(String annualFeeDescription) {
        this.annualFeeDescription = annualFeeDescription;
    }

    public String getCashWithdrawalRatio() {
        return CashWithdrawalRatio;
    }

    public void setCashWithdrawalRatio(String cashWithdrawalRatio) {
        CashWithdrawalRatio = cashWithdrawalRatio;
    }

    public String getCashWithdrawalFee() {
        return CashWithdrawalFee;
    }

    public void setCashWithdrawalFee(String cashWithdrawalFee) {
        CashWithdrawalFee = cashWithdrawalFee;
    }

    public String getMinimumRepayment() {
        return MinimumRepayment;
    }

    public void setMinimumRepayment(String minimumRepayment) {
        MinimumRepayment = minimumRepayment;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String getOtherPrivilege() {
        return otherPrivilege;
    }

    public void setOtherPrivilege(String otherPrivilege) {
        this.otherPrivilege = otherPrivilege;
    }

    public String getApplySkill() {
        return applySkill;
    }

    public void setApplySkill(String applySkill) {
        this.applySkill = applySkill;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }
}
