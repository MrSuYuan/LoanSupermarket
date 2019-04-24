package jingcheng.LoanSupermarket.loan.entity;

/**
 * 申请流程
 */
public class ApplyProcess {

    /**
     * id
     */
    private Long id;
    /**
     * 贷款id
     */
    private Long loanId;
    /**
     * 流程步骤
     */
    private String processStep;
    /**
     * 流程描述
     */
    private String processContent;
    /**
     * 流程顺序
     */
    private int sort;

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

    public String getProcessStep() {
        return processStep;
    }

    public void setProcessStep(String processStep) {
        this.processStep = processStep;
    }

    public String getProcessContent() {
        return processContent;
    }

    public void setProcessContent(String processContent) {
        this.processContent = processContent;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
