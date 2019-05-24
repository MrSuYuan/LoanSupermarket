package jingcheng.LoanSupermarket.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jingcheng.LoanSupermarket.user.entity.User;
import jingcheng.LoanSupermarket.user.service.UserService;
import jingcheng.utils.base.BaseController;
import jingcheng.utils.base.BasicParameters;
import jingcheng.utils.message.MessageUtil;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.response.ReqResponse;
import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/user")
@Api(value = "/user", tags = "用户模块接口")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping(value="startupPage", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "APP启动页图片", notes = "APP启动页图片", httpMethod = "POST")
    public ReqResponse startupPage(BasicParameters param){
        ReqResponse req = userService.startupPage();
        return req;
    }

    @RequestMapping(value="checkVersion", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查看APP版本信息", notes = "查看APP版本信息", httpMethod = "POST")
    public ReqResponse checkVersion(BasicParameters param){
        ReqResponse req = userService.appVersion(param.getDevice_type());
        return req;
    }

    @RequestMapping(value="sendMessage", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "发送短信", notes = "发送短信", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="type" , value="1注册 2找回密码" ,required = true , paramType = "query" ,dataType = "int")
    })
    @CrossOrigin
    public ReqResponse sendMessage(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String type = request.getParameter("type");
        ReqResponse req = new ReqResponse();
        try{
            req = userService.sendMessage(userPhone, Integer.valueOf(type));
        }catch(Exception e){
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("系统错误");
        }
        return req;
    }

    @RequestMapping(value="verifyMessage", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证短信验证码", notes = "验证短信验证码", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="messageCode" , value="短信验证码" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse verifyMessage(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String messageCode = request.getParameter("messageCode");
        ReqResponse req = userService.verifyMessage(userPhone, messageCode);
        return req;
    }

    @RequestMapping(value="register", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "账号注册", notes = "账号注册", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="passWord" , value="密码" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse register(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String passWord = request.getParameter("passWord");
        ReqResponse req = userService.register(param.getDevice_type(), userPhone, passWord);
        return req;
    }

    @RequestMapping(value="passWord", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改密码", notes = "修改密码", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="passWord" , value="密码" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse passWord(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String passWord = request.getParameter("passWord");
        ReqResponse req = userService.passWord(userPhone, passWord);
        return req;
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登陆", notes = "用户登陆", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="passWord" , value="密码" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse login(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String passWord = request.getParameter("passWord");
        ReqResponse req = userService.login(userPhone, passWord);
        return req;
    }

    @RequestMapping(value="feedback", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "意见反馈", notes = "意见反馈", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="content" , value="反馈内容" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="userId" , value="用户id" ,required = true , paramType = "query" ,dataType = "Long")
    })
    @CrossOrigin
    public ReqResponse feedback(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String userId = request.getParameter("userId");
        String content = request.getParameter("content");
        ReqResponse req = new ReqResponse();
        if(null == userId){
            req.setCode(ErrorMessage.INVALID_LOGIN.getCode());
            req.setCode("登录过期");
        }else{
            req = userService.feedback(Long.valueOf(userId), userPhone, content);
        }
        return req;
    }

    @RequestMapping(value="uploadUserUrl", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传头像(尚未完成)", notes = "上传头像", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="passWord" , value="密码" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse uploadUserUrl(BasicParameters param, String userPhone, String passWord){
        ReqResponse req = new ReqResponse();
        return req;
    }


    //发送短信
    public static void main(String[]args)throws ClientProtocolException, IOException {
        String code = MessageUtil.code();
        MessageUtil.sendMessage("18031924099",code);
    }
}
