package jingcheng.utils.response;

/**
 * 系统错误信息定义
 * @Author: WinZhong
 * @Date: 2018/5/28 17:49
 * @Description:
 */
public enum ErrorMessage {

    /**
     * 成功
     */
    SUCCESS("0000","SUCCESS")
    /**
     * 参数不合法
     */
    ,PARAMETER_ILLEGAL("0004","参数不合法")
    /**
     * 系统处理错误
     */
    ,SYSTEM_ERROR("5000","系统处理错误")
    /**
     * 失败
     */
    ,FAIL("1500","失败")
    /**
     * 访问次数限制
     */
    ,REQUEST_LIMIT("1501","哎呀，您的访问过于频繁，很抱歉，现在暂时无法处理您的请求，请您过段时间再来访问吧！！！")
    /**
     * 无效的签名
     */
    ,INVALID_SIGN("1501","无效的签名")
    /**
     * 用户名或密码错误
     */
    ,ACCOUNT_PASSWORD_ERROR("1001","用户名或密码错误")
    /**
     * 用户未登录
     */
    ,USER_NO_LOGIN("1002","用户未登录")
    /**
     * 登陆已过期，请重新登陆
     */
    ,TOKEN_OVERDUE("1003","登陆已过期，请重新登陆")
    /**
     * 无效的登陆
     */
    ,INVALID_LOGIN("1004","无效的登陆")
    /**
     * 您的账号可能在他处登陆,您被迫下线,若不是您自己操作，那您的密码可能泄露，请更改密码
     */
    ,ELSEWHERE_LOGIN("1005","您的账号可能在他处登陆,您被迫下线,若不是您自己操作，那您的密码可能泄露，请更改密码")
    /**
     * 余额不足
     */
    ,BALANCE_INSUFFICIENT("1006","余额不足")
    /**
     * 登陆后未授权
     */
    ,AUTHORIZE_ERROR("1007","登陆后未授权")
    /**
     * 验证码错误
     */
    ,AUTHCODE_ERROR("1400","验证码错误")
    /**
     * 发布红包失败
     */
    ,redpacket_error("6003","发布红包失败")
    /**
     * 发布红包失败
     */
    ,redpacket_error2("6004","发布红包失败")
    /**
     * 发布红包失败
     */
    ,redpacket_error3("6005","发布红包失败")
    /**
     * 最新版本
     */
    ,NEW_VERSION("9999","已经是最新版本")
    /**
     * 账户被冻结
     */
    ,FREEZE_ERROR("1009","账户被冻结")
    ;

    //错误码
    private String code;
    //错误描述
    private String message;

    private ErrorMessage(String code,String message)
    {
        this.code=code;
        this.message=message;
    }

    /**
     * 错误描述
     * @return
     */
    public String getMessage()
    {
        return this.message;
    }
    /**
     * 错误码
     * @return
     */
    public String getCode() {
        return this.code;
    }




}
