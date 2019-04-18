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
    ,PARAMETER_ILLEGAL("1000","参数不合法")
    /**
     * 系统处理错误
     */
    ,SERVER_ERROR("5000","系统处理错误")
    /**
     * 失败
     */
    ,FAIL("4000","失败")
    /**
     * 用户未登录
     */
    ,USER_NO_LOGIN("2000","用户未登录")
    /**
     * 无效的登陆
     */
    ,INVALID_LOGIN("3000","无效的登陆")
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
