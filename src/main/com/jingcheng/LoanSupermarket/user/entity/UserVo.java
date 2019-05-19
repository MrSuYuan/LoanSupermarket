package jingcheng.LoanSupermarket.user.entity;

import java.util.Date;

/**
 * 用户别表
 */
public class UserVo {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 手机号
     */
    private String userPhone;
    /**
     * 性别(0未知 1男 2女)
     */
    private Integer userSex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 注册端口(0未知 1安卓 2iOS)
     */
    private Integer registerMethod;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 用户状态(0禁用 1正常)
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRegisterMethod() {
        return registerMethod;
    }

    public void setRegisterMethod(Integer registerMethod) {
        this.registerMethod = registerMethod;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
