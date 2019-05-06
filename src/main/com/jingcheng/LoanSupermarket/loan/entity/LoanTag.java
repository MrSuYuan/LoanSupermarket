package jingcheng.LoanSupermarket.loan.entity;

/**
 * 贷款信息关联标签
 */
public class LoanTag {

    /**
     * id
     */
    private Long id;
    /**
     * 贷款id
     */
    private Long loanId;
    /**
     * 标签id
     */
    private Long tagId;

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

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
