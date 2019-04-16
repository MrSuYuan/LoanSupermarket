package jingcheng.LoanSupermarket.user.entity;

import java.util.Date;

/**
 * app版本信息
 */
public class AppVersion {

    /**
     * id
     */
    private Long id;
    /**
     * 版本号
     */
    private String versionCode;
    /**
     * 修改内容
     */
    private String changeContent;
    /**
     * 上线时间
     */
    private Date createTime;
    /**
     * 版本类型(1安卓 2iOS)
     */
    private int versionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getVersionType() {
        return versionType;
    }

    public void setVersionType(int versionType) {
        this.versionType = versionType;
    }
}
