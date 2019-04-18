package jingcheng.LoanSupermarket.card.entity;

/**
 * 银行信息
 */
public class Bank {

    /**
     * id
     */
    private Long bankId;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 银行图标
     */
    private String bankIcon;
    /**
     * 银行备注
     */
    private String bankRemark;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankIcon() {
        return bankIcon;
    }

    public void setBankIcon(String bankIcon) {
        this.bankIcon = bankIcon;
    }

    public String getBankRemark() {
        return bankRemark;
    }

    public void setBankRemark(String bankRemark) {
        this.bankRemark = bankRemark;
    }
}
