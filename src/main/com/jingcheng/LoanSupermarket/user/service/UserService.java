package jingcheng.LoanSupermarket.user.service;

import jingcheng.utils.response.ReqResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户模块逻辑层接口
 */
public interface UserService {

    /**
     * 查看最近的启动页
     */
    ReqResponse startupPage();

    /**
     * 查看app版本号
     */
    ReqResponse appVersion(String device_type);

    /**
     * 发送短信验证码
     * type 1注册(查看手机号是否占用) 2找回密码(查看手机号是否存在)
     */
    ReqResponse sendMessage(HttpSession session, String userPhone, Integer type);

    /**
     * 验证短信验证码
     */
    ReqResponse verifyMessage(HttpSession session, String userPhone, String messageCode);

    /**
     * 账号注册
     */
    ReqResponse register(String device_type, String userPhone, String passWord);

    /**
     * 修改密码
     */
    ReqResponse passWord(String userPhone, String passWord);

    /**
     * 账号登陆
     */
    ReqResponse login(String userPhone, String passWord);

    /**
     * 添加意见反馈信息
     */
    ReqResponse feedback(Long userId, String userPhone, String content);

}
