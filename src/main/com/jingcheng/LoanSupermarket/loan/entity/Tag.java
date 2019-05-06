package jingcheng.LoanSupermarket.loan.entity;

/**
 * 贷款标签
 */
public class Tag {

    /**
     * id
     */
    private Long id;
    /**
     * 标签名称
     */
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
