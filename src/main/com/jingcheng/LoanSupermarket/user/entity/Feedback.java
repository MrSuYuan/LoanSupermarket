package jingcheng.LoanSupermarket.user.entity;

import java.util.Date;

/**
 * 意见反馈信息
 */
public class Feedback {

    /**
     * id
     */
    private Long id;
    /**
     * 反馈用户
     */
    private Long userId;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 时间
     */
    private Date createTime;
    /**
     * 手机号
     */
    private String userPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
