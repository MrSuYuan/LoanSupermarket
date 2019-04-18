package jingcheng.utils.base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.jsonwebtoken.ExpiredJwtException;
import jingcheng.LoanSupermarket.user.entity.User;
import jingcheng.utils.exception.CustomException;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.token.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;



/**
 *
 * @ClassName:  BaseController
 * @Description: 所有的Controller必须都继承BaseController
 * @author: WinZhong
 * @date:   2017年6月19日 下午3:40:08
 */
public class BaseController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;


    /**
     * 接口请求信息
     */
    @ModelAttribute
    public void init(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
        logger.info("------------------------------拦截请求信息【开始】------------------------------");
        logger.info("浏览器信息："+request.getHeader("User-Agent"));
        logger.info("请求url："+request.getServletPath());
        logger.info("请求方式："+request.getMethod());
        Map<String, Object> map = findKeyMapByRequest(request);
        logger.info("请求参数1："+map);
        logger.info("请求参数2："+request.getQueryString());
        String token = request.getHeader("token");
        String sessionId = session.getId();
        logger.info("token："+token);
        logger.info("Session ID："+sessionId);
        logger.info("------------------------------拦截请求信息【结束】------------------------------");

        /**
         * 基础参数检测
         */
        //this.validateBasicParameters();
    }


    /**
     * 把request里面的参数转化成map
     */
    public Map<String, Object> findKeyMapByRequest(HttpServletRequest request) {
        Map<String, Object> keyMap = new HashMap<String, Object>();
        Enumeration<String> enu = request.getParameterNames();
        String[] item ;
        while (enu.hasMoreElements()) {
            String paramname = enu.nextElement();
            item = request.getParameterValues(paramname);
            if(item.length == 1){
                keyMap.put(paramname, item[0]);
            }else{
                keyMap.put(paramname, item);
            }
        }
        return keyMap;
    }


    /**
     *  基础参数检测
     */
    public void validateBasicParameters() {
        //设备类型（1：Android，2：IOS，3：微信小程序）：device_type
        String deviceType = request.getParameter("device_type");
        if(StringUtils.isBlank(deviceType)){
            throw new CustomException(ErrorMessage.PARAMETER_ILLEGAL.getMessage(),ErrorMessage.PARAMETER_ILLEGAL.getCode());
        }
        //API协议版本（示例：1.0.0）：version
        String version = request.getParameter("version");
        if(StringUtils.isBlank(version)){
            throw new CustomException(ErrorMessage.PARAMETER_ILLEGAL.getMessage(),ErrorMessage.PARAMETER_ILLEGAL.getCode());
        }
        //时间戳(格式为yyyy-MM-dd HH:mm:ss)：timestamp
        String timestamp = request.getParameter("timestamp");
        if(StringUtils.isBlank(timestamp)){
            throw new CustomException(ErrorMessage.PARAMETER_ILLEGAL.getMessage(),ErrorMessage.PARAMETER_ILLEGAL.getCode());
        }
        //签名：sign   (暂传非空字符串)
        String sign = request.getParameter("sign");
        if(StringUtils.isBlank(sign)){
            throw new CustomException(ErrorMessage.PARAMETER_ILLEGAL.getMessage(),ErrorMessage.PARAMETER_ILLEGAL.getCode());
        }
    }


    /**
     * 根据Header中的Token令牌获取用户登录信息
     */
    public Long getTokenUser() {
        //设备类型（1：Android，2：IOS，3：微信小程序）：device_type
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            return null;
        } else {
            //解密token
            String userId = TokenUtil.JudgementToken(token);
            if("error".equals(userId)){
                return null;
            }else{
                return Long.valueOf(userId);
            }
        }
    }
}